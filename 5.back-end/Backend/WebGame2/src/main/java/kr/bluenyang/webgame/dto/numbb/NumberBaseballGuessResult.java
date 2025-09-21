package kr.bluenyang.webgame.dto.numbb;

import kr.bluenyang.webgame.service.numbb.NumberBaseballStatus;

import java.util.List;

public record NumberBaseballGuessResult(List<NumberBaseballTry> attempts, NumberBaseballStatus status) {
}
