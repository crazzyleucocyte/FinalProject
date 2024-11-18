let eraserEnabled = false;

function enableEraser(dicomElement) {
	deactivateAllTools(dicomElement);
	eraserEnabled = !eraserEnabled;
	
	if (eraserEnabled) {
        // 길이 측정 도구 활성화 및 상태 저장
        cornerstoneTools.setToolActiveForElement(dicomElement, 'Eraser', { mouseButtonMask: 1 });
		cornerstoneTools.addToolState(dicomElement, 'Eraser', {
		                visible: true,
		                active: false,
		                color: undefined,
		                invalidated: true,
		                uuid: 'default-uuid', // uuid 초기화
		                handles: {
		                    points: [] // 필요한 경우 초기화
		                }
		            });
        document.getElementById('eraser').classList.add('active'); // 버튼 활성화 표시

        // 도구 상태 즉시 확인 - Length 기능이 활성화 됐는지 확인
        const toolState = cornerstoneTools.getToolState(dicomElement, 'Angle');
        if (toolState && toolState.data && toolState.data.length > 0) {
            console.log('도구 "Eraser" 활성화 상태 확인:', toolState.data);
        } else {
            console.log('도구 "Eraser" 상태: 비활성화 또는 데이터 없음');
        }
    } else {
        // 길이 측정 도구 비활성화
        cornerstoneTools.setToolDisabledForElement(dicomElement, 'Eraser');
        document.getElementById('eraser').classList.remove('active'); // 버튼 비활성화 표시
        console.log('도구 "Eraser" 비활성화됨');
    }
}

