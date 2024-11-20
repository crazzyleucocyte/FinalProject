function mainTools() {
	const dicomViewer = document.getElementById('image-viewer');
	// 썸네일클릭했을때 뷰어 활성화
	cornerstone.enable(dicomViewer);
	cornerstoneWADOImageLoader.external.cornerstone = cornerstone;
	cornerstoneTools.external.cornerstone = cornerstone;
	cornerstoneTools.external.cornerstoneMath = cornerstoneMath;
	cornerstoneTools.external.Hammer = Hammer;
	cornerstoneTools.init();	

	// 뷰 줌 인
	document.getElementById('zoomIn').addEventListener('click', function () {
	    zoomIn(dicomViewer);
	    
	});
	
	// 뷰 줌 아웃
	document.getElementById('zoomOut').addEventListener('click', function () {
	    zoomOut(dicomViewer);
	    
	});
	
	//밝기 조절
	document.getElementById('windowLevel').addEventListener('click', function () {
		enableWwwcTool(dicomViewer);
	});
	
	//흑백 전환
	document.getElementById('invert').addEventListener('click', function () {
		invert(dicomViewer);
	});	
	
	//시리즈 레이아웃
	document.getElementById('seriesLayout').addEventListener('click', function () {
		seriesLayout(dicomViewer);
	});	
	
	
}
