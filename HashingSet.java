import java.util.HashSet;
import java.util.Iterator;
public class HashingSet {
    public static void main(String[] args) {

         // Creating
         HashSet<Integer> set=new HashSet<>();

         // Insert
         set.add(1);
         set.add(2);
         set.add(3);
         set.add(4);
         set.add(5);

         // size
         System.out.println(set.size());

         // Search - Contains
         if(set.contains(1)){
            System.out.println("set contains 1");
         }
         if(!set.contains(6)){
            System.out.println("does not contains");
         }

         //print all elements of set
         System.out.println(set);

         // Iterator
         Iterator<Integer> it =set.iterator();
         while(it.hasNext()){
            System.out.println(it.next());

         }




    }
}
