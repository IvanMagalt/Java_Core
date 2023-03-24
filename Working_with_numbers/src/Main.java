package src;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> newList = new ArrayList<>();
        for (int i : intList) {
            if (i <= 0) continue;
            if (i % 2 != 0) continue;
            newList.add(i);
        }
        Collections.sort(newList);
        for (int x : newList) System.out.println(x);
    }
}
