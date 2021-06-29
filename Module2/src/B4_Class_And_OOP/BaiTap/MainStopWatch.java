package B4_Class_And_OOP.BaiTap;

import java.util.Scanner;

public class MainStopWatch {
    static void sort(long[] arr)
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            long temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        long[] arr = new long[100000];
        for (int i = 0; i < 100000; i++){
            arr[i] = (int) Math.random();
        }
        stopWatch.start();
        sort(arr);
        stopWatch.stop();
        System.out.println(stopWatch.getElapsedTime());
    }

}
