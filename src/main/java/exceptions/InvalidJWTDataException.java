package exceptions;

public class InvalidJWTDataException extends RuntimeException {
    public InvalidJWTDataException(String message) {
        super(message);
    }
}
