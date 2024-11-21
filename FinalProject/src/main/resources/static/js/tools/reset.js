function resetImage(dicomElement) {
	cornerstone.reset(dicomElement);
	// 모든 도구 비활성화
	cornerstoneTools.setToolDisabledForElement(element, 'Angle');
	cornerstoneTools.setToolDisabledForElement(element, 'Pan');
	cornerstoneTools.setToolDisabledForElement(element, 'Eraser');
	cornerstoneTools.setToolDisabledForElement(element, 'Length');
	cornerstoneTools.setToolDisabledForElement(element, 'FreeHandRoi');
	cornerstoneTools.setToolDisabledForElement(element, 'Magnify');
	cornerstoneTools.setToolDisabledForElement(element, 'Rotate');
	cornerstoneTools.setToolDisabledForElement(element, 'Zoom');
	cornerstoneTools.setToolDisabledForElement(element, 'Wwwc');
	
}
