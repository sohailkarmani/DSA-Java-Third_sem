public class ListL {
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
        // add first
        public void addFirst(int data){
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
    public void printlist(){
        if(head==null){
            System.out.println("list is empty ");
            return;
        }
        Node currNode=head;
        while(currNode!=null){
            System.out.print(currNode.data+"->");
        currNode=currNode.next;
        }
        System.out.println("NULL");
        }
    
    public static void main(String[] args) {
        ListL list=new ListL();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

       list.printlist();
        

    }
}
