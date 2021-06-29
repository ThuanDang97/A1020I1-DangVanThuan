package commons.ExceptionCustomer;

public class EmailException extends Exception {
    public EmailException (){
        super("Invalid!!! Email is abc@abc.abc!!! ");
    }
    public EmailException (String str){
        super(str);
    }
}
