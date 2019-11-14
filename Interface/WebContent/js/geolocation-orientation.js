 
import Geolocation from '../src/ol/Geolocation.js';
import Map from '../src/ol/Map.js';
import Overlay from '../src/ol/Overlay.js';
import View from '../src/ol/View.js';
import LineString from '../src/ol/geom/LineString.js';
import TileLayer from '../src/ol/layer/Tile.js';
import {fromLonLat} from '../src/ol/proj.js';
import OSM from '../ol/source/OSM.js';

// creating the view
const view = new View({
  center: fromLonLat([5.8713, 45.6452]),
  zoom: 19
});

const tileLayer = new TileLayer({
  source: new OSM()
});

// creating the map
const map = new Map({
  layers: [tileLayer],
  target: 'map',
  view: view
});

// Geolocation marker
const markerEl = document.getElementById('geolocation_marker');
const marker = new Overlay({
  positioning: 'center-center',
  element: markerEl,
  stopEvent: false
});
map.addOverlay(marker);

// LineString to store the different geolocation positions. This LineString
// is time aware.
// The Z dimension is actually used to store the rotation (heading).
const positions = new LineString([], 'XYZM');

// Geolocation Control
const geolocation = new Geolocation({
  projection: view.getProjection(),
  trackingOptions: {
    maximumAge: 10000,
    enableHighAccuracy: true,
    timeout: 600000
  }
});

let deltaMean = 500; // the geolocation sampling period mean in ms

// Listen to position changes
geolocation.on('change', function() {
  const position = geolocation.getPosition();
  const accuracy = geolocation.getAccuracy();
  const heading = geolocation.getHeading() || 0;
  const speed = geolocation.getSpeed() || 0;
  const m = Date.now();

  addPosition(position, heading, m, speed);

  const coords = positions.getCoordinates();
  const len = coords.length;
  if (len >= 2) {
    deltaMean = (coords[len - 1][3] - coords[0][3]) / (len - 1);
  }

  const html = [
    'Position: ' + position[0].toFixed(2) + ', ' + position[1].toFixed(2),
    'Accuracy: ' + accuracy,
    'Heading: ' + Math.round(radToDeg(heading)) + '&deg;',
    'Speed: ' + (speed * 3.6).toFixed(1) + ' km/h',
    'Delta: ' + Math.round(deltaMean) + 'ms'
  ].join('<br />');
  document.getElementById('info').innerHTML = html;
});

geolocation.on('error', function() {
  alert('geolocation error');
  // FIXME we should remove the coordinates in positions
});

// convert radians to degrees
function radToDeg(rad) {
  return rad * 360 / (Math.PI * 2);
}
// convert degrees to radians
function degToRad(deg) {
  return deg * Math.PI * 2 / 360;
}
// modulo for negative values
function mod(n) {
  return ((n % (2 * Math.PI)) + (2 * Math.PI)) % (2 * Math.PI);
}

function addPosition(position, heading, m, speed) {
  const x = position[0];
  const y = position[1];
  const fCoords = positions.getCoordinates();
  const previous = fCoords[fCoords.length - 1];
  const prevHeading = previous && previous[2];
  if (prevHeading) {
    let headingDiff = heading - mod(prevHeading);

    // force the rotation change to be less than 180°
    if (Math.abs(headingDiff) > Math.PI) {
      const sign = (headingDiff >= 0) ? 1 : -1;
      headingDiff = -sign * (2 * Math.PI - Math.abs(headingDiff));
    }
    heading = prevHeading + headingDiff;
  }
  positions.appendCoordinate([x, y, heading, m]);

  // only keep the 20 last coordinates
  positions.setCoordinates(positions.getCoordinates().slice(-20));

  // FIXME use speed instead
  if (heading && speed) {
    markerEl.src = 'data/geolocation_marker_heading.png';
  } else {
    markerEl.src = 'data/geolocation_marker.png';
  }
}

// recenters the view by putting the given coordinates at 3/4 from the top or
// the screen
function getCenterWithHeading(position, rotation, resolution) {
  const size = map.getSize();
  const height = size[1];

  return [
    position[0] - Math.sin(rotation) * height * resolution * 1 / 4,
    position[1] + Math.cos(rotation) * height * resolution * 1 / 4
  ];
}

let previousM = 0;
function updateView() {
  // use sampling period to get a smooth transition
  let m = Date.now() - deltaMean * 1.5;
  m = Math.max(m, previousM);
  previousM = m;
  // interpolate position along positions LineString
  const c = positions.getCoordinateAtM(m, true);
  if (c) {
    view.setCenter(getCenterWithHeading(c, -c[2], view.getResolution()));
    view.setRotation(-c[2]);
    marker.setPosition(c);
  }
}

