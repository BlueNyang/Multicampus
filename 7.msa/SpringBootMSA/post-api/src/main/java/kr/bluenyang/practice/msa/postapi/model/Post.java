package kr.bluenyang.practice.msa.postapi.model;

public record Post(long userId, long id, String title, String body) {
}
