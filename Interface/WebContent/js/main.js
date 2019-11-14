window.onload = init;

function init() {
	const map = new ol.Map({
		view : new ol.View({
			center : [-6077519.708130797, -2929317.5777599094],
			zoom : 17,
			maxZoom : 16,
			minZoom : 7
		}),

		layers : [ new ol.layer.Tile({
			source : new ol.source.OSM()
		}) ],

		target : 'map'

	})

	map.on('click', function(e){
		console.log(e.coordinate);
	})

}