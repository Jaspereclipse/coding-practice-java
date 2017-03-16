import java.util.*;

/**
 * Created by juanyan.li on 3/15/17.
 */
public class LonelyPixel {
    public int findLonelyPixelI(char[][] picture) {
        int height = picture.length;
        int width = picture[0].length;
        Map<Integer,Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();
        List<Integer[]> coors = new ArrayList<>();
        for (int i=0; i<height; i+=1) {
            for (int j=0; j<width; j+=1) {
                if (picture[i][j] == 'B') {
                    coors.add(new Integer[]{i, j});
                    mapX.put(i, mapX.containsKey(i) ? mapX.get(i) + 1 : 1);
                    mapY.put(j, mapY.containsKey(j) ? mapY.get(j) + 1 : 1);
                }
            }
        }
        int count = 0;
        for (Integer[] coor : coors) {
            if (mapX.get(coor[0]) == 1 && mapY.get(coor[1]) == 1) {
                count += 1;
            }
        }
        return count;
    }

    public int findLonelyPixelII(char[][] picture, int N) {
        int height = picture.length;
        int width = picture[0].length;
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colMap = new HashMap<>();
        for (int i=0; i<height; i+=1) {
            for (int j=0; j<width; j+=1) {
                if (picture[i][j] == 'B') {
                    if (rowMap.get(i) == null) rowMap.put(i, new HashSet<>());
                    if (colMap.get(j) == null) colMap.put(j, new HashSet<>());
                    rowMap.get(i).add(j);
                    colMap.get(j).add(i);
                }
            }
        }

        int count = 0;
        for (int row1 : rowMap.keySet()) {
            if (rowMap.get(row1).size() == N) {
                for (int col : rowMap.get(row1)) {
                    if (colMap.get(col).size() == N) {
                        Set<Integer> compare = null;
                        boolean pass = true;
                        for (int row2 : colMap.get(col)) {
                            if (compare == null) compare = rowMap.get(row2);
                            else if (!compare.equals(rowMap.get(row2))) {
                                pass = false;
                                break;
                            }
                        }
                        if (pass) count += 1;
                    }
                }
            }
        }
        return count;
    }
}
