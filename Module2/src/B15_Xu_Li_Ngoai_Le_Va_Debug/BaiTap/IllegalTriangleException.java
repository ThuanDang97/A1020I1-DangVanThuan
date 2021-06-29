package B15_Xu_Li_Ngoai_Le_Va_Debug.BaiTap;

import javafx.application.Application;
import javafx.stage.Stage;

public class IllegalTriangleException extends Exception {
    public IllegalTriangleException (){
        super("Số nhập vào là số âm hoặc tổng 2 cạnh không lớn hơn cạnh còn lại!!!");
    }
    public IllegalTriangleException(String str){
        super(str);
    }

}
