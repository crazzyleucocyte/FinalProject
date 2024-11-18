let dragEnabled = false;  // 이미지 이동(드래그) 기능이 활성화되었는지 여부

function enableDrag(dicomElement) {
	deactivateAllTools(dicomElement);
	dragEnabled = !dragEnabled;
	
	if (dragEnabled) {
        // 길이 측정 도구 활성화 및 상태 저장
        cornerstoneTools.setToolActiveForElement(dicomElement, 'Pan', { mouseButtonMask: 1 });
        cornerstoneTools.addToolState(dicomElement, 'Pan', {});  // 도구 상태 저장
        document.getElementById('drag').classList.add('active'); // 버튼 활성화 표시

        // 도구 상태 즉시 확인 - Length 기능이 활성화 됐는지 확인
        const toolState = cornerstoneTools.getToolState(dicomElement, 'Pan');
        if (toolState && toolState.data && toolState.data.length > 0) {
            console.log('도구 "Pan" 활성화 상태 확인:', toolState.data);
        } else {
            console.log('도구 "Pan" 상태: 비활성화 또는 데이터 없음');
        }
    } else {
        // 길이 측정 도구 비활성화
        cornerstoneTools.setToolDisabledForElement(dicomElement, 'Pan');
        document.getElementById('drag').classList.remove('active'); // 버튼 비활성화 표시
        console.log('도구 "Pan" 상태 비활성화됨');
    }
}