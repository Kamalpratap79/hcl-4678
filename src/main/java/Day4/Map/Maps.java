package Day4.Map;

import java.util.HashMap;
import java.util.Map;

public class Maps {
    public static void main(String[] args) {
        Map<Integer,String> mp = new HashMap<>();
        mp.put(0,"sam");
        mp.put(1,"bob");
        mp.put(2,"harry");
        mp.put(3,"pooter");
        mp.put(4,"bat");
        System.out.println(mp);

        for(int i:mp.keySet()){
            System.out.println(i);
        }
        for(String s:mp.values()){
            System.out.println(s);
        }

        for(Map.Entry<Integer,String> e: mp.entrySet()){ // iterate over entries
            System.out.println(e.getKey()+" "+e.getValue());
        }



    }
}
