document.addEventListener("DOMContentLoaded", () => {
  const prevBtn = document.getElementById("prevBtn");
  const resetBtn = document.getElementById("resetBtn");

  prevBtn.addEventListener("click", () => {
    window.location.href = "/WebGame";
  });

  resetBtn.addEventListener("click", () => {
    window.location.href = "/WebGame/hangman/start";
  });
})