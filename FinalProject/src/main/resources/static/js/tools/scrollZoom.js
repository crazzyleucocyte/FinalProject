let zoomEnabled = false;

function enableScrollZoom(dicomElement) {
	deactivateAllTools(dicomElement);
	zoomEnabled = !zoomEnabled;
	
	if (zoomEnabled) {
        // 길이 측정 도구 활성화 및 상태 저장
        cornerstoneTools.setToolActiveForElement(dicomElement, 'Zoom', { mouseButtonMask: 1 });
        cornerstoneTools.addToolState(dicomElement, 'Zoom', {});  // 도구 상태 저장
        document.getElementById('scrollZoom').classList.add('active'); // 버튼 활성화 표시

        // 도구 상태 즉시 확인 - Length 기능이 활성화 됐는지 확인
        const toolState = cornerstoneTools.getToolState(dicomElement, 'Zoom');
        if (toolState && toolState.data && toolState.data.length > 0) {
            console.log('도구 "Zoom" 활성화 상태 확인:', toolState.data);
        } else {
            console.log('도구 "Zoom" 상태: 비활성화 또는 데이터 없음');
        }
    } else {
        // 길이 측정 도구 비활성화
        cornerstoneTools.setToolDisabledForElement(dicomElement, 'Zoom');
        document.getElementById('scrollZoom').classList.remove('active'); // 버튼 비활성화 표시
        console.log('도구 "Zoom" 상태 비활성화됨');
    }
}

