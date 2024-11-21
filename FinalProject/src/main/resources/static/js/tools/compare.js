// 이미지 레이아웃 초기화 함수
function initializeImageLayout() {
    const imgLayoutBtn = document.getElementById('imgLayoutBtn');
    const dropdown = document.getElementById('dropdown');
    const gridSelector = document.getElementById('grid-selector');

    if (!imgLayoutBtn || !dropdown || !gridSelector) {
        console.error("필수 요소가 없습니다. imgLayoutBtn, dropdown, gridSelector를 확인하세요.");
        return;
    }

    // 드롭다운 토글
    imgLayoutBtn.addEventListener('click', () => {
        dropdown.style.display = dropdown.style.display === 'block' ? 'none' : 'block';
    });

    // 그리드 선택기 설정
    setupImageGridSelector(gridSelector);
}

// 그리드 선택기 설정 함수
function setupImageGridSelector(gridSelector) {
    gridSelector.innerHTML = ''; // 기존 그리드를 초기화하여 중복 방지
    const maxRows = 5, maxCols = 5; // 최대 5x5 그리드

    for (let row = 1; row <= maxRows; row++) {
        for (let col = 1; col <= maxCols; col++) {
            const gridOption = document.createElement('div');
            gridOption.classList.add('grid-option');
            gridOption.dataset.row = row;
            gridOption.dataset.col = col;
            gridOption.style.background = '#ccc';
            gridOption.style.border = '1px solid #000';
            gridOption.style.width = '20px';
            gridOption.style.height = '20px';
            gridOption.style.cursor = 'pointer';

            // 호버 시 강조
            gridOption.addEventListener('mouseover', () => highlightGridSelection(row, col));

            // 클릭 시 레이아웃 변경
            gridOption.addEventListener('click', () => {
                generateImageGrid(row, col);
                dropdown.style.display = 'none'; // 드롭다운 닫기
                console.log(`그리드 ${row}x${col}로 설정`);
            });

            gridSelector.appendChild(gridOption);
        }
    }
}

// 이미지 그리드 생성
function generateImageGrid(rows, cols) {
	console.log("imagePaths : ", imagePaths)
    const gridContainer = document.getElementById('image-viewer');
    if (!gridContainer) {
        console.error("gridContainer 요소가 없습니다.");
        return;
    }

    gridContainer.innerHTML = ''; // 기존 그리드 초기화
    gridContainer.style.display = 'grid';
    gridContainer.style.gridTemplateColumns = `repeat(${cols}, 1fr)`;
    gridContainer.style.gridTemplateRows = `repeat(${rows}, 1fr)`;

    const totalCells = rows * cols;

    // `imagePaths`는 picdetail.html에서 주입된 변수로 가정합니다.
    for (let i = 0; i < totalCells; i++) {
        const gridItem = document.createElement('div');
        gridItem.classList.add('grid-item');
        gridItem.style.border = '1px solid #000';
        gridContainer.appendChild(gridItem);

        // Cornerstone을 사용한 이미지 로드
        cornerstone.enable(gridItem);

        // 이미지 경로 설정
        const imagePath = imagePaths[i]?.imagePath
        
        cornerstone.loadImage(imagePath)
            .then(image => {
                cornerstone.displayImage(gridItem, image);
                console.log(`이미지 ${i + 1} 로드 성공: ${imagePath}`);
            })
            .catch(err => {
				console.log("imagepath : ", imagePath)
				console.error(`이미지 로드 실패 (Index: ${i})`, err)});
    }
    
     // 마우스 휠 이벤트 추가
    gridItem.addEventListener('wheel', (event) => {
        event.preventDefault();

        // 휠 방향에 따라 이미지 인덱스 변경
        const delta = Math.sign(event.deltaY);
        currentImageIndexes[i] = (currentImageIndexes[i] + delta + imagePaths.length) % imagePaths.length;
        console.log(`Wheel event detected. Delta: ${delta}, Current Image Index: ${currentImageIndexes[i]}`);

        // 새 이미지 로드
        loadImageToCell(gridItem, i, currentImageIndexes);
    });
}

// 선택된 그리드 강조 표시
function highlightGridSelection(rows, cols) {
    const gridItems = document.querySelectorAll('.grid-option');
    gridItems.forEach(item => {
        const itemRow = parseInt(item.dataset.row);
        const itemCol = parseInt(item.dataset.col);
        item.style.background = (itemRow <= rows && itemCol <= cols) ? '#007BFF' : '#ccc';
    });
}