// geolocate device
const geolocateBtn = document.getElementById('geolocate');
geolocateBtn.addEventListener('click', function() {
  geolocation.setTracking(true); // Start position tracking

  tileLayer.on('postrender', updateView);
  map.render();

  disableButtons();
}, false);

// simulate device move
let simulationData;
const client = new XMLHttpRequest();
client.open('GET', 'data/geolocation-orientation.json');


/**
 * Handle data loading.
 */
client.onload = function() {
  simulationData = JSON.parse(client.responseText).data;
};
client.send();

const simulateBtn = document.getElementById('simulate');
simulateBtn.addEventListener('click', function() {
  const coordinates = simulationData;

  const first = coordinates.shift();
  simulatePositionChange(first);

  let prevDate = first.timestamp;
  function geolocate() {
    const position = coordinates.shift();
    if (!position) {
      return;
    }
    const newDate = position.timestamp;
    simulatePositionChange(position);
    window.setTimeout(function() {
      prevDate = newDate;
      geolocate();
    }, (newDate - prevDate) / 0.5);
  }
  geolocate();

  tileLayer.on('postrender', updateView);
  map.render();

  disableButtons();
}, false);

function simulatePositionChange(position) {
  const coords = position.coords;
  geolocation.set('accuracy', coords.accuracy);
  geolocation.set('heading', degToRad(coords.heading));
  const projectedPosition = fromLonLat([coords.longitude, coords.latitude]);
  geolocation.set('position', projectedPosition);
  geolocation.set('speed', coords.speed);
  geolocation.changed();
}

function disableButtons() {
  geolocateBtn.disabled = 'disabled';
  simulateBtn.disabled = 'disabled';
}

