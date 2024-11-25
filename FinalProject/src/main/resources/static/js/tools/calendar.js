document.addEventListener("DOMContentLoaded", function () {
    const today = new Date();
    let currentYear = today.getFullYear();
    let currentMonth = today.getMonth();
    let startDate = null;
    let endDate = null;

    // 범위 강조
    function highlightRange(start, end) {
        const calendarBody = document.getElementById("calendar-body");
        const cells = calendarBody.getElementsByTagName("td");
        for (let i = 0; i < cells.length; i++) {
            const cellDate = parseInt(cells[i].textContent);
            const cellFullDate = new Date(currentYear, currentMonth, cellDate);
            if (!isNaN(cellDate) && cellFullDate >= start && cellFullDate <= end) {
                cells[i].classList.add("highlighted-range");
            } else {
                cells[i].classList.remove("highlighted-range");
            }
        }
    }

    // 단일 날짜 강조
    function highlightSingleDate(date, className) {
        const calendarBody = document.getElementById("calendar-body");
        const cells = calendarBody.getElementsByTagName("td");
        for (let i = 0; i < cells.length; i++) {
            const cellDate = parseInt(cells[i].textContent);
            const cellFullDate = new Date(currentYear, currentMonth, cellDate);
            if (!isNaN(cellDate) && cellFullDate.getTime() === date.getTime()) {
                cells[i].classList.add(className);
            } else {
                cells[i].classList.remove(className);
            }
        }
    }

    // 달력 업데이트
    function updateCalendar() {
        const monthNames = ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"];
        document.getElementById("calendar-title").textContent = `${currentYear}년 ${monthNames[currentMonth]}`;

        const firstDay = new Date(currentYear, currentMonth, 1).getDay();
        const lastDate = new Date(currentYear, currentMonth + 1, 0).getDate();
        const calendarBody = document.getElementById("calendar-body");
        calendarBody.innerHTML = "";
        let date = 1;

        for (let i = 0; i < 6; i++) {
            const row = document.createElement("tr");
            for (let j = 0; j < 7; j++) {
                const cell = document.createElement("td");
                if (i === 0 && j < firstDay) {
                    cell.textContent = "";
                } else if (date > lastDate) {
                    break;
                } else {
                    cell.textContent = date;
                    cell.dataset.date = date;

                    // 클릭 이벤트 추가
                    cell.addEventListener("click", function () {
                        selectDate(cell);
                    });

                    // 현재 날짜 표시
                    if (currentYear === today.getFullYear() && currentMonth === today.getMonth() && date === today.getDate()) {
                        cell.classList.add("current-day");
                    }

                    // 이전 선택 날짜 복원
                    const cellDate = new Date(currentYear, currentMonth, date).getTime();
                    if (startDate && cellDate === startDate.getTime()) {
                        cell.classList.add("selected-date");
                    }
                    if (endDate && cellDate === endDate.getTime()) {
                        cell.classList.add("endDate");
                    }
                    if (startDate && endDate && cellDate >= startDate.getTime() && cellDate <= endDate.getTime()) {
                        cell.classList.add("highlighted-range");
                    }

                    date++;
                }
                row.appendChild(cell);
            }
            calendarBody.appendChild(row);
        }
    }

    // 날짜 선택
    function selectDate(cell) {
        const selectedDate = parseInt(cell.dataset.date);

        if (!startDate) {
            startDate = new Date(currentYear, currentMonth, selectedDate);
            cell.classList.add("selected-date");
        } else if (!endDate) {
            endDate = new Date(currentYear, currentMonth, selectedDate);

            if (startDate > endDate) {
                [startDate, endDate] = [endDate, startDate];
            }

            highlightRange(startDate, endDate);
            cell.classList.add("endDate");

            document.getElementById("startDate").value = formatDate(startDate);
            document.getElementById("endDate").value = formatDate(endDate);
        } else {
            clearSelection();
            startDate = new Date(currentYear, currentMonth, selectedDate);
            cell.classList.add("selected-date");
        }
    }

    // 선택 초기화
    function clearSelection() {
        const calendarBody = document.getElementById("calendar-body");
        const cells = calendarBody.getElementsByTagName("td");
        for (let i = 0; i < cells.length; i++) {
            cells[i].classList.remove("selected-date");
            cells[i].classList.remove("highlighted-range");
            cells[i].classList.remove("endDate");
        }
        startDate = null;
        endDate = null;
    }

    // 검사일자 필드에서 입력 이벤트 처리
    document.getElementById("startDate").addEventListener("input", function () {
        const startInputValue = this.value;
        if (startInputValue) {
            startDate = new Date(startInputValue);
            startDate.setHours(0, 0, 0, 0);
            if (endDate) {
                highlightRange(startDate, endDate);
            } else {
                highlightSingleDate(startDate, "selected-date");
            }
            updateCalendar(); // 달력 업데이트
        }
    });

    document.getElementById("endDate").addEventListener("input", function () {
        const endInputValue = this.value;
        if (endInputValue) {
            endDate = new Date(endInputValue);
            endDate.setHours(0, 0, 0, 0);
            if (startDate) {
                highlightRange(startDate, endDate);
            } else {
                highlightSingleDate(endDate, "endDate");
            }
            updateCalendar(); // 달력 업데이트
        }
    });

    // 이전/다음 달로 이동
    document.getElementById("prev-month").addEventListener("click", function () {
        currentMonth = currentMonth === 0 ? 11 : currentMonth - 1;
        currentYear = currentMonth === 11 ? currentYear - 1 : currentYear;
        updateCalendar();
    });

    document.getElementById("next-month").addEventListener("click", function () {
        currentMonth = currentMonth === 11 ? 0 : currentMonth + 1;
        currentYear = currentMonth === 0 ? currentYear + 1 : currentYear;
        updateCalendar();
    });

    // 재설정 버튼
    document.getElementById("reset-btn").addEventListener("click", function () {
        document.getElementById("startDate").value = "";
        document.getElementById("endDate").value = "";
        document.getElementById("verifyFlag").value = "";
        document.getElementById("modality").value = "";
        document.getElementById("reportStatus").value = "";
        document.getElementById("pId").value = "";
        document.getElementById("pName").value = "";
        clearSelection();
        updateCalendar();
    });

    // 날짜 포맷 함수
    function formatDate(date) {
        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, "0");
        const day = String(date.getDate()).padStart(2, "0");
        return `${year}-${month}-${day}`;
    }

    updateCalendar();
});