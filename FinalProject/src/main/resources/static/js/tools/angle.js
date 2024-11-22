let angleToolEnabled = false;

function enableAngle(dicomElement) {
	console.log("angle_enableAngle : ", dicomElement)
	deactivateAllTools(dicomElement);
	angleToolEnabled = !angleToolEnabled;

	if (angleToolEnabled) {
		// 길이 측정 도구 활성화 및 상태 저장
		cornerstoneTools.setToolActiveForElement(dicomElement, 'Angle', { mouseButtonMask: 1 });
		cornerstoneTools.addToolState(dicomElement, 'Angle', {
			visible: true,
			active: false,
			color: undefined,
			invalidated: true,
			handles: {
				start: { x: 0, y: 0, highlight: true, active: false },
				middle: { x: 0, y: 0, highlight: true, active: false },
				end: { x: 0, y: 0, highlight: true, active: true },
				textBox: {
					active: false,
					hasMoved: false,
					movesIndependently: false,
					drawnIndependently: true,
					allowedOutsideImage: true,
					hasBoundingBox: true,
				}
			}
		});
		document.getElementById('angle').classList.add('active');

		// 도구 상태 즉시 확인 - Length 기능이 활성화 됐는지 확인
		const toolState = cornerstoneTools.getToolState(dicomElement, 'Angle');
		if (toolState && toolState.data && toolState.data.length > 0) {
			console.log('도구 "Angle" 활성화 상태 확인:', toolState.data);
		} else {
			console.log('도구 "Angle" 상태: 비활성화 또는 데이터 없음');
		}
	} else {
		// 길이 측정 도구 비활성화
		cornerstoneTools.setToolDisabledForElement(dicomElement, 'Angle');
		document.getElementById('angle').classList.remove('active');
		console.log('도구 "Angle" 상태 비활성화됨');
	}
}

