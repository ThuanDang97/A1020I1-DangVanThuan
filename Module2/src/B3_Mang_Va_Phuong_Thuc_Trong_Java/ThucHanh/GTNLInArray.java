package B3_Mang_Va_Phuong_Thuc_Trong_Java.ThucHanh;

public class GTNLInArray {
    public static void main(String[] args) {
        int[] arr = {2,5,7,13,4,3};
        int max = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (max < arr[i]){
                max = arr[i];
            }
        }
        System.out.println("GTLM in Array: " + max);
    }
}
