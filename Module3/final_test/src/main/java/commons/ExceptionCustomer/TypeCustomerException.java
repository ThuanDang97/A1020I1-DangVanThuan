package commons.ExceptionCustomer;

public class TypeCustomerException extends Exception {
    public TypeCustomerException(){
        super("Loại Customer phải là Diamond, Platinium, Gold, Silver hoặc Member");
    }
}
