package lesson02;

public class MyArraySizeException extends RuntimeException {

    private int number;

    public int getNumber() {
        return number;
    }

    public MyArraySizeException(String message, int number) {
        super(message);
        this.number = number;
    }

}
