import java.util.*;

/**
 * Created by juanyan.li on 3/23/17.
 */
public class WordSearchII {
    // use trie
    // use boolean[][] to store visited nodes !!
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) trie.insert(word);
        int height = board.length;
        int width = board[0].length;
        Set<String> results = new HashSet<>();
        boolean[][] visited = new boolean[height][width];
        for (int i=0; i<height; i+=1) {
            for (int j=0; j<width; j+=1) {
                String prefix = String.valueOf(board[i][j]);
                if (trie.startsWith(prefix)) {
                    List<Integer> pos = new ArrayList<>();
                    pos.add(i);
                    pos.add(j);
                    backtrack(prefix, board, i, j, visited, trie, results);
                    if (results.size() == words.length) return new ArrayList<>(results);
                }
            }
        }
        return new ArrayList<>(results);
    }

    public void backtrack(String prefix,
                          char[][] board,
                          int x,
                          int y,
                          boolean[][] visited,
                          Trie trie,
                          Set<String> results) {
        if (trie.search(prefix)) results.add(prefix); // found one
        visited[x][y] = true;
        List<List<Integer>> neighbors = findNeighbors(x, y, board, visited);
        for (List<Integer> neighbor : neighbors) {
            String nextPrefix = prefix + String.valueOf(board[neighbor.get(0)][neighbor.get(1)]);
            if (trie.startsWith(nextPrefix)) {
                backtrack(nextPrefix, board, neighbor.get(0), neighbor.get(1), visited, trie, results);
            }
        }
        visited[x][y] = false;
        return;
    }

    public List<List<Integer>> findNeighbors(int x, int y, char[][] board, boolean[][] visited) {
        List<List<Integer>> neighbors = new ArrayList<>();
        int height = board.length;
        int width = board[0].length;
        if (x > 0 && !visited[x-1][y]) neighbors.add(Arrays.asList(new Integer[]{x-1, y})); // up
        if (x < height - 1 && !visited[x+1][y]) neighbors.add(Arrays.asList(new Integer[]{x+1, y})); // up
        if (y > 0 && !visited[x][y-1]) neighbors.add(Arrays.asList(new Integer[]{x, y-1})); // up
        if (y < width - 1 && !visited[x][y+1]) neighbors.add(Arrays.asList(new Integer[]{x, y+1})); // up
        return neighbors;
    }
}
