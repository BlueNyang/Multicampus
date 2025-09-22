package kr.bluenyang.webgame.game.hangman.model;

// Guess 결과를 나타내는 enum
// Status와 구분되는 이유는, Status는 게임 전체의 상태를 나타내고
// GuessResult는 개별 추측에 대한 결과를 나타내기 때문
public enum HangmanGuessResult {
    ALREADY_USED,
    WRONG,
    CORRECT,
    ALREADY_ENDED,
    INVALID_INPUT,
}
