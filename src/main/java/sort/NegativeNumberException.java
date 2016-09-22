package sort;

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(String str){
        super(str);
    }
    public NegativeNumberException() {
        super("Nonnegative number expected!");
    }
}
