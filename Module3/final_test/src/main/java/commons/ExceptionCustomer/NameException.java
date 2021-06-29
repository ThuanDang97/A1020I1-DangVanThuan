package commons.ExceptionCustomer;

public class NameException extends Exception {
    public NameException (){
        super("Tên không hợp lệ hoặc chưa in hoa đầu từ");
    }
    public NameException(String str){
        super(str);
    }
}
