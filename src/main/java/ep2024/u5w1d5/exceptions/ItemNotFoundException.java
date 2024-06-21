package ep2024.u5w1d5.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(long id) {
        super("The item with id " + id + " has not been found :(");
    }

    public ItemNotFoundException(String string) {
        super("The item with username '" + string + "' has not been found :(");
    }
}
