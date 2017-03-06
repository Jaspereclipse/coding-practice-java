import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by juanyan.li on 3/1/17.
 */
public class PascalTriangle {
    public List<List<Integer>> pascalTriangleI(int numRows){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows < 1) return res;
        res.add(Arrays.asList(new Integer[]{1}));
        for (int i=1; i<numRows; i+=1){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j=1; j<i; j+=1){
                row.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }

    // only print k-th row, O(k) extra space
    public List<Integer> pascalTriangleII(int rowIndex){
        Integer[] res = new Integer[rowIndex]; // results
        if (rowIndex < 1) return Arrays.asList(res);
        int[] ref = new int[rowIndex-1]; // references
        for (int i=0; i<=rowIndex/2; i+=1){
            res[i] = updateRef(ref, i);
        }
        for (int i=rowIndex-1; i>=rowIndex/2; i-=1){
            res[i] = res[res.length-i-1];
        }
        return Arrays.asList(res);
    }

    // update references and return (i+1)-th value of the k-th row
    public int updateRef(int[] ref, int i){
        if (i == 0) {
            for (int j=0; j<ref.length; j+=1) ref[j]=1;
            return 1;
        }
        for (int j=1; j<ref.length-i; j+=1){
            int tmp = ref[j];
            ref[j] = ref[j-1] + tmp;
        }
        if (ref.length - i - 1 < 0){
            return ref[ref.length-i];
        }
        return ref[ref.length-i-1] + ref[ref.length-i];
    }

    public void printResI(List<List<Integer>> res){
        for (List<Integer> row : res){
            for (int elem: row){
                System.out.print(elem+" ");
            }
            System.out.println();
        }
    }

    public void printResII(List<Integer> res){
        for (int elem: res){
            System.out.print(elem+" ");
        }
    }

    public static void main(String[] args){
        PascalTriangle pt = new PascalTriangle();
        List<List<Integer>> resI = pt.pascalTriangleI(5);
        pt.printResI(resI);
        List<Integer> resII = pt.pascalTriangleII(2);
        pt.printResII(resII);
    }
}
