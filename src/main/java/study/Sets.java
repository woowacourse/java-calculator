package study;

import java.util.Set;

public class Sets {
    private static Set<Integer> set;

    public Sets(Set<Integer> set) {
        this.set = set;
    }

    public static boolean isContain(int input) {
        return set.contains(input);
//        boolean flag = false;
//        if ( (input == 1) || (input==2) || (input==3) ) flag = true;
//        return flag;
    }
}
