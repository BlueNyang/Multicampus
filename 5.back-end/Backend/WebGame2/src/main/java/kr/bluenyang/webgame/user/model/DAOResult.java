package kr.bluenyang.webgame.user.model;

// Enum to represent the result of DAO operations
public enum DAOResult {
    SUCCESS,
    FAILURE,
    DUPLICATED,
    NOT_FOUND,
    SQL_ERROR
}
