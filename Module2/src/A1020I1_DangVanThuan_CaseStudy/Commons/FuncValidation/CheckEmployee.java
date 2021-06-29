package A1020I1_DangVanThuan_CaseStudy.Commons.FuncValidation;

public class CheckEmployee {

//    Trình độ sẽ lưu trữ các thông tin: Trung cấp, Cao đẳng, Đại học và sau đại học
//    Vị trí sẽ lưu trữ các thông tin: Lễ tân, phục vụ, chuyên viên, giám sát, quản lý, giá đốc.
//    Mỗi Employee sẽ thuộc một bộ phận làm việc: Hiện tại resort bao gồm các bộ phận:
//    Sale – Marketing, Hành Chính, Phục vụ, Quản lý.
    private static String regex = "";

    public static boolean checkLevelEmp(String str){
        regex = "";
        return str.matches(regex);
    }
    public static boolean checkPositionEmp(String str){
        regex = "";
        return str.matches(regex);
    }
    public static boolean checkBoPhan(String str){
        regex = "";
        return str.matches(regex);
    }
}
