// 시리즈 레이아웃 생성 (그리드 형태)
// seriesLayout 함수: 버튼 그리드 레이아웃을 생성하고 화면에 표시하는 함수
/*
document.getElementById("seriesLayout").addEventListener("click", () => {
    const gridContainer = document.getElementById("seriesLayoutContainer");
        
    // 토글 동작: 그리드 컨테이너가 비어있으면 버튼 생성, 아니면 초기화
    if (gridContainer.innerHTML === "") {
		 // 그리드 초기화: 기존 셀 제거
		gridContainer.empty();

        // 행과 열의 개수를 곱해서 총 그리드 버튼 생성
        for (let i = 0; i < 25; i++) {
			gridContainer.append("<div></div>");
     }

            // 클릭 이벤트 (예: 버튼 클릭 시 동작 추가)
            cell.addEventListener("click", (event) => {
				event.stopPropagation();
                //alert(`Button ${i + 1} clicked!`); // 클릭한 버튼의 인덱스 저장(0부터 시작)
                selectButtons(i, gridContainer.querySelectorAll(".grid-cell")); // 선택 로직 호출
            });
            cells.push(cell); // 배열에 버튼 추가
            gridContainer.appendChild(cell);
        }

});

// 버튼 선택 방향을 선택하는 함수 (오른쪽, 아래, 대각선)
function selectButtons(index, cells) { //index는 위치 i=index
	// 기존 선택 초기화
	cells.forEach(cell => cell.classList.remove("selected"));
	// 선택 방향 정의 (오른쪽, 아래, 대각선)
    const directions = ["right", "down", "diagonal"];
    // 방향별로 버튼 선택 처리
    directions.forEach((direction) => {
		// 방향에 따라 선택된 버튼 인덱스 계산
        const selectedIndexes = calculateSelection(index, rows, cols, direction);
        // 계산된 인덱스의 버튼에 "selected" 클래스 추가
        selectedIndexes.forEach((idx) => {
            if (idx >= 0 && idx < cells.length) { // 유효한 인덱스인지 확인

                cells[idx].classList.add("selected"); // 선택된 버튼 강조

            } else {
                console.warn(`Invalid index: ${idx}`);
            }
        });
    });
}

// 방향으로 움직여서 결과를 계산한 함수
function calculateSelection(index, rows, cols, direction) {
    const selectedIndexes = [];
    const row = Math.floor(index / cols);
    const col = index % cols;
	// 오른쪽으로 이동
    if (direction === "right") {
        for (let i = 1; i <= cols - col; i++) {
            selectedIndexes.push(index + i - 1);
        }
    } else if (direction === "down") {
		// 아래로 이동
        for (let i = 1; i <= rows - row; i++) {
            selectedIndexes.push(index + cols * (i - 1));
        }
    } else if (direction === "diagonal") {
		// 대각선 아래로 이동
        for (let i = 1; i <= Math.min(rows - row, cols - col); i++) {
            selectedIndexes.push(index + cols * (i - 1) + (i - 1));
        }
    }
    return selectedIndexes; // 선택된 인덱스 반환
}
*/

// 시리즈 레이아웃 생성 (그리드 형태)
function seriesLayout() {
    const seriesLayoutButton = document.getElementById('seriesLayout');
    // 버튼 클릭:격자(그리드)만들기
    if (layoutEnabled) {
        const gridContainer = $("#seriesLayoutContainer"); // 격자를 표시할 영역
        const gridSelector = $(".grid-selector"); // 격자 셀들의 그룹
        
        // 그리드 초기화: 기존 셀 제거
        gridSelector.empty();
      
        // 초기 5x5 그리드 셀 생성
        for (let i = 0; i < 25; i++) {
            gridSelector.append("<div></div>");
        }

        // 버튼 클릭 시 드롭다운 메뉴 표시
        gridContainer.toggle();

        // 마우스 오버 이벤트: 색상만 표시
        gridSelector.children("div").on("mouseover", function() {
            const index = $(this).index();
            const gridSize = Math.sqrt(gridSelector.children().length); // 그리드 크기 계산 (예: 5x5)

            // 마우스가 위치한 셀의 행, 열 인덱스 계산
            const row = Math.floor(index / gridSize);
            const col = index % gridSize;

            // 모든 셀의 배경 초기화
            gridSelector.children("div").css("background-color", "");

            // (0,0)부터 (row, col)까지의 영역에 배경색 적용
            gridSelector.children("div").each(function(i) {
                const r = Math.floor(i / gridSize);
                const c = i % gridSize;
                if (r <= row && c <= col) {
                    $(this).css("background-color", "grey");
                }
            });
        });

        // 클릭 이벤트: 그리드 크기 선택 및 로드
        gridSelector.children("div").on("click", function() {
            const index = $(this).index();
            const gridSize = Math.sqrt(gridSelector.children().length);
            const col = Math.floor(index / gridSize) + 1;
            const row = index % gridSize + 1;

            // 선택한 그리드 크기 출력
            console.log(`선택된 그리드 크기: ${col}x${row}`);

            // 선택한 그리드 크기 값을 사용하여 다중 뷰어 로드
            loadGridImages(col, row);

            // 드롭다운 메뉴 닫기
            gridContainer.hide();
        });

        // 드롭다운 외부 클릭 시 드롭다운 숨기기
        $(window).on("click", function(event) {
            if (!$(event.target).closest("#seriesLayout").length && !$(event.target).closest("#seriesLayoutContainer").length) {
                gridContainer.hide();
            }
        });
    } else {
        seriesLayoutButton.classList.remove('comp');
    }
}
