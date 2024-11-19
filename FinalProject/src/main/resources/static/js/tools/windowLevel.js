let windowLevelEnabled = false; // 윈도우 레벨 기능 초기화

function enableWwwcTool(dicomViewer) {
	windowLevelEnabled = !windowLevelEnabled;
	
	if(windowLevelEnabled) {
		cornerstoneTools.setToolActiveForElement(dicomViewer, 'Wwwc', { mouseButtonMask: 1 });
		cornerstoneTools.addToolState(dicomViewer, 'Wwwc', {});
		document.getElementById('windowLevel').classList.add('active');

		// 도구 상태 즉시 확인 - Length 기능이 활성화 됐는지 확인
        const toolState = cornerstoneTools.getToolState(dicomViewer, 'Wwwc');
        if (toolState && toolState.data && toolState.data.length > 0) {
            console.log('도구 "Wwwc" 활성화 상태 확인:', toolState.data);
        } else {
            console.log('도구 "Wwwc" 상태: 비활성화 또는 데이터 없음');
        };
		
	} else {
        // 길이 측정 도구 비활성화
        cornerstoneTools.setToolDisabledForElement(dicomViewer, 'Wwwc');
        document.getElementById('windowLevel').classList.remove('active'); // 버튼 비활성화 표시
        console.log('도구 "Wwwc" 상태 비활성화됨');
    }
}

