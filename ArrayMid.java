

public class ArrayMid {
    public static void main(String[] args) {


// find second largest element in array
        // int a[]={6,4,8,9,10,14};
        // int temp=0;
        // for(int i=0;i<a.length;i++){
        //     for(int j=i+1;j<a.length;j++){
        //         if(a[i]>a[j]){
        //             temp=a[i];
        //             a[i]=a[j];
        //             a[j]=temp;

        //         }
        //     }
        // }
        // for(int i=0;i<a.length;i++){
        //     System.out.print(a[i]+" ");
        // }
        // System.out.println("Second largest elemsnt     "+a[1]);


//find maximum element in array
    // int a[]={4,6,7,0,9,10};
    // int max=a[0];  
    // for(int i=1;i<a.length;i++){
    //     if(max<a[i]){
    //         max=a[i];
    //     }
    
    // }
    // System.out.println(max);



//find minimum element in array
    // int a[]={4,6,7,0,9,10};
    // int min=a[0];  
    // for(int i=1;i<a.length;i++){
    //     if(min>a[i]){
    //         min=a[i];
    //     }
    
    // }
    // System.out.println(min);



//insert element at any position

    int a[]={7,0,9,6,8};
    int position=2;
    int element=10;
    for(int i=a.length-1;i>position-1;i--){
        a[i]=a[i-1];
    }
    a[position-1]=element;
    for(int i=0;i<a.length;i++){
        System.out.print(a[i]+"  ");
    }

//delete element from array
    //   int a[]={1,2,3,4,5};
    //   int del=3;
    //   for(int i=0;i<a.length;i++){
    //     if(del==a[i]){
    //         for(int j=i;j<a.length-1;j++){
    //             a[j]=a[j+1];
    //         }
    //         break;
    //     }
    //   }
    //   for(int i=0;i<a.length-1;i++){
    //     System.out.print(a[i]+"  ");
    //   }


//merg two arrays in one array
        //  int a[]={1,2,3};
        //  int b[]={4,5};
        //  int a_len=a.length;
        //  int b_len=b.length;
        //  int c_len=a_len+b_len;
        //  int c[]=new int[c_len];
        //  for(int i=0;i<a.length;i++){
        //     c[i]=a[i];
        //  }
        //  for(int i=0;i<b.length;i++){
        //     c[a.length+i]=b[i];
        //  }
        //  for(int i=0;i<c.length;i++){
        //     System.out.print(c[i]+"  ");
        //  }
         



        

    }



}








// class Arr{
//     public int search(int a[],int x){
// for(int i=0;i<a.length;i++){
// if(a[i]==x){return i;}
// }
// return -1;

//     }



// }
// public class ArrayMid2 {
//     public static void main(String[] args) {
//         Arr a1=new Arr();
// int a[]={1,2,3,4,5,6,7,8,9,10};
// System.out.println(a1.search(a, 12));

//     }
// }





