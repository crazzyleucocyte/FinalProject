// zoomIn 버튼 이벤트 함수
function zoomIn(dicomViewer) {
	const viewport = cornerstone.getViewport(dicomViewer);
	viewport.scale += 0.25;
	cornerstone.setViewport(dicomViewer, viewport);
}

// zoomOut 버튼 이벤트 함수
function zoomOut(dicomViewer) {
	const viewport = cornerstone.getViewport(dicomViewer);
	viewport.scale -= 0.25;
	cornerstone.setViewport(dicomViewer, viewport);	
}