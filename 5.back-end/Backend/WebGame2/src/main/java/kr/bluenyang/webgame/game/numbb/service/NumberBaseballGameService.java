package kr.bluenyang.webgame.game.numbb.service;

import kr.bluenyang.webgame.game.numbb.dto.NumberBaseballGuessResult;
import kr.bluenyang.webgame.game.numbb.model.NumberBaseballStatus;
import kr.bluenyang.webgame.game.numbb.model.NumberBaseballTryVo;

import java.util.List;

public interface NumberBaseballGameService {
    List<Integer> createNewGame(int length);

    NumberBaseballGuessResult makeGuess(List<Integer> secretNumber,
                                        List<NumberBaseballTryVo> attempts,
                                        NumberBaseballStatus status,
                                        String guess);
}
