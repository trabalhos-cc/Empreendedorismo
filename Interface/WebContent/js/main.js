window.onload = init;

function init() {

	const view = new ol.View({
		center : [-6077519.708130797, -2929317.5777599094],
		zoom: 15,
		minZoom: 9,
		maxZoom: 20,
	});

	const map = new ol.Map({

		view : view,

		layers : [ new ol.layer.Tile({
			source: new ol.source.OSM()
		})],

		target : 'map'

	});

	map.on('click', function(e){
		console.log(e.coordinate);
	});

	var geolocation = new ol.Geolocation({
		tracking: true,
		trackingOptions: {
			enableHighAccuracy: true
		},
		projection: view.getProjection()
	});

	var iconStyle = new ol.style.Style({
		image: new ol.style.Circle({
			radius: 6,
			fill: new ol.style.Fill({
				color: '#3399CC'
			}),
			stroke: new ol.style.Stroke({
				color: '#fff',
				width: 2
			})
		})
	});

	var iconFeature = new ol.Feature();   
	var iconSource = new ol.source.Vector({
		features: [iconFeature]
	});    

	var iconLayer = new ol.layer.Vector({
		source: iconSource,
		style : iconStyle
	});    
	map.addLayer(iconLayer); 

	geolocation.on('change:position', function() {
		var pos = geolocation.getPosition();
		iconFeature.setGeometry(new ol.geom.Point(pos));
		map.getView().fit(iconFeature.getGeometry());
		map.getView().setZoom(4); 
	});
	
}