package game_project.database;

public class UserDuplicatedException extends RuntimeException {
    public UserDuplicatedException(String message) {
        super(message);
    }
}