////import 'ol/ol.css';
////import Feature from 'ol/Feature';
////import Geolocation from 'ol/Geolocation';
////import Map from 'ol/Map';
////import View from 'ol/View';
////import Point from 'ol/geom/Point';
////import {Tile as TileLayer, Vector as VectorLayer} from 'ol/layer';
////import {OSM, Vector as VectorSource} from 'ol/source';
////import {Circle as CircleStyle, Fill, Stroke, Style} from 'ol/style';
////
////var view = new View({
////  center: [0, 0],
////  zoom: 2
////});
////
////var map = new Map({
////  layers: [
////    new TileLayer({
////      source: new OSM()
////    })
////  ],
////  target: 'map',
////  view: view
////});
////
////var geolocation = new Geolocation({
////  // enableHighAccuracy must be set to true to have the heading value.
////  trackingOptions: {
////    enableHighAccuracy: true
////  },
////  projection: view.getProjection()
////});
////
////function el(id) {
////  return document.getElementById(id);
////}
////
////el('track').addEventListener('change', function() {
////  geolocation.setTracking(this.checked);
////});
////
////// update the HTML page when the position changes.
////geolocation.on('change', function() {
////  el('accuracy').innerText = geolocation.getAccuracy() + ' [m]';
////  el('altitude').innerText = geolocation.getAltitude() + ' [m]';
////  el('altitudeAccuracy').innerText = geolocation.getAltitudeAccuracy() + ' [m]';
////  el('heading').innerText = geolocation.getHeading() + ' [rad]';
////  el('speed').innerText = geolocation.getSpeed() + ' [m/s]';
////});
////
////// handle geolocation error.
////geolocation.on('error', function(error) {
////  var info = document.getElementById('info');
////  info.innerHTML = error.message;
////  info.style.display = '';
////});
////
////var accuracyFeature = new Feature();
////geolocation.on('change:accuracyGeometry', function() {
////  accuracyFeature.setGeometry(geolocation.getAccuracyGeometry());
////});
////
////var positionFeature = new Feature();
////positionFeature.setStyle(new Style({
////  image: new CircleStyle({
////    radius: 6,
////    fill: new Fill({
////      color: '#3399CC'
////    }),
////    stroke: new Stroke({
////      color: '#fff',
////      width: 2
////    })
////  })
////}));
////
////geolocation.on('change:position', function() {
////  var coordinates = geolocation.getPosition();
////  positionFeature.setGeometry(coordinates ?
////    new Point(coordinates) : null);
////});
////
////new VectorLayer({
////  map: map,
////  source: new VectorSource({
////    features: [accuracyFeature, positionFeature]
////  })
////});
//
//(window.webpackJsonp=window.webpackJsonp||[]).push([[48],{
//	290:function(e,t,n){
//		"use strict";
//		n.r(t);
//		var a=n(168),o=n(3),i=n(78),r=n(2),d=n(34),c=n(5),s=n(4),g=n(9),
//		u=new r.a({
//			center:Object(s.f)([5.8713,45.6452]),zoom:19
//			}),
//		l=new c.a({
//			source:new g.b
//			}),
//		m=new o.a({
//			layers:[l],target:"map",view:u
//			}),
//		p=document.getElementById("geolocation_marker"),
//		h=new i.a({
//			positioning:"center-center",
//			element:p,
//			stopEvent:!1
//			});
//		m.addOverlay(h);
//
//		var v=new d.a([],"XYZM"),
//
//		f=new a.a({
//			projection:u.getProjection(),
//			trackingOptions:{
//				maximumAge:1e4,
//				enableHighAccuracy:!0,
//				timeout:6e5
//			}
//		}),w=500;
//		f.on("change",function(){
//			var e=f.getPosition(),
//			t=f.getAccuracy(),
//			n=f.getHeading()||0,a=f.getSpeed()||0;
//			!function(e,t,n,a){
//				var o=e[0],i=e[1],
//				r=v.getCoordinates(),
//				d=r[r.length-1],
//				c=d&&d[2];
//				if(c){
//					var s=t-(c%(2*Math.PI)+2*Math.PI)%(2*Math.PI);
//					if(Math.abs(s)>Math.PI)s=-(s>=0?1:-1)*(2*Math.PI-Math.abs(s));
//					t=c+s}v.appendCoordinate([o,i,t,n]),
//					v.setCoordinates(v.getCoordinates().slice(-20)),
//					p.src=t&&a?"img/geolocation_marker_heading.png":"img/geolocation_marker.png" //caminho ate WebContent
//			}
//			(e,n,Date.now(),a);
//			var o=v.getCoordinates(),i=o.length;
//			i>=2&&(w=(o[i-1][3]-o[0][3])/(i-1));
//			
//			var r,
//			d=["Position: " + e[0].toFixed(2) + ", " + e[1].toFixed(2),
//				"Accuracy: " + t,
//				"Heading: " + Math.round((r=n,360*r/(2*Math.PI))) + "&deg;",
//				"Speed: " + (3.6*a).toFixed(1) + " km/h",
//				"Delta: " + Math.round(w) + "ms"]
//			.join("<br />");
//			document.getElementById("info").innerHTML=d}),
//			f.on("error",function(){alert("geolocation error")});
//		
//		var M=0;function b(){
//			var e=Date.now()-1.5*w;
//			e=Math.max(e,M),
//			M=e;
//			var t,n,a,o,i=v.getCoordinateAtM(e,!0);
//			i&&(u.setCenter((t=i,n=-i[2],a=u.getResolution(),
//					o=m.getSize()[1],
//					[t[0] - Math.sin(n)*o*a*1/4,t[1]+Math.cos(n)*o*a*1/4])),
//					u.setRotation(-i[2]),h.setPosition(i))
//		}
//		var y,
//		I=document.getElementById("geolocate");
//		I.addEventListener("click",function(){
//			f.setTracking(!0),l.on("postrender",b),m.render(),C()
//		},!1);
//
//		var P=new XMLHttpRequest;
//
//		P.open("GET","json/geolocation-orientation.json"),
//
//		P.onload=function(){
//			y=JSON.parse(P.responseText).data
//		},
//
//		P.send();
//
//		var k=document.getElementById("simulate");
//
//		function E(e){
//			var t=e.coords;
//			f.set("accuracy",t.accuracy),
//			f.set("heading",t.heading*Math.PI*2/360);
//			var n=Object(s.f)([t.longitude,t.latitude]);
//			f.set("position",n),f.set("speed",t.speed),
//			f.changed()
//		}
//
//		function C(){
//			I.disabled="disabled",
//			k.disabled="disabled"
//		}
//
//		k.addEventListener("click",function(){
//			var e=y,t=e.shift();
//			E(t);
//			var n=t.timestamp;
//			!function t(){
//				var a=e.shift();
//				if(a){
//					var o=a.timestamp;
//					E(a),
//					window.setTimeout(function(){
//						n=o,t()
//					},(o-n)/.5)
//				}
//			}(),
//			l.on("postrender",b),
//			m.render(),
//			C()
//		},!1)
//	}
//},[[290,0]]]);
//////# sourceMappingURL=geolocation-orientation.js.map