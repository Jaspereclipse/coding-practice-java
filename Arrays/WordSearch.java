import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by juanyan.li on 3/22/17.
 */
public class WordSearch {
    // don't use Set<int[]> !
    public boolean exist(char[][] board, String word) {
        int height = board.length;
        int width = board[0].length;
        boolean found = false;
        char startChar = word.charAt(0);
        for (int i=0; i<height; i+=1) {
            for (int j=0; j<width; j+=1) {
                if (board[i][j] == startChar) { // candidate
                    found |= dfs(word, 0, board, new HashSet<>(), new Integer[]{i,j});
                    if (found) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(String word, int start, char[][] board, Set<List<Integer>> visited, Integer[] pos) {
        if (start == word.length() - 1) return true;
        boolean found = false;
        visited.add(Arrays.asList(pos));
        List<Integer[]> neighbors = findNeighbors(word.charAt(start+1), visited, board, pos);
        for (Integer[] neighbor : neighbors) {
            found |= dfs(word, start+1, board, visited, neighbor);
            if (found) return true;
        }
        visited.remove(Arrays.asList(pos));
        return false;
    }

    public List<Integer[]> findNeighbors(char nextWord, Set<List<Integer>> visited, char[][] board, Integer[] pos) {
        int height = board.length;
        int width = board[0].length;
        List<Integer[]> neighbors = new ArrayList<>();
        if (pos[0] > 0) { // up
            Integer[] next = new Integer[]{pos[0]-1, pos[1]};
            if (!visited.contains(Arrays.asList(next)) && nextWord==board[next[0]][next[1]]) {
                neighbors.add(next);
            }
        }
        if (pos[0] < height - 1) { // down
            Integer[] next = new Integer[]{pos[0]+1, pos[1]};
            if (!visited.contains(Arrays.asList(next)) && nextWord==board[next[0]][next[1]]) {
                neighbors.add(next);
            }
        }
        if (pos[1] > 0) { // left
            Integer[] next = new Integer[]{pos[0], pos[1]-1};
            if (!visited.contains(Arrays.asList(next)) && nextWord==board[next[0]][next[1]]) {
                neighbors.add(next);
            }

        }
        if (pos[1] < width - 1) { // right
            Integer[] next = new Integer[]{pos[0], pos[1]+1};
            if (!visited.contains(Arrays.asList(next)) && nextWord==board[next[0]][next[1]]) {
                neighbors.add(next);
            }
        }
        return neighbors;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = new char[][]{new char[]{'a', 'a'}};
        ws.exist(board, "aaa");
    }
}
