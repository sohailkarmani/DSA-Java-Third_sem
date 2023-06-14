
import java.util.Arrays;   
public class SortSubarrayExample   
{   
public static void main(String[] args)   
{   
//defining an array  
int[] a = {12, 90, 34, 2, 45, 3, 22, 18, 5, 78};  
// sorts subarray form index 2 to 7  
Arrays.sort(a, 2, 7);   
//prints array using the for loop  
for (int i = 0; i < a.length; i++)   
{       
System.out.println(a[i]);   
}   
}   
}  
