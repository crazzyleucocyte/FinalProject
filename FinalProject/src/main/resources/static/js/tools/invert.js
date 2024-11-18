// invert(흑백전환) 버튼 이벤트 함수
function invert(dicomViewer) {
	const viewport = cornerstone.getViewport(dicomViewer);
	viewport.invert = !viewport.invert;
	cornerstone.setViewport(dicomViewer, viewport);
}