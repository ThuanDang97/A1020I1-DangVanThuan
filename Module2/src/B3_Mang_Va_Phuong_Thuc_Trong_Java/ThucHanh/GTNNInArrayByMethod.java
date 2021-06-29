package B3_Mang_Va_Phuong_Thuc_Trong_Java.ThucHanh;

public class GTNNInArrayByMethod {
    static int minValue(int[] arr){
        int min = 0;
        min = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {6,32,57,324,6,23,6,1};
        int min = minValue(arr);
        System.out.println("GTNN là: " + min);
    }
}
