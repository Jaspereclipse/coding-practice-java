import java.util.HashMap;
import java.util.Map;

/**
 * Created by juanyan.li on 3/5/17.
 */

// The list implementation exceeds time limit probably because of resizing
public class TwoSumIII {
    private Map<Integer, Integer> map;

    public TwoSumIII() {
        map = new HashMap<>();
    }

    public void add (int number) {
        map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
    }

    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int remain = value - key;
            if ((key == remain && map.get(remain) > 1)
                    || (key != remain && map.containsKey(remain))) return true;
        }
        return false;
    }

    public void printRes(boolean res) {
        System.out.println(res);
    }

    public static void main(String[] args) {
        TwoSumIII ts3 = new TwoSumIII();
        ts3.add(1);
        ts3.add(3);
        ts3.add(3);
        ts3.printRes(ts3.find(4));
    }
}
