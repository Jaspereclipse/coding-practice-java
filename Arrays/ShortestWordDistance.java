import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;

/* use hash map */
public class ShortestWordDistance {
    public int shortestDistanceI(String[] words, String word1, String word2){
        Map<String, Integer> map = new HashMap<>();
        int distance = words.length;
        for (int i=0; i<words.length; i+=1) {
            map.put(words[i], i);
            if (map.containsKey(word1) && map.containsKey(word2)) {
                int tmp = abs(map.get(word1) - map.get(word2));
                if (tmp < distance) {
                    distance = tmp;
                }
            }
        }
        return distance;
    }

    // Repeated queries, ds design
    public class WordDistance {
        Map<String, List<Integer>> map = new HashMap<>();
        public WordDistance(String[] words) {
            for (int i=0; i<words.length; i+=1) {
                if (map.containsKey(words[i])) map.get(words[i]).add(i);
                else map.put(words[i], new ArrayList<>(Arrays.asList(new Integer[]{i})));
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> wl1 = map.get(word1);
            List<Integer> wl2 = map.get(word2);
            int i = 0;
            int j = 0;
            int distance = Integer.MAX_VALUE;
            while (i < wl1.size() && j < wl2.size()) {
                distance = min(distance, abs(wl1.get(i) - wl2.get(j)));
                if (wl1.get(i) > wl2.get(j)) j += 1;
                else i += 1;
            }

            if (i < wl1.size()) distance = min(distance, abs(wl1.get(i) - wl2.get(j-1)));
            else if (j < wl2.size()) distance = min(distance, abs(wl1.get(i-1) - wl2.get(j)));

            return distance;
        }
    }

    public int shortestDistanceII(String[] words, String word1, String word2){
        int distance = words.length - 1;
        if (word1.equals(word2)) {
            int prev = -words.length;
            for (int i=0; i<words.length; i+=1) {
                if (words[i].equals(word1)) {
                    distance = min(distance, i - prev);
                    prev = i;
                }
            }
        } else {
            Map<String, Integer> map = new HashMap<>();
            map.put(word1, -words.length);
            map.put(word2, -words.length);
            for (int i=0; i<words.length; i+=1) {
                if (map.containsKey(words[i])) {
                    map.put(words[i], i);
                    distance = min(distance, abs(map.get(word1) - map.get(word2)));
                }
            }
        }
        return distance;
    }

    // combine together
    public int shortestWordDistanceIIBetter(String[] words, String word1, String word2) {
        int prev = -1;
        int distance = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (prev != -1 && (word1.equals(word2) || !words[prev].equals(words[i]))) {
                    distance = Math.min(i - prev, distance);
                }
                prev = i;
            }
        }
        return distance;
    }

    public void printRes(int res){
        System.out.println(res);
    }

    public static void main(String[] args){
        ShortestWordDistance swd = new ShortestWordDistance();
        String[] inputs = new String[]{
                "practice", "makes", "perfect", "coding", "makes"
        };
        int dis = swd.shortestDistanceI(inputs, "coding", "makes");
        swd.printRes(dis);
    }
}
