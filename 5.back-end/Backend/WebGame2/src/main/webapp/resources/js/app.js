document.addEventListener('DOMContentLoaded', () => {
  const hangmanBtn = document.getElementById('hangmanBtn');
  const numBaseballBtn = document.getElementById('numBaseballBtn');

  // 행맨 게임 페이지로 이동
  hangmanBtn.addEventListener('click', () => {
    window.location.href = '/WebGame2/hangman/start';
  });

  // 숫자 야구 게임 페이지로 이동
  numBaseballBtn.addEventListener('click', () => {
    window.location.href = '/WebGame2/num-baseball/start';
  });
})