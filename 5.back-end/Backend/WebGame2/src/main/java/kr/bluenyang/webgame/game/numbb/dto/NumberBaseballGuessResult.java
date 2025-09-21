package kr.bluenyang.webgame.game.numbb.dto;

import kr.bluenyang.webgame.game.numbb.model.NumberBaseballTryVo;
import kr.bluenyang.webgame.game.numbb.model.NumberBaseballStatus;

import java.util.List;

public record NumberBaseballGuessResult(List<NumberBaseballTryVo> attempts, NumberBaseballStatus status) {
}
