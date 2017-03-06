import java.util.HashMap;
import java.util.Map;
import static java.lang.Math.abs;

/* use hash map */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2){
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

    public void printRes(int res){
        System.out.println(res);
    }

    public static void main(String[] args){
        ShortestWordDistance swd = new ShortestWordDistance();
        String[] inputs = new String[]{
                "practice", "makes", "perfect", "coding", "makes"
        };
        int dis = swd.shortestDistance(inputs, "coding", "makes");
        swd.printRes(dis);
    }
}
