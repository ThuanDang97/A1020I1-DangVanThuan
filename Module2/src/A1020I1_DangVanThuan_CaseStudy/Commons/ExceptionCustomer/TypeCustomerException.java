package A1020I1_DangVanThuan_CaseStudy.Commons.ExceptionCustomer;

public class TypeCustomerException extends Exception {
    public TypeCustomerException(){
        super("Loại Customer phải là Diamond, Platinium, Gold, Silver hoặc Member");
    }
}
