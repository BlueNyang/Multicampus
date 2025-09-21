package kr.bluenyang.webgame.game.numbb.service;

import kr.bluenyang.webgame.game.numbb.dto.NumberBaseballGuessResult;
import kr.bluenyang.webgame.game.numbb.model.NumberBaseballStatus;
import kr.bluenyang.webgame.game.numbb.model.NumberBaseballTryVo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The NumberBaseballGame class
 */
@Slf4j
public class NumberBaseballGameServiceImpl implements NumberBaseballGameService {

    public NumberBaseballGameServiceImpl() {
    }

    @Override
    public List<Integer> createNewGame(int length) {
        log.info("NumberBaseballGameServiceImpl.createNewGame - Creating a new Number Baseball game...");
        // bound를 10^(length-1)로 설정하여 length 자릿수의 랜덤 숫자를 생성
        int bound = (int) Math.pow(10, length - 1);
        int randomNum = new Random().nextInt(bound, bound * 10);

        // 숫자를 처리하기 쉽도록 List<Integer>로 변환하고, 이를 Controller와 주고 받음
        return String.valueOf(randomNum)
                .chars()
                .map(Character::getNumericValue)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

    }

    /**
     * Process a player's guess and return the result in terms of strikes and balls.
     *
     * @param guess The player's guess
     */
    @Override
    public NumberBaseballGuessResult makeGuess(List<Integer> secretNumber,
                                               List<NumberBaseballTryVo> attempts,
                                               NumberBaseballStatus status,
                                               String guess) {

        // 게임이 이미 종료된 경우
        log.info("NumberBaseballGameServiceImpl.makeGuess - Attempting to guess number baseball game...");
        if (status == NumberBaseballStatus.SOLVED) {
            System.out.println("Game already solved.");
            return new NumberBaseballGuessResult(attempts, status);
        }

        // 입력 길이 검증
        if (guess.length() != secretNumber.size()) {
            log.info("NumberBaseballGameServiceImpl.makeGuess - Guess number length not equal to secret number.");
            status = NumberBaseballStatus.INVALID_LENGTH;
            return new NumberBaseballGuessResult(attempts, status);
        }

        // 스트라이크와 볼 계산
        int strikes = 0;
        int balls = 0;

        // 숫자 검증 및 스트라이크, 볼 계산
        for (int i = 0; i < secretNumber.size(); i++) {
            if (guess.charAt(i) < '0' || guess.charAt(i) > '9') {
                // 숫자가 아닌 문자가 포함된 경우
                log.info("NumberBaseballGameServiceImpl.makeGuess - Invalid character in guess: {} at index {}", guess.charAt(i), i);
                status = NumberBaseballStatus.INVALID_INPUT;
                // 잘못된 입력에 대해 시도 기록을 추가하지 않음
                // 이에 대해 INVALID_INPUT 상태를 반환
                return new NumberBaseballGuessResult(attempts, status);
            }
            // char를 int로 변환
            int digit = Integer.parseInt(guess.charAt(i) + "");

            // 스트라이크와 볼 계산
            if (secretNumber.get(i).equals(digit)) {
                strikes++;
            } else if (secretNumber.contains(digit)) {
                balls++;
            }
        }

        // 시도 기록 추가
        log.info("NumberBaseballGameServiceImpl.makeGuess - Guess result - Strikes: {}, Balls: {}", strikes, balls);
        // View에서 최근 try가 위에 오도록 addFirst() 사용
        attempts.addFirst(new NumberBaseballTryVo(guess, strikes, balls));

        // 상태 업데이트
        if (strikes == secretNumber.size()) {
            // 모든 자릿수가 맞으면 게임 종료
            log.info("NumberBaseballGameServiceImpl.makeGuess - Game solved!");
            status = NumberBaseballStatus.SOLVED;
            return new NumberBaseballGuessResult(attempts, status);
        }

        return new NumberBaseballGuessResult(attempts, status);
    }
}
