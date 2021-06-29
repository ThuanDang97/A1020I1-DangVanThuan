package A1020I1_DangVanThuan_CaseStudy.Commons.ExceptionCustomer;

public class NameException extends Exception {
    public NameException (){
        super("Tên không hợp lệ hoặc chưa in hoa đầu từ");
    }
    public NameException(String str){
        super(str);
    }
}