//public class ArrayBasicOperatoin {

    public static int[] addAtFirst(int[] array, int value) {
        int[] newarr = array;
        array = new int[array.length + 1];
        array[0] = value;
        for (int i = 0; i < newarr.length; i++) {
            array[i + 1] = newarr[i];
        }
        return array;
    };

    public static int[] addAtlast(int[] array, int value) {
        int[] newarr = array;
        array = new int[array.length + 1];
        for (int i = 0; i < newarr.length; i++) {
            array[i] = newarr[i];
        }
        array[newarr.length] = value;
        return array;
    };

    public static int[] addAtIndex(int[] array, int index, int value) {

        if (index > array.length) {
            System.out.println("Index out of bound of length " + array.length);
        } else {

            int count = 0;
            int[] newarr = array;
            array = new int[array.length + 1];
            for (int i = 0; i < array.length; i++) {
                if (index == i) {
                    array[index] = value;
                    continue;
                } else
                    array[i] = newarr[count];
                count++;

            }
        }
        return array;
    };

    public static int[] addAtMiddle(int[] array, int value) {
        int middle = array.length / 2;
        int[] newarr = array;
        int count = 0;
        array = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            if (middle == i) {
                array[i] = value;
                continue;
            }

            else {
                array[i] = newarr[count];
                count++;
            }

        }
        return array;
    };

    public static int[] deleteAtFirst(int[] array) {
        if (array.length <= 0) {
            System.out.println("The Array is empty deletion is not possible ");
        } else {
            int[] newarr = array;
            array = new int[array.length - 1];
            for (int i = 1; i < newarr.length; i++) {
                array[i - 1] = newarr[i];
            }
        }
        return array;
    };

    public static int[] deleteAtlast(int[] array) {
        if (array.length <= 0) {
            System.out.println("The Array is empty deletion is not possible ");
        } else {
            int[] newarr = array;
            array = new int[array.length - 1];
            for (int i = 0; i < array.length; i++) {
                array[i] = newarr[i];
            }
        }
        return array;
    };

    public static int[] deleteAtIndex(int[] array, int index) {
        if (array.length <= 0) {
            System.out.println("The Array is empty deletion is not possible ");
        }

        else {
            int count = 0;
            int[] newarr = array;
            array = new int[array.length - 1];
            for (int i = 0; i < array.length + 1; i++) {
                if (i == index)
                    continue;
                else {
                    array[count] = newarr[i];
                    count++;
                }

            }

        }
        return array;
    };

    public static int[] deleteAtMiddle(int[] array) {
        if (array.length <= 0) {
            System.out.println("The Array is empty deletion is not possible ");
        }

        else {
            int middle = array.length / 2;
            int count = 0;
            int[] newarr = array;
            array = new int[array.length - 1];
            for (int i = 0; i < newarr.length; i++) {
                if (i == middle)
                    continue;
                else
                    array[count] = newarr[i];
                count++;

            }

        }
        return array;
    };

    public static void traverseArray(int[] arr) {
        for (int f : arr)
            System.out.print(" " + f);
        System.out.println();
    }

    public static int MaxInArray(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    public static int MinInArray(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
        }
        return min;
    }

    public static int sumofElementInArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static float averageOfElementInArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        float average = sum / array.length;
        return average;
    }

    public static int[] reverseArray(int[] array) {
        int[] newarr = array;
        array = new int[newarr.length];
        int count = 0;
        for (int i = newarr.length - 1; i >= 0; i--) {
            array[count] = newarr[i];
            count++;
        }
        return array;
    }

    // linear search:
    public static int seaarchAtIndex(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (target == array[i])
                return array[i];
        }
        return -1;
    }

    public int binarySearchArray(int[] array, int target) {
        int startposition = 0;
        int lastposition = array.length - 1;
        while (startposition <= lastposition) {
            int middle = (startposition + lastposition) / 2;

            if (array[middle] == target)
                return middle;
            else if (target > array[middle])
                startposition = middle + 1;
            else
                lastposition = middle - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 89, 19, 6, 54, 32, 23, 45, 65, 87, 343 };
        System.out.println("The original array is given below ");
        traverseArray(arr);
        System.out.println("After implementing some method of array the new array is  given below ");
        // // ---> add methods:
        // arr = addAtFirst(arr, 1000);
        // arr = addAtlast(arr, 2000);
        // arr = addAtMiddle(arr, 1500);
        // arr=addAtIndex(arr, 8, 1300);
        // traverseArray(arr);

        // ---> Delete methods:
        // arr = deleteAtFirst(arr);f
        // arr = deleteAtlast(arr);
        arr = deleteAtIndex(arr, 4);
        // arr = deleteAtMiddle(arr);
        traverseArray(arr);
        // arr = reverseArray(arr);
        // traverseArray(arr);
        // System.out.println(MaxInArray(arr));
        // System.out.println(MinInArray(arr));
        // System.out.println(sumofElementInArray(arr));
        // System.out.println(averageOfElementInArray(arr));
        // System.out.println(seaarchAtIndex(arr, 87));
    }
}













