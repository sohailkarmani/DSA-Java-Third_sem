 public class BinaryTree{
    private Object root;
    private BinaryTree left,rigth;
    BinaryTree(Object root){
        this.root=root;
        this.left=this.rigth=null;

    }
    BinaryTree(Object root,BinaryTree left,BinaryTree rigth){
        this.left=left;
        this.rigth=rigth;
        this.root=root;
    }
    public Object getRoot(){return root;}
    public Object getLeft(){return left;}
    public Object getRigth(){return rigth;}
 
 public String toString(){
    StringBuilder sb=new StringBuilder();
    if(left!=null){
        sb.append(left);
        sb.append(left.Pre_Order());
    }
    if(rigth!=null){
        sb.append(rigth);
    }
    return sb.toString();

 }
 public String Pre_Order(){
    StringBuilder sb=new StringBuilder();
    sb.append(root).append(" ");
    if(left!=null){
        sb.append(root).append(" ");
    }
    if(rigth!=null){
        sb.append(rigth.Pre_Order());
    }
    return sb+" ";

 }

public static void main(String[] args) {
        BinaryTree e = new BinaryTree("E"); // leaf
        BinaryTree j = new BinaryTree("J"); // leaf
        BinaryTree k = new BinaryTree("K"); // leaf
        BinaryTree l = new BinaryTree("L"); // leaf
        BinaryTree m = new BinaryTree("M"); // leaf
        BinaryTree i = new BinaryTree("I"); // leaf
        BinaryTree f = new BinaryTree("F", j,k); // subtree
        BinaryTree c = new BinaryTree("C", l,m); // subtree
        BinaryTree b = new BinaryTree("B", e,f);
        BinaryTree d = new BinaryTree("D",c,i);
        BinaryTree a = new BinaryTree("A", b,d); 

        // creating a sub tree:
        // BinaryTree sa = new BinaryTree("9");
       //Bin aryTree sb = new BinaryTree("1");
        //BinaryTree sr = new BinaryTree("8", sa, sb);

        System.out.println("toString traversing");
        System.out.println(a.toString());
        System.out.println("pre order traversing");
        System.out.println(a.Pre_Order());
     
     


}
}