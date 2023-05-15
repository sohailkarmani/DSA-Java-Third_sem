import java.util.Scanner;

import java.util.Arrays;

public class ArrayConvert2DTo1D{    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count = 0;
    
        int arr[][] = new int[][] { { 1, 5, 6 }, { 3, 7, 6 }, { 9, 3, 12 }, { 10, 16, 2 }, { 13, 18, 15 },
                { 14, 17, 16 }, { 13, 25, 21 }, { 28, 22, 32 }, { 26, 27, 29 }, { 20, 22, 35 } };
        int[] newArr = new int[30];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                newArr[count] = arr[j][i];
                count++;
            }
        }
        Arrays.sort(newArr);
       System.out.println("1-D array   ");
        for(int k=0;k<newArr.length;k++){
            
                System.out.print(newArr[k]+" ");
             }
 sc.close();
    }
}