document.addEventListener('DOMContentLoaded', () => {
  const hangmanBtn = document.getElementById('hangmanBtn');
  const numBaseballBtn = document.getElementById('numBaseballBtn');

  hangmanBtn.addEventListener('click', () => {
    window.location.href = 'hangman/start';
  });

  numBaseballBtn.addEventListener('click', () => {
    window.location.href = 'num-baseball/start';
  });
})