// 코너스톤 라이브러리 관련 파일들
document.addEventListener("DOMContentLoaded", () => {
	
	// 코너스톤 각종 라이브러리 설정 추가
	cornerstoneWADOImageLoader.external.cornerstone = cornerstone;
	
	// cornerstoneWADOImageLoader 기본 설정
	cornerstoneWADOImageLoader.configure({
		beforeSend: function(xhr) {
			xhr.setRequestHeader('Accept', 'application/dicom');
		}
	});
	
});