import java.util.HashMap;

public class HashingMap {
    public static void main(String[] args) {
        
        HashMap<String , Integer> map=new HashMap<>();

        // Insertion
        map.put("Pak",30);
        map.put("Chine",150);
        map.put("US",30);
        map.put("India",120);

        System.out.println(map);

        // Search
        if(map.containsKey("Chine")){
            System.out.println("key is present in map");
        }
        else{
            System.out.println("key is not present in the map");
        }

        System.out.println(map.get("Chine"));
    }
}
