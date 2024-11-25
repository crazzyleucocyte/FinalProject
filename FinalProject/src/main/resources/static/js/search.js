let selectIndex = -1;
let currentPage = 0;

// 검색 버튼 클릭 시 호출되는 함수
document.querySelector(".search-btn").addEventListener("click", function () {
	currentPage = 0;  // 페이지 초기화
	performSearch();
});

// 더보기 버튼 클릭 이벤트
document.getElementById("load-more-btn").addEventListener("click", function () {
	currentPage += 1;  // 다음 페이지 로드
	performSearch();
});

function performSearch() {
	const startDate = document.getElementById("startDate").value;
	const endDate = document.getElementById("endDate").value;
	const modality = document.getElementById("modality").value;
	const verifyFlag = document.getElementById("verifyFlag").value;
	const reportStatus = document.getElementById("reportStatus").value;
	const pId = document.getElementById("pId").value;
	const pName = document.getElementById("pName").value;

	axios.post(`/search?page=${currentPage}`, {
		pId: pId,
		pName: pName,
		modality: modality,
		startDate: startDate,
		endDate: endDate,
		reportStatus: reportStatus,
		verifyFlag: verifyFlag
	})
		.then(result => {
			const studies = result.data.content;  // 현재 페이지 데이터
			const totalPages = result.data.totalPages;
			const totalElements = result.data.totalElements;	// 총 검사 건수
			const studyResultContainer = document.querySelector(".result-table-result");

			// 총 검사 건수를 #inspections에 표시
			document.getElementById("inspections").innerHTML = totalElements;

			if (currentPage === 0) {
				studyResultContainer.innerHTML = "";  // 첫 페이지일 때 기존 내용 초기화
			}

			studies.forEach((study, i) => {
				
				const row = document.createElement("div");
				row.classList.add('result-table-tbody');
				row.classList.add(`selected${currentPage}${i}`);
				if (i % 2 === 1) row.classList.add('odd');
				
				row.innerHTML = `
					<span>${study.pid}</span>
					<span>${study.pname}</span>
					<span>${study.modality}</span>
					<span>${study.studyDesc}</span>
					<span>${study.studyDate}</span>
					<span>${study.reportStatus === 3 ? '읽지않음' : (study.reportStatus === 5 ? '예비판독' : (study.reportStatus === 6 ? '판독' : '알수없음'))}</span>
					<span>${study.seriesCnt}</span>
					<span>${study.imageCnt}</span>
					<span>${study.verifyFlag === 0 ? '미요청' : (study.verifyFlag === 1 ? '요청완료' : '알 수 없음')}</span>
				`;

				// 클릭 시, 환자 ID, 환자 이름 업데이트 이벤트 추가
				row.addEventListener('click', function () {
					document.getElementById("patient-id-item").textContent = study.pid;
					document.getElementById("patient-name-item").textContent = study.pname;
				});
		
				row.addEventListener('dblclick', function () {
					location.href = `/series?studyKey=${study.studyKey}`;
				});
			
				row.addEventListener('click', function (e) {
					let number = e.target.parentElement.classList[1].substr(8,2);
					console.log("number : ", number);
					
					if (selectIndex === -1) {
						document.querySelector(`.selected${currentPage}${i}`).classList.add("selected");
						selectIndex = number;
					} else if (selectIndex !== i) {
						document.querySelector(`.selected${selectIndex}`).classList.remove("selected");
						document.querySelector(`.selected${number}`).classList.add("selected");
						selectIndex = number;
					}

					document.getElementById("aiFinding").innerHTML = study.aiFinding || '';
					document.getElementById("aiReport").innerHTML = study.aiReport || '';
					document.getElementById("operatorsName").innerHTML = study.operatorsName || '';
					document.getElementById("viewPosition").innerHTML = study.viewPosition || '';
					document.getElementById("bodyPart").innerHTML = study.bodyPart || '';
					document.getElementById("studyDesc").innerHTML = study.studyDesc || '';
					document.getElementById("history-patient-id").innerHTML = study.pid;
					document.getElementById("history-patient-name").innerHTML = study.pname;

					axios.get(`/study/history/${study.patientKey}`)
						.then((result) => {
							const patientHistory = result.data;
							const historyResultContainer = document.querySelector(".history-table-result");
							historyResultContainer.innerHTML = "";  // 초기화

							patientHistory.forEach((patient, i) => {
								const row = document.createElement("div");
								row.classList.add('history-table-tbody');
								if (i % 2 === 1) row.classList.add('odd');

								row.innerHTML = `
				                                    <span>${patient.modality}</span>
													<span>${patient.studyDesc}</span>
													<span>${patient.studyDate}</span>
													<span>${patient.reportStatus === 3 ? '읽지않음' : (patient.reportStatus === 5 ? '예비판독' : (patient.reportStatus === 6 ? '판독' : '알수없음'))}</span>
													<span>${patient.seriesCnt}</span>
													<span>${patient.verifyFlag === 0 ? '미요청' : (patient.verifyFlag === 1 ? '요청완료' : '알 수 없음')}</span>
												`;
								row.addEventListener('click', function () {
									location.href = `/series?studyKey=${patient.studyKey}`;
									// `/series?studyKey=${study.studyKey}`;
								});
								historyResultContainer.appendChild(row);
							});
						})
						.catch(error => console.log(error));
				});

				studyResultContainer.appendChild(row);
			});

			// '더보기' 버튼 표시 여부 결정
			const loadMoreBtn = document.getElementById("load-more-btn");
			if (currentPage + 1 < totalPages) {
				loadMoreBtn.style.display = "block";
			} else {
				loadMoreBtn.style.display = "none";
			}
		})
		.catch(error => console.log(error));
}