document.addEventListener("DOMContentLoaded", () => {
	// 코너스톤 각종 라이브러리 설정 추가
	cornerstoneWADOImageLoader.external.cornerstone = cornerstone;
	cornerstoneTools.external.cornerstone = cornerstone;
	cornerstoneTools.external.cornerstoneMath = cornerstoneMath;
	cornerstoneTools.external.Hammer = Hammer;
	//cornerstoneTools.init();
	
	// cornerstoneWADOImageLoader 기본 설정
	cornerstoneWADOImageLoader.configure({
		beforeSend: function(xhr) {
			xhr.setRequestHeader('Accept', 'application/dicom');
		}
	});
	
	// 이미지 요소 가져오기
    const dicomViewer = document.getElementById('image-viewer'); 
    let currentSeriesImages = []; // 현재 선택된 시리즈의 이미지 경로 배열
    let currentIndex = 0;
    let autoPlayInterval;
    let mode = "default"; // 기본 모드 설정: default, navigation, zoom

	// 썸네일클릭했을때 뷰어 활성화
	cornerstone.enable(dicomViewer);
	// cornerstoneTools 초기화(활성화시 커서 변경 true)
	cornerstoneTools.init({ showSVGCursors: true });

	// 길이 측정 도구를 특정 요소에 추가
	cornerstoneTools.addToolForElement(dicomViewer, cornerstoneTools.LengthTool);
	cornerstoneTools.addToolForElement(dicomViewer, cornerstoneTools.AngleTool);
	cornerstoneTools.addToolForElement(dicomViewer, cornerstoneTools.WwwcTool);
	cornerstoneTools.addToolForElement(dicomViewer, cornerstoneTools.PanTool);
	cornerstoneTools.addToolForElement(dicomViewer, cornerstoneTools.MagnifyTool);
	cornerstoneTools.addToolForElement(dicomViewer, cornerstoneTools.ZoomTool);
	cornerstoneTools.addToolForElement(dicomViewer, cornerstoneTools.EraserTool);
	cornerstoneTools.addToolForElement(dicomViewer, cornerstoneTools.RotateTool);	
  
   // 썸네일 클릭 시 이미지 로드 및 표시
    document.querySelectorAll(".dicomImage").forEach((element, index) => {
		element.addEventListener("click", () => {						
			const seriesKey = element.getAttribute("data-series-key");
			fetch(`/series/images?studyKey=${studyKey}&seriesKey=${seriesKey}`)
			.then(response => {
				if (!response.ok) {
					throw new Error("네트워크 응답에 문제가 있습니다.");
				}
				return response.json(); // JSON 형식으로 변환
			})
			
			.then(data => {
				currentSeriesImages = data;
				currentIndex = 0;
				loadAndDisplayImage(currentIndex);
			})
			.catch(error => console.error("썸네일 클릭시 뷰에 이미지 로드 에러:", error));
		});
	});

	//썸네일 클릭 시 뷰어 활성화
	function loadSeriesImages() {    
	    document.querySelectorAll(".dicomImage").forEach((element, index) => {
			
			const imagePath = imagePaths[index]?.imagePath;
			if (imagePath && imagePath.startsWith("wadouri:")) {
				cornerstone.enable(element); // 썸네일 요소 활성화
				
				cornerstone.loadImage(imagePath)
				.then(image => {
					cornerstone.displayImage(element, image); // 썸네일 이미지 표시
					console.log("썸네일 로드 성공 ~: " + imagePath);
				})
				.catch(error => {
					console.error("썸네일 로드 에러 ㅠ :", error);
				});
			} else {
			console.error("잘못된 이미지 경로 형식 :", imagePath);
		}});
	}

/*
    // 뷰어에서 이미지 로드 및 표시 함수
    function loadAndDisplayImage(index) {
		if (index < 0 || index >= currentSeriesImages.length) return;
		const imageId = currentSeriesImages[index];
        cornerstone.loadImage(imageId)
        
        .then(image => {
			
			cornerstone.displayImage(dicomViewer, image);
			mainTools(dicomViewer); //mainTools.js 호출
			console.log("큰화면에 썸네일 로드 성공 !:", imageId);
        })
        .catch(error => console.error("Image load error:", error));
    }
*/

    // 뷰어에서 이미지 로드 및 표시 함수
    function loadAndDisplayImage(index) {
		if (index < 0 || index >= currentSeriesImages.length) return;
		const imageId = currentSeriesImages[index];
        cornerstone.loadImage(imageId)
        
        .then(image => {
			cornerstone.displayImage(dicomViewer, image);
			mainTools(dicomViewer); //mainTools.js 호출
			console.log("큰화면에 썸네일 로드 성공 !:", imageId);
        })
        .catch(error => console.error("Image load error:", error));
    }
    
  // 마우스 휠 이벤트 리스너
    dicomViewer.addEventListener("wheel", function (event) {
        event.preventDefault();

        // 기본 탐색 동작 (버튼을 누르지 않았을 때)
        if (!mode || mode === "default" || mode === "navigation") {
            if (event.deltaY > 0) {
                currentIndex = Math.min(currentIndex + 1, currentSeriesImages.length - 1);
            } else {
                currentIndex = Math.max(currentIndex - 1, 0);
            }
            loadAndDisplayImage(currentIndex);
        } else if (mode === "zoom") {
            // 줌 모드
            const viewport = cornerstone.getViewport(dicomViewer);
            if (event.deltaY > 0) {
                viewport.scale = Math.max(viewport.scale - 0.1, 0.1); // 축소
            } else {
                viewport.scale += 0.1; // 확대
            }
            cornerstone.setViewport(dicomViewer, viewport);
        }
    });
    
	// 뷰 자동재생 기능
    document.getElementById('playClip').addEventListener('click', () => {		
		if (autoPlayInterval) {
			clearInterval(autoPlayInterval);
			autoPlayInterval = null;
			document.getElementById('playClip').innerText = "자동재생 시작 ! ";
		} else {
			autoPlayInterval = setInterval(() => {
				currentIndex = (currentIndex + 1) % currentSeriesImages.length;
				loadAndDisplayImage(currentIndex);
			}, 100); // 0.5초 간격으로 이미지 재생
				document.getElementById('playClip').innerText = "자동재생 중지 ! ";
		}
	});	
/*
    // 뷰 마우스 스크롤로 이미지 탐색
    dicomViewer.addEventListener('wheel', function(event) {
		event.preventDefault();
        if (event.deltaY > 0) {
			currentIndex = Math.min(currentIndex + 1, currentSeriesImages.length - 1);
        } else {
			currentIndex = Math.max(currentIndex - 1, 0);
        }
        loadAndDisplayImage(currentIndex);
    });
*/
});
