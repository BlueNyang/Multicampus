package kr.bluenyang.practice.msa.commentapi.model;

public record Comment(long postId, long id, String name, String email, String body) {
}
