function mainTools() {
	const dicomViewer = document.getElementById('image-viewer');
	// 썸네일클릭했을때 뷰어 활성화
	cornerstone.enable(dicomViewer); // 썸네일클릭했을때 뷰어 활성화
	cornerstoneWADOImageLoader.external.cornerstone = cornerstone;
	cornerstoneTools.external.cornerstone = cornerstone;
	cornerstoneTools.external.cornerstoneMath = cornerstoneMath;
	cornerstoneTools.external.Hammer = Hammer;
	cornerstoneTools.init({ showSVGCursors: true }); // cornerstoneTools 초기화(활성화시 커서 변경 true)

	// 뷰 줌 인
	document.getElementById('zoomIn').addEventListener('click', function () {
	    zoomIn(dicomViewer);
	});
	
	// 뷰 줌 아웃
	document.getElementById('zoomOut').addEventListener('click', function () {
	    zoomOut(dicomViewer);
	});
	
	//밝기 조절
	document.getElementById('windowLevel').addEventListener('click', function () {
		enableWwwcTool(dicomViewer);
	});
	
	//흑백 전환
	document.getElementById('invert').addEventListener('click', function () {
		invert(dicomViewer);
	});
	
	//시리즈 레이아웃
	/*document.getElementById('seriesLayout').addEventListener('click', function () {
		seriesLayout();
	});*/
	
	// "이전" 버튼 이벤트 리스너
    document.getElementById('prevButton').addEventListener('click', () => {
		mode = "navigation"
        if (currentIndex > 0) {
            currentIndex -= 1;
            loadAndDisplayImage(currentIndex);
        }
    });
    
    // "다음" 버튼 이벤트 리스너
    document.getElementById('nextButton').addEventListener('click', () => {
		mode = "navigation"
        if (currentIndex < currentSeriesImages.length - 1) {
            currentIndex += 1;
            loadAndDisplayImage(currentIndex);
        }
    });
	
    document.getElementById('angle').addEventListener('click', function () {
    	enableAngle(dicomViewer); // enableAngle 호출
    	});

	//드레그 활성화
	document.getElementById('drag').addEventListener('click', function () {
		 enableDrag(dicomViewer);
	});
	
	//지우개 기능 활성화
	document.getElementById('eraser').addEventListener('click', function () {
        enableEraser(dicomViewer); // Eraser 도구 활성화
    });
    
    // 수평 플립 버튼 이벤트 리스너
    document.getElementById('hFlip').addEventListener('click', function () {
        flipHorizontal(dicomViewer);
        console.log("이미지가 수평으로 뒤집어졌습니다.");
    });
    
    // 수직 플립 버튼 이벤트 리스너
    document.getElementById('vFlip').addEventListener('click', function () {
        flipVertical(dicomViewer);
        console.log("이미지가 수직으로 뒤집어졌습니다.");
    });
   
    //길이 축정 버튼 이벤트 리스너
    document.getElementById('length').addEventListener('click', function () {
        enableLength(dicomViewer); // 길이 측정 도구 활성화
        console.log("길이 측정 도구 활성화 상태가 전환되었습니다.");
    });
    
   // 확대 버튼 이벤트 리스너
    document.getElementById('magnify').addEventListener('click', function () {
        enableMagnify(dicomViewer); // 확대 도구 활성화
        console.log("확대 도구 활성화 상태가 전환되었습니다.");
    });
    
    // 이미지 초기화 버튼 이벤트 리스너
    document.getElementById('reset').addEventListener('click', function () {
        resetImage(dicomViewer); // 이미지 초기화
        console.log("이미지가 초기화되었습니다.");
    });
    
    // 왼쪽 회전 버튼 이벤트 리스너
    document.getElementById('lRotate').addEventListener('click', function () {
        rotateLeft(dicomViewer);
        console.log("이미지가 왼쪽으로 90도 회전했습니다.");
    });
    
    // 오른쪽 회전 버튼 이벤트 리스너
    document.getElementById('rRotate').addEventListener('click', function () {
        rotateRight(dicomViewer);
        console.log("이미지가 오른쪽으로 90도 회전했습니다.");
    });
    
    initializeImageLayout();    
}
