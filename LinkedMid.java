

class LL{
    Node head;
    int size;
    LL(){this.size=0;}
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
            size++;
        }
    } 
    //add    first
    public void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
        head=newNode;
        return;
        }
        newNode.next=head;
        head=newNode;
    }

    // add    last
    public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
        head=newNode;
        return;
        }
        Node currNode=head;
        while(currNode.next!=null){
            currNode=currNode.next;
        }
        currNode.next=newNode;
    }

    //print 
    public void print(){
        if(head==null){System.out.print("list is empty");}
        Node currNode=head;
        while(currNode!=null){
            System.out.print(currNode.data+" ");
            currNode=currNode.next;
            
        }
        System.out.println();
        
        
    }


    // delete first
    public void deleteFirst(){
        if(head==null){System.out.println("the list is empty"); return;}
        size--;
    head=head.next;

    }

    // delete last
    public void deleteLast(){
        if(head==null){System.out.println("list is empty "); return;}
         size--;
        if(head.next==null){head=null; return;}

        Node sNode=head;
        Node lNode=head.next;
        while(lNode.next!=null){
            lNode=lNode.next;
            sNode=sNode.next;
        }
        sNode.next=null;
    }
    
    public int getSize(){return size;}
}




public class LinkedMid {
    public static void main(String[] args) {
        LL list=new LL();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(6);
        list.print();


        list.deleteFirst();
        list.deleteLast();
        list.print();

        System.out.println(list.getSize());

        
    }
}
