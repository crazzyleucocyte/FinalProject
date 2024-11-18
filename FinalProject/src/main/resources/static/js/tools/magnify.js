let magnifyEnabled = false;  // 이미지 이동(드래그) 기능이 활성화되었는지 여부

function enableMagnify(dicomElement) {
	deactivateAllTools(dicomElement);
	magnifyEnabled = !magnifyEnabled;
	
	if (magnifyEnabled) {
        // 길이 측정 도구 활성화 및 상태 저장
        cornerstoneTools.setToolActiveForElement(dicomElement, 'Magnify', { mouseButtonMask: 1 });
        cornerstoneTools.addToolState(dicomElement, 'Magnify', {});  // 도구 상태 저장
        document.getElementById('magnify').classList.add('active'); // 버튼 활성화 표시
		
        // 도구 상태 즉시 확인 - Length 기능이 활성화 됐는지 확인
        const toolState = cornerstoneTools.getToolState(dicomElement, 'Magnify');
        if (toolState && toolState.data && toolState.data.length > 0) {
            console.log('도구 "Magnify" 활성화 상태 확인:', toolState.data);
        } else {
            console.log('도구 "Magnify" 상태: 비활성화 또는 데이터 없음');
        }
    } else {
        // 길이 측정 도구 비활성화
        cornerstoneTools.setToolDisabledForElement(dicomElement, 'Magnify');
        document.getElementById('magnify').classList.remove('active'); // 버튼 비활성화 표시
        console.log('도구 "Magnify" 상태 비활성화됨');
    }
}