package ItamarAndOmer;

public class NotExistException extends RuntimeException {
    public NotExistException() {
        super("does not exist");
    }

    public NotExistException(String message) {
        super(message);
    }
} 
