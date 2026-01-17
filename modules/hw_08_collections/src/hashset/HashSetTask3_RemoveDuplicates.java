package hashset;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetTask3_RemoveDuplicates {

    public static void main(String[] args) {
        hashSetRemoveDuplicate();
    }

    public static void hashSetRemoveDuplicate() {
        List<String> list = List.of("audi", "bmw", "lexus", "toyota", "lexus", "bmw");
        Set<String> uniq_list = new HashSet<>();
        uniq_list.addAll(list);
        System.out.println(uniq_list);
    }
}