class linkedList {
    Node head;
    private int size = 0;

    class Node { // Node class
        int data;// pointing the data of head
        Node next; // poinnting the next elemet of head

        Node(int data) {
            this.data = data;
            this.next = null; // iniatially it create null list
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next; // iniatially it create null list
        }
    }

    public int sizzeOfList() {
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public void addAtFirst(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            return;
        }
        newnode.next = head;// newnode's-> next points to the head
        head = newnode; // head assign as newnode
    }

    // adding at last :
    public void addAtLast(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            return;
        }

        // traverse the head;
        Node CurrentNode = head; // assign the value head to a head variable;
        while (CurrentNode.next != null) {
            CurrentNode = CurrentNode.next;
        }
        CurrentNode.next = newnode;
    }

    // insert at specific poisition:
    public void insertion(int data, int index) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        if (index < 0 || index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node p = head;
        for (int i = 1; i < index; i++)
            p = p.next;

        newNode.next = p.next;
        p.next = newNode;
        // p.next=new Node(data, p.next);
    }

    // print list ;
    public void PrintList() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }

        System.out.println("Null");
    }

    public void deleteAtFirst() {
        if (head == null) {
            System.out.println("list is epmty");
            return;
        }

        head = head.next;
    }

    public void deleteAtLast() {
        if (head == null) {
            System.out.println("The List is empty .");
            return;
        }

        if (head.next == null) { // if node has only one element;
            head = null;
            return;
        }
        Node secondlast = head;
        Node lastnode = head.next; // head.next=null -> lastnode=null;
        while (lastnode.next != null) {
            lastnode = lastnode.next;// null.next have no scense; that why we use second if condtition;
            secondlast = secondlast.next;
        }
        secondlast.next = null;
    }

    public void deleteAnyValue(int data) {
        Node p = head;

        while (p.next != null) {
            if (p.next.data == data) {
                p.next = p.next.next;
                return;
            }
            p = p.next;
        }
        System.out.println("this data is not aviable in the list");
    }

    public void deleteAtIndex(int index) {
        Node temp = head;
        if (head == null) {
            System.out.println("List is Epmty");
            return;
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        else {
            for (int i = 1; i < index - 1; i++)
                temp = temp.next;

            temp.next = temp.next.next;
        }
    }

    public void middleElement() {
        if (head == null) {
            System.out.println("List is empty ");
            return;
        }

        Node temp = head;
        int middle_Element = sizzeOfList() / 2;
        while (middle_Element != 0) {
            temp = temp.next;
            middle_Element--;
        }
        System.out.println("Middle element is = " + temp.data);
    }

    public boolean compareEqualLists(linkedList list2) {

        if (this.head == null || list2.head == null)
            return false;

        Node p = this.head;
        Node q = list2.head;
        while (p != null && q != null) {
            if (p.data != q.data)
                return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }

    public Node reverse_list() {
        // way no: 01

        // Node prev = null;
        // Node current = head;
        // Node next = null;
        // while (current != null) {
        //     next = current.next;
        //     current.next = prev;
        //     prev = current;
        //     current = next;
        // }
        // head = prev;

        //way no: 2 
        return head;
    }

    public int sumofElementInList() {
        int sum = 0;
        if (head == null) {
            System.out.println("List is empty");
        }
        Node p = head;
        while (p != null) {
            sum += p.data;
            p = p.next;
        }
        return sum;

    }
    public void MergeList(linkedList list2){
        
        Node list1=this.head;
        while(list1.next!=null)list1=list1.next;
         list1.next=list2.head;
    }
    public boolean searchElement(int target){
        
        Node temp=head;
        while(temp!=null){
            if(temp.data==target)return true;
            temp=temp.next;
        }
        return false;
    }

}
public class basicOperationOfLL {
    public static void main(String[] args) {

        linkedList list = new linkedList();
        linkedList list2 = new linkedList();
        list.addAtFirst(10);
        list.addAtFirst(20);
        list.addAtFirst(30);
        list.addAtFirst(40);
        list.addAtLast(50);
        list.PrintList();
        //list two
        list2.addAtLast(100);
        list2.addAtLast(200);
        list2.addAtLast(300);
        list2.PrintList();
        list.MergeList(list2);
        list.PrintList();
System.out.println(list.searchElement(20));
        System.out.println(list.sumofElementInList());
    }
}

















/**
 * 4 main method:
 * peak : return type ArrayStack
 * pop : return ArrayStack to access the element
 * push(Object obj) : return type void
 * size() : int
 */
// ---> ADT is roiugh sketch

interface stack {

    public int size();

    public void push(Object obj);

    public Object pop();

    public Object peek();

    // ------------------------------------------------------------------------
    public boolean arrayStackEqual(ArrayStack s);

    public void ToString();

    public void bottomElement();

    public void replace_BottomWithTop();

    public void traverseStack();

    public void copyStackAsReverse(stack fruit2);

    public void reverseStack();

    public void pushAtBottom(Object data);
    public void copyasSameStack(ArrayStack a);
    // ---------------------------------------------------------------------------
}

class ArrayStack implements stack {
    private Object[] array; // creating an array
    private int size; // defining the size

    public ArrayStack(int capacity) {
        array = new Object[capacity]; // initialize the array length;
    }

    private boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public void push(Object obj) {
       if (size == array.length)
            resize();
        array[size++] = obj;
    }

    @Override
    public Object pop() {
        if (size == 0)
            throw new IllegalStateException();
        Object object = array[--size];
        // array[size] = null;
        return object;
    }

    @Override
    public Object peek() {
        if (size == 0)
            throw new IllegalStateException();

        return array[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    private void resize() {
        Object[] duplicateArray = array;
        array = new Object[2 * duplicateArray.length]; // changing the size of old array...
        System.arraycopy(duplicateArray, 0, array, 0, size);
    }

    // comparing the two equal stack:
    public boolean arrayStackEqual(ArrayStack stackList) {
        if (this.size() == stackList.size())
            for (int i = 0; i < size(); i++)
                if (this.array[i].equals(stackList.array[i]))
                    return true;

        return false;
    }

    // cpnverting all the element of stack into string;
    public void ToString() {
        if (isEmpty()) {
            System.out.println("This is empty list");
        }
        String s = "";
        for (int i = 0; i < size(); i++) {
            s += " " + array[i].toString();
        }
        System.out.println(s);
    }

    /// deletig the bottom element of the stack:
    public void bottomElement() {
        if (isEmpty()) {
            System.out.println("Stack is underfellow");
        }

        Object[] newarr = array;
        array = new Object[newarr.length - 1];
        array[0] = null;
        System.arraycopy(newarr, 1, array, 0, --size);
        System.out.println("after delete bottom array");

    }

    public void replace_BottomWithTop() {
        String store = peek().toString(); // 934
        pop();
        push(array[0]); // apple;
        array[0] = store;// 934

    }

    public void traverseStack() {
        if (isEmpty())
            System.out.println("stack is underfellow");

        while (this.size() != 0) {
            System.out.println(this.peek());
            this.pop();
        }

    }

    public void copyStackAsReverse(stack stack1) {
        while (this.size() != 0) {
            stack1.push(this.peek());
            this.pop();
        }
    }

    public void copyasSameStack(ArrayStack stack1){
        stack1.array=this.array;
        stack1.size=this.size;
    }
    public void reverseStack() {

        if (this.isEmpty()) {
            System.out.println("stack is empty ");
            return;
        }
        /// way one:
        // Object top = this.pop();
        // this.reverseStack();
        // this.pushAtBottom(top);
        // way two:
        // ArrayStack s1 = new ArrayStack(size);
        // ArrayStack s2 = new ArrayStack(size);
        // while (this.size() != 0) {
        // s1.push(this.peek());
        // this.pop();
        // }
        // while (s1.size() != 0) {
        // s2.push(s1.peek());
        // s1.pop();
        // }
        // if (this.isEmpty()) {
        // while (s2.size() != 0) {
        // this.push(s2.peek());
        // s2.pop();
        // }
        // }

        //way 03:
        // for(int i=0;i)
        // System.out.println(size);
        // for(int i=size;i>=0;i--){
        //     this.push(array[i]);
        // }

    }

    public void pushAtBottom(Object data) {

        if (this.isEmpty()) {
            this.push(data);
            return;
        }

        // WAY ONE:
        Object temp = this.pop();
        this.pushAtBottom(data);
        this.push(temp);

        // ANOTHER WAY:
        // ArrayStack s1 = new ArrayStack(this.size);
        // while (this.size() != 0) {
        // s1.push(this.peek());
        // this.pop();
        // }
        // this.push(data);
        // while (s1.size() != //0) {
        // this.push(s1.peek());
        // s1.pop();
        // }

    }

}

public class stack_01 {
    public static void main(String[] args) {

        stack fruits = new ArrayStack(10);
        stack fruit2 = new ArrayStack(10);
        fruits.push("Apple");
        fruits.push("Banana");
        fruits.push("Mango");
        fruits.push("Gauva");
        fruits.push(934);
        fruits.push(934.234);
        // System.out.println(fruits.peek());
        // System.out.println(fruits.pop());
        // System.out.println(fruits.peek());
        // fruits.copyStackAsReverse(fruit2);
        // fruits.copyasSameStack((ArrayStack)fruit2);
        fruit2.traverseStack();
        // System.out.println("stack one");
        // fruits.traverseStack();
        // fruits.reverseStack();
        // fruits.traverseStack();
        // fruits.pushAtBottom("kelash ");
        // fruits.pushAtBottom("kumar");
        // fruits.pushAtBottom("Bheel");
        // System.out.println("stack two");
        // fruit2.traverseStack();
        // fruits.replace_BottomWithTop();
        // fruits.bottomElement();
        // fruits.ToString();
        // stack fruit =new ArrayStack(15);
        // fruit.push("Apple");
        // fruit.push("Banana");
        // fruit.push("Mango");
        // fruit.push("Gauva");
        // fruit.push(934);
        // fruit.push(934.234);
        // fruit.ToString();
        // // System.out.println("equal method "+fruits.arrayStackEqual((ArrayStack)
        // // fruit));

        // // // System.out.println(fruits.peek());
        // // System.out.println(fruits.pop()) ;
        // // System.out.println(fruits.peek());
        // // System.out.println(" The size of fruits stack " + fruits.size() + " The
        // are
        // // given bellow .");

    }
}

// class RPN{
// RPN(String[] args){
// stack Stack=new ArrayStack(args.length);
// for(int i=0;i<args.length;i++){
// String input=args[i];
// if(isAnOperator(input)){
// double x=Double.parseDouble((String)Stack.pop());
// double y=Double.parseDouble((String)Stack.pop());
// double z=evalute(x,y,input);
// Stack.push(""+z);
// }
// else{
// Stack.push(input);
// }
// }
// }

// private boolean isAnOperator(String s){
// return (s.length()==1 && "ASMD".indexOf(s)>=0);
// }
// private double evalute(double x, double y, String op){
// double z=0;
// if(op.equals("A"))z=x+y;
// else if(op.equals("S"))z=x-y;
// else if(op.equals("S"))z=x*y;
// else z=x-y;
// System.out.println(x+" "+op+" "+y+" = "+z);
// return z;
// }
// public static void main(String[] args) {
// new RPN(args);
// }
// }