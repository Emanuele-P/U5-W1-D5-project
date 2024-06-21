package ep2024.u5w1d5.exceptions;

public class DuplicateItemException extends RuntimeException {
    public DuplicateItemException(String string) {
        super("The item " + string + "exists already!");
    }
}
