document.addEventListener("DOMContentLoaded", () => {
	const dicomViewer = document.getElementById('image-viewer');

   // 토글 섹션 표시/숨김
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

   //썸네일 활성화
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

   // 버튼을 눌렀을 때 토글 호출 (표시/숨김)(각 버튼과 각 섹션을 연결하는 역할)
    toggleSection('toggle-info-btn', 'study-info');
    toggleSection('toggle-past-btn', 'past-info');
    toggleSection('toggle-series-btn', 'series-info');
    toggleSection('toggle-report-btn', 'report-info');   
});