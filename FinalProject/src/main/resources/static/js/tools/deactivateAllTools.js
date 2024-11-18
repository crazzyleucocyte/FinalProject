// 모든 도구 버튼의 활성화 상태를 관리하는 공통 함수
function deactivateAllTools(dicomElement) {
	// 모든 버튼에서 'active' 클래스를 제거하여 초기화
	const buttons = document.querySelectorAll('.tools-container-ul .btn');

	buttons.forEach(button => {
	    button.classList.remove('active');
	});
	
	// 모든 도구 비활성화
	//cornerstoneTools.setToolDisabledForElement(dicomElement, 'Angle');
	cornerstoneTools.setToolDisabledForElement(dicomElement, 'Pan');
	//cornerstoneTools.setToolDisabledForElement(dicomElement, 'Eraser');
	//cornerstoneTools.setToolDisabledForElement(dicomElement, 'Length');
	cornerstoneTools.setToolDisabledForElement(dicomElement, 'Magnify');
	cornerstoneTools.setToolDisabledForElement(dicomElement, 'Rotate');
	cornerstoneTools.setToolDisabledForElement(dicomElement, 'Zoom');
	cornerstoneTools.setToolDisabledForElement(dicomElement, 'Wwwc');
	
}