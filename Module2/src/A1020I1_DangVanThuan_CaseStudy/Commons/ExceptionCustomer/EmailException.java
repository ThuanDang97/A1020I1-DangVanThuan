package A1020I1_DangVanThuan_CaseStudy.Commons.ExceptionCustomer;

public class EmailException extends Exception {
    public EmailException (){
        super("Invalid!!! Email is abc@abc.abc!!! ");
    }
    public EmailException (String str){
        super(str);
    }
}
