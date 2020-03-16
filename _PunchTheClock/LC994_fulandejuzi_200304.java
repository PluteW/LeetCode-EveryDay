package LeetCode._PunchTheClock;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LC994_fulandejuzi_200304 {

    public static void main(String[] args) {
        LC994_fulandejuzi_200304 Solution = new LC994_fulandejuzi_200304();
        int ret = Solution.solution();
        System.out.println(ret);
    }

    public int solution(){
        int[][] grid = {
                {2,1,1},
                {0,1,1},
                {1,0,1}
        };
        if (grid.length == 0)
            return -1;
        int R = grid.length;
        int C = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer,Integer> map = new HashMap();
        int[] dr = {-1,0,1,0};
        int[] dc = {0,-1,0,1};
        for (int r = 0;r<R;r++){
            for (int c = 0;c<C;c++){
                if (grid[r][c] == 2){
                    int code = r*C+c;
                    queue.add(code);
                    map.put(code,0);
                }
            }
        }
        int ret = 0;
        while (!queue.isEmpty()){
            int code = queue.remove();
            int r = code/C;
            int c = code%C;
            for (int k = 0;k<4;k++){
                int tc = c + dc[k];
                int tr = r + dr[k];
                if (tr>-1 && tr<R && tc>-1 && tc<C && grid[tr][tc] == 1){
                    grid[tr][tc] = 2;
                    queue.add(tr*C+tc);
                    map.put(tr*C+tc,map.get(code)+1);
                    ret = map.get(tr*C+tc);
                }
            }
        }
        for (int r = 0;r<R;r++){
            for (int c=0;c<C;c++){
                if (grid[r][c] == 1)
                    return -1;
            }
        }
        return ret;
    }
}
