document.addEventListener("DOMContentLoaded", () => {
  const prevBtn = document.getElementById("prevBtn");
  const resetBtn = document.getElementById("resetBtn");

  prevBtn.addEventListener("click", () => {
    window.location.href = "/WebGame2";
  });

  resetBtn.addEventListener("click", () => {
    window.location.href = "/WebGame2/num-baseball/start";
  });
})