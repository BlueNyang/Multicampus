package kr.bluenyang.webgame.game.numbb.dto;

import kr.bluenyang.webgame.game.numbb.model.NumberBaseballTryVo;
import kr.bluenyang.webgame.game.numbb.model.NumberBaseballStatus;

import java.util.List;

// 이 Record는 사용자의 시도 목록, 그리고 게임의 현재 상태를 포함
public record NumberBaseballGuessResult(List<NumberBaseballTryVo> attempts, NumberBaseballStatus status) {
}
