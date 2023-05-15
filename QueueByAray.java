public class QueueByAray {

    private static int rear,front,cap;
    private static int Queue[];

    QueueByAray(int size){
        rear=front=0;
        cap=size;
        Queue =new int[cap];


    }


// insert an element in the queue
public void add(int data){
    if(cap==rear){
        System.out.println("queue is full");
        return;
 }
 else{
    Queue[rear]=data;
    rear++;
 }
 return;  
 }
 public void display() {
    if(front==rear){System.out.println("Queue is empty");
    return;
}
else{
for(int i=front;i<rear;i++){
System.out.print(Queue[i]+" ");
}}}

// print front of queue   
 void queueFront(){   
    if (front == rear) {   
        System.out.printf("Queue is Empty\n");   
        return;   
    }   
    System.out.printf("\nFront Element of the queue: %d", Queue[front]);   
    return;   
}   
   



    public static void main(String[] args) {
        QueueByAray Q=new QueueByAray(5);
        Q.add(1);
        Q.add(2);
        Q.add(3);
        Q.add(4);
        Q.add(5);
        Q.display();
        Q.queueFront();

        
    }
}
