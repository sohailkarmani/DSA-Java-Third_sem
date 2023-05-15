

class List{
    Node head;

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }

    }

    public void add(int data){
        Node newNode=new Node(0);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;



    }
public int sum(){
    int sum=0;
    if(head==null){System.out.println("list is empty");}
    Node newNode=head;
    while(newNode!=null){
        sum+=newNode.data;
        newNode=newNode.next;
    }
    return sum;


}


public void print(){
    if(head==null){System.out.print("list is empty");}
    Node currNode=head;
    while(currNode!=null){
        System.out.print(currNode.data+" ");
        currNode=currNode.next;
        
    }
    System.out.println();
    
}


}


public class LinkedLl {
    public static void main(String[] args) {
        List l1=new List();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);

        l1.sum();
l1.print();

        
    }
}
