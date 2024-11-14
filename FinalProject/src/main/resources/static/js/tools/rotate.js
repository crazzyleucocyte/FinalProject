// lRotate 버튼 이벤트 함수
function rotateLeft(dicomElement) {
	const viewport = cornerstone.getViewport(dicomElement);
	viewport.rotation-=90;
	cornerstone.setViewport(dicomElement, viewport);
}

// rRotate 버튼 이벤트 함수
function rotateRight(dicomElement) {
	const viewport = cornerstone.getViewport(dicomElement);
	    viewport.rotation+=90;
	    cornerstone.setViewport(dicomElement, viewport);
}