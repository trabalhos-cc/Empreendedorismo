import Geolocation from '../ol/Geolocation.js';
import Map from '../ol/Map.js';
import Overlay from '../ol/Overlay.js';
import View from '../ol/View.js';
import LineString from '../ol/geom/LineString.js';
import TileLayer from '../ol/layer/Tile.js';
import {fromLonLat} from '../ol/proj.js';
import OSM from '../ol/source/OSM.js';

var geolocation = new ol.Geolocation({
    projection: map.getView().getProjection(),
    tracking: true,
    trackingOptions: {
      enableHighAccuracy: true,
      maximumAge: 2000  
    }
  });

  var iconStyle = new ol.style.Style({
    image: new ol.style.Icon({
      anchor: [0.5, 100],
      anchorXUnits: 'fraction',
      anchorYUnits: 'pixels',
      opacity: 1.0,
      src: './_img/marker_.png'
       })
      });

// add an empty iconFeature to the source of the layer
  var iconFeature = new ol.Feature();   
  var iconSource = new ol.source.Vector({
    features: [iconFeature]
  });    
  var iconLayer = new ol.layer.Vector({
    source: iconSource,
    style : iconStyle
  });    
  map.addLayer(iconLayer); 

  geolocation.on('change', function() {
    var pos = geolocation.getPosition();
    iconFeature.setGeometry(new ol.geom.Point(pos));
    view.setCenter(pos);
    view.setZoom(18); 
  });