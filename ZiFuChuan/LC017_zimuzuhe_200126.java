package LeetCode.ZiFuChuan;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LC017_zimuzuhe_200126 {

    public static void main(String args[]) {

        LC017_zimuzuhe_200126 Solution = new LC017_zimuzuhe_200126();
        List ret = Solution.solution();
        System.out.print(ret);
    }

    public List solution(){

        String s = "23";

        String[] maps = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List ret = new ArrayList();
        if (s.length() == 0)
            return new ArrayList();
        searcher("",s,ret,maps);
        return ret;
    }
    public void searcher(String temp, String left, List ret, String[] maps) {
        if (left.equals("") || left == null){
            ret.add(temp);
            return;
        }else {
            char c = left.charAt(0);
            int index = c-'0';
            String letters = maps[index];
            left = left.substring(1);
            for (char d : letters.toCharArray()){
                searcher(temp+d, left,ret,maps);
            }
        }
    }


}
