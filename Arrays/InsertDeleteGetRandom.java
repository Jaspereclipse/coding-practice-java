import java.util.*;

/**
 * Created by juanyan.li on 3/16/17.
 */
public class InsertDeleteGetRandom {
    public class RandomizedSet {
        List<Integer> nums;
        Map<Integer, Integer> locs;
        Random rand;

        public RandomizedSet() {
            nums = new ArrayList<>();
            locs = new HashMap<>();
            rand = new Random();
        }

        public boolean insert(int val) {
            if (locs.containsKey(val)) return false;
            nums.add(val);
            locs.put(val, nums.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!locs.containsKey(val)) return false;
            int last = nums.size() - 1;
            nums.set(locs.get(val), nums.get(last));
            locs.replace(nums.get(last), locs.get(val));
            locs.remove(val);
            nums.remove(last);
            return true;
        }

        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }

    public class RandomizedCollection {
        List<Integer> nums;
        Map<Integer, Set<Integer>> locs;
        Random rand;

        public RandomizedCollection() {
            nums = new ArrayList<>();
            locs = new HashMap<>();
            rand = new Random();
        }

        public boolean insert(int val) {
            nums.add(val);
            if (locs.containsKey(val)) {
                locs.get(val).add(nums.size() - 1);
                return false;
            } else {
                locs.put(val, new HashSet<>());
                locs.get(val).add(nums.size() - 1);
                return true;
            }
        }

        public boolean remove(int val) {
            if (!locs.containsKey(val)) return false;
            int last = nums.get(nums.size() - 1);
            for (int loc : locs.get(val)) {
                nums.set(loc, last);
                locs.get(last).remove(nums.size() - 1);
                if (last != val) {
                    locs.get(last).add(loc);
                    locs.get(val).remove(loc);
                }
                if (locs.get(val).size() == 0) locs.remove(val);
                nums.remove(nums.size() - 1);
                break;
            }
            return true;
        }

        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }

    public static void main(String[] args) {
        InsertDeleteGetRandom idgr = new InsertDeleteGetRandom();
        RandomizedCollection rc = idgr.new RandomizedCollection();
        rc.insert(0);
        rc.remove(0);
        rc.insert(-1);
        rc.remove(0);
        rc.getRandom();
    }
}
