public class StackClas {
private int arr[];
private int cap;
private int top;
StackClas(int size){
    arr=new int[size];
    cap=size;
    top=-1;

}
public void push(int x){
    if(isFull()){
        System.out.println("stack is full");
        System.exit(1);
    }
    System.out.print(x+" ");
    arr[++top]=x;
}
int pop(){
if(isEmpty()){System.out.println("empty");
}
}








    private boolean isFull() {
    return false;
}
    public static void main(String[] args) {
        StackClas ss=new StackClas(3);
        ss.push(1);
        ss.push(2);
        ss.push(3);
        

    }
}
