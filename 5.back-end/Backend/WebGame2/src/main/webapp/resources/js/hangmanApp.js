document.addEventListener("DOMContentLoaded", () => {
  const prevBtn = document.getElementById("prevBtn");
  const resetBtn = document.getElementById("resetBtn");

  // 이전 페이지로 이동
  prevBtn.addEventListener("click", () => {
    window.location.href = "/WebGame2";
  });

  // 게임 초기화 == game start 호출
  resetBtn.addEventListener("click", () => {
    window.location.href = "/WebGame2/hangman/start";
  });
})