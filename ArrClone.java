
public class ArrClone{
    public static void main(String[] args) {
         
        int a[]={1,2,3,4,5};
        int b[]=(int [])a.clone();
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        for(int j=0;j<b.length;j++){
            System.out.print(b[j]+" ");
        }

    }
    
}
