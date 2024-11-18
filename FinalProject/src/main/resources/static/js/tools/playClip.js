function playClip(dicomVieWer) {
	const dicomViewer = document.getElementById('image-viewer'); 
	let currentSeriesImages = []; // 현재 선택된 시리즈의 이미지 경로 배열
    let currentIndex = 0;
    let autoPlayInterval;
    
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
}