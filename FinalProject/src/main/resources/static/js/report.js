// 리포트
document.addEventListener("DOMContentLoaded", () => {
	// 홈 로고 클릭 시 홈으로 이동
	document.getElementById('home').addEventListener('click', function () {
		window.location.href = 'http://localhost:8080/home';
	});

	axios.get(`/report/${studyKey}`)
	.then(response => {
		const data = response.data;
		// 코멘트, 작성자, 작성날짜 뷰에 보여주기
	    if (data) {
	        document.getElementById('comment').value = data.reportComment || '';
	        document.getElementById('radiologist1').value = data.userName || '';
	        document.getElementById('report-date').value = data.reportTime || '날짜 정보 없음';
	    }})
	    .catch(error => console.error('헤헤 에러났다', error));
	
	// 리포트 내 저장 버튼 클릭 시 현재 시간 YYYY-MM-DDTHH:MM:SS 형식으로 서버로 전송
	document.getElementById('save-report').addEventListener('click', function () {
	    const now = new Date();
	    const reportTime = new Date().toISOString().slice(0, 19).replace("T", "T");
		
	    // 저장할 리포트 데이터를 하나의 객체로 묶어서 준비
	    const reportData = {
	        studyKey: studyKey, 
	        reportComment: document.getElementById('comment').value,
	        userName: document.getElementById('radiologist1').value,
	        reportTime: reportTime
	    };
	
	    axios.post('/report/save', reportData)
	        .then(response => {
	            console.log('Report saved:', response.data);
	            alert('저장되었습니다!');
	        })
	        .catch(error => {
	            console.error('Error:', error);
	            alert('저장에 실패했습니다.');
	        });
	});

	// 리포트 - 코멘트 영역에 기본 텍스트
	document.getElementById('comment').value = "[Finding]\n\n\n[Conclusion]\n\n\n[Recommend]\n\n\n";

    // 리포트 - 코멘트 영역에 기본 텍스트 지우기
    document.getElementById('delete-report').addEventListener('click', function () {
        document.getElementById('comment').value = '[Finding]\n\n\n[Conclusion]\n\n\n[Recommend]\n\n\n';
    });
});