package LeetCode.汇总;

import java.util.Arrays;

public class LC455_fenbinggan_200331 {


    /**
     * @Description：  分发饼干
     *      要求满足更多的孩子的胃口，所以先进行排序，
     *      然后从最小胃口，最小饼干开始尝试
     * @Params:     int[] g  胃口   int[] a   饼干尺寸
     * @return:     int  ret  满足胃口的孩子的数量
     * @author: Mr.Wang
     * @create: 23:32
    */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gLen = g.length;
        int sLen = s.length;
        int i = 0,j = 0;
        while(i<gLen&&j<sLen){
            if(g[i]<=s[j]){
                i++;
                j++;
            }else{
                j++;
            }
        }
        return i;
    }

}
