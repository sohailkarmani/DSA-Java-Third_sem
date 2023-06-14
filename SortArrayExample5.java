// program that sorts array elements in alphabetical order.


import java.util.Arrays;   
import java.util.Collections;   
public class SortArrayExample5  
{   
public static void main(String[] args)   
{   
String [] strarray = {"Mango", "Apple", "Grapes", "Papaya", "Pineapple", "Banana", "Orange"};   
// sorts array[] in descending order   
Arrays.sort(strarray, Collections.reverseOrder());   
System.out.println("Array elements in descending order: " +Arrays.toString(strarray));   
}   
}  
