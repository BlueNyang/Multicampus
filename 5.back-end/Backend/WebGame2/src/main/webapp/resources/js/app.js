document.addEventListener('DOMContentLoaded', () => {
  const hangmanBtn = document.getElementById('hangmanBtn');
  const numBaseballBtn = document.getElementById('numBaseballBtn');

  hangmanBtn.addEventListener('click', () => {
    window.location.href = '/WebGame2/hangman/start';
  });

  numBaseballBtn.addEventListener('click', () => {
    window.location.href = '/WebGame2/num-baseball/start';
  });
})