document.addEventListener("DOMContentLoaded", () => {
	
	// 이미지를 넣을 요소 가져오기
    const dicomViewer = document.getElementById('image-viewer'); 
    let currentSeriesImages = []; // 현재 선택된 시리즈의 이미지 경로 배열
    let currentIndex = 0;
    let autoPlayInterval;
	
	// 썸네일클릭했을때 뷰어 활성화
	cornerstone.enable(dicomViewer);

	// canvas width 조절
	const canvas = dicomViewer.querySelector('canvas');
	canvas.style.width = '100%';

	// 토글 섹션 표시/숨김 및 DICOM 이미지 로드
    function toggleSection(buttonId, sectionId) {
        const button = document.getElementById(buttonId);
        const section = document.getElementById(sectionId);
        const allSections = document.querySelectorAll('.study-info, .past-info, .series-info, .report-info');
        const imageViewer = document.getElementById('image-viewer');

        button.addEventListener('click', () => {
        const isSectionVisible = section.classList.contains('show');

        // 모든 섹션에서 'show' 클래스 제거 (열었다 닫았다 가능)
        allSections.forEach(sec => sec.classList.remove('show'));
        
	        // 클릭된 섹션이 닫혀 있는 경우에만 열기
	        if (!isSectionVisible) {
	            section.classList.add('show');
	
	            // 시리즈 (series-info) 활성화된 경우 DICOM 이미지 로드 및 표시
	            if (sectionId === 'series-info') {
	                loadSeriesImages();
	            }
	        }
	    });
    } 

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
	
	// 버튼을 눌렀을 때 토글 호출 (표시/숨김)(각 버튼과 각 섹션을 연결하는 역할)
    toggleSection('toggle-info-btn', 'study-info');
    toggleSection('toggle-past-btn', 'past-info');
    toggleSection('toggle-series-btn', 'series-info');
    toggleSection('toggle-report-btn', 'report-info');

	// 토글 버튼을 눌렀을 때, 화면이 오버플로우되어 스크롤이 생기는 현상 방지
	const toggleButtons = [
		'toggle-info-btn',
		'toggle-past-btn',
		'toggle-series-btn',
		'toggle-report-btn'
	];

	toggleButtons.forEach(buttonId => {
		document.getElementById(buttonId).addEventListener('click', function() {
			const content = document.querySelector('.content');

			content.style.maxHeight = '90vh';
			content.style.overflow = 'auto';
			content.style.width = '100%';
		});
	});

    // 뷰어에서 이미지 로드 및 표시 함수
    function loadAndDisplayImage(index) {
		if (index < 0 || index >= currentSeriesImages.length) return;
		const imageId = currentSeriesImages[index];
        cornerstone.loadImage(imageId)
        .then(image => {
			cornerstone.displayImage(dicomViewer, image);
			console.log("큰화면에 썸네일 로드 성공 !:", imageId);
        })
        .catch(error => console.error("Image load error:", error));
    }
    
    // 큰 뷰 마우스 스크롤로 이미지 탐색
    dicomViewer.addEventListener('wheel', function(event) {
		event.preventDefault();
        if (event.deltaY > 0) {
			currentIndex = Math.min(currentIndex + 1, currentSeriesImages.length - 1);
        } else {
			currentIndex = Math.max(currentIndex - 1, 0);
        }
        loadAndDisplayImage(currentIndex);
    });
        
    // 큰 뷰 자동재생 기능
    document.getElementById('autoPlayButton').addEventListener('click', () => {
		if (autoPlayInterval) {
			clearInterval(autoPlayInterval);
			autoPlayInterval = null;
			document.getElementById('autoPlayButton').innerText = "자동재생 시작 ! ";
		} else {
			autoPlayInterval = setInterval(() => {
				currentIndex = (currentIndex + 1) % currentSeriesImages.length;
				loadAndDisplayImage(currentIndex);
			}, 100); // 0.5초 간격으로 이미지 재생
				document.getElementById('autoPlayButton').innerText = "자동재생 중지 ! ";
		}
	});
			
});
	
