// 모든 도구 버튼의 활성화 상태를 관리하는 공통 함수
function deactivateAllTools(dicomElement) {
	
	// 모든 도구 비활성화
	cornerstoneTools.setToolDisabledForElement(dicomElement, 'Angle');
	cornerstoneTools.setToolDisabledForElement(dicomElement, 'Pan');
	cornerstoneTools.setToolDisabledForElement(dicomElement, 'Eraser');
	cornerstoneTools.setToolDisabledForElement(dicomElement, 'Length');
	cornerstoneTools.setToolDisabledForElement(dicomElement, 'Magnify');
	cornerstoneTools.setToolDisabledForElement(dicomElement, 'Rotate');
	cornerstoneTools.setToolDisabledForElement(dicomElement, 'Zoom');
	cornerstoneTools.setToolDisabledForElement(dicomElement, 'Wwwc');
	
}