package kr.bluenyang.webgame.user.model;

// Enum to represent the result of user service operations
public enum UserServiceResult {
    SUCCESS,
    FAIL,
    DUPLICATED,
    NOT_FOUND,
    INVALID_INPUT,
    INVALID_ID_OR_PASSWORD
}
