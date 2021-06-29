package commons.ExceptionCustomer;

public class GenderException extends Exception{
    public GenderException(){
        super("Không đúng định dạng Male hoặc Female");
    }
    public GenderException(String msg){
        super(msg);
    }
}
