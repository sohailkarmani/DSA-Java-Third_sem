
//import java.util.Scanner;

/*two linkedlist/ arrays {5,7,9,11} & {29,35,45} are populated 
 make their sum and find the highest among them
*/


public class Test1Question1 {

	public static void main(String[] args) {
	int[] arr1= {5,7,9,11};
	int[] arr2= {29,35,45};
	int sum1=sum(arr1);
	int sum2=sum(arr2);
	System.out.println("sum of second array is "+sum1+"  Sum of second array is  "+sum2);
	int high1 = high(arr1);
	int high2 = high(arr2);
	if(high1>high2) {
		System.out.println("The highest number among the arrays is "+ high1);
	}
	else {
		System.out.println("The highest number among the arrays is "+ high2);
		
	}
	}

	static int high(int[] arr) {
		int highest=0;
		for(int i =1 ; i<arr.length;i++) {
			if(arr[i]>highest) {
				highest=arr[i];
			}
		}
		return highest;
				}

	   static int sum(int[] arr)
	    {
	        int sum = 0;
	        int i;

	        for (i = 0; i < arr.length; i++)
	            sum += arr[i];

	        return sum;
	    }


}





// class Node{
//     Node next;
//     int data;
//         public Node(int i) {
//         data=i;
//         }	
//     }
//     public class testQuestion2 {
    
//           public static void main(String[] args) {
//               //intilizatiing
//               Node head = new Node(5);
//                 head.next = new Node(7);
//                 head.next.next = new Node(9);
//                 head.next.next.next = new Node(11);
//                 Node start2 = new Node(29);
//                 start2.next = new Node(35);
//                 start2.next.next = new Node(45);
    
//                 int high = head.data;
//                 int sum = 0;
    
//                 for (Node j = head; j != null; j = j.next) {
//                   sum += j.data;
//                   if (j.data > high) {
//                     high = j.data;
//                   }
//                 }
//                 for (Node j = start2; j != null; j = j.next) {
//                   sum += j.data;
//                   if (j.data > high) {
//                     high = j.data;
//                   }
//                 }
//     System.out.println("Highest number is "+high);
//                 System.out.println("Sum of the two arrays is "+sum);
//                 ;
    
    
//     }}