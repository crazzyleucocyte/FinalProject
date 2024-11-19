// hFlip 버튼 이벤트 함수
function flipHorizontal(dicomElement) {
	const viewport = cornerstone.getViewport(dicomElement);
	    viewport.hflip = !viewport.hflip;  // 수평 플립 토글
	    cornerstone.setViewport(dicomElement, viewport);
}

// vFlip 버튼 이벤트 함수
function flipVertical(dicomElement) {
	const viewport = cornerstone.getViewport(dicomElement);
	viewport.vflip = !viewport.vflip;
	cornerstone.setViewport(dicomElement, viewport);
}

