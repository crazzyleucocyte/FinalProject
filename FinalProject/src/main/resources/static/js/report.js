// 리포트
document.addEventListener("DOMContentLoaded", () => {
	// 홈 로고 클릭 시 홈으로 이동
	document.getElementById('home').addEventListener('click', function () {
		window.location.href = `http://${serverIp}:8080/home`;
	});
	document.getElementById('logout').addEventListener('click', function () {
		window.location.href = `http://${serverIp}:8080/logout`;
	});

	axios.get(`/report/${studyKey}`)
	.then(response => {
		const data = response.data;
		console.log("report.js 12", data)
		// 코멘트, 작성자, 작성날짜 뷰에 보여주기
	    if (data.reportTime != null) {
	        document.getElementById('comment').value = data.reportComment || '';
	        document.getElementById('radiologist1').value = data.userName || '';
	        document.getElementById('report-date').value = data.reportTime || '날짜 정보 없음';
	    }else{
			// if(data.reportTime){
				console.log("reportTime : ", data.reportTime)
				console.log("리포트 데이터 없음")
			// }
			// 리포트 - 코멘트 영역에 기본 텍스트
			document.getElementById('comment').value = "[Finding]\n\n\n[Conclusion]\n\n\n[Recommend]\n\n\n";
		}
	    })
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

	

    // 리포트 - 코멘트 영역에 기본 텍스트 지우기
    document.getElementById('delete-report').addEventListener('click', function () {
		if(confirm('해당 리포트를 삭제하시겠습니까?')){

			axios.delete(`/report/delete/${studyKey}`)
			.then(data=>{
				console.log("report delete", data)
				document.getElementById('comment').value = '[Finding]\n\n\n[Conclusion]\n\n\n[Recommend]\n\n\n';
				document.getElementById('radiologist1').value ='';
	        	document.getElementById('report-date').value ='';
			})
			alert('삭제가 완료되었습니다!')
		}
        
    });
});