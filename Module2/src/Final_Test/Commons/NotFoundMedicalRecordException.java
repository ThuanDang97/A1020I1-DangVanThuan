package Final_Test.Commons;

public class NotFoundMedicalRecordException extends Exception {
    public NotFoundMedicalRecordException(){
        super("Bệnh án không tồn tại!!!");
    }
}
