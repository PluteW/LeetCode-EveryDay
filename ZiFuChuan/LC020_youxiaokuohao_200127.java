package LeetCode.ZiFuChuan;

import java.util.Stack;

public class LC020_youxiaokuohao_200127 {
    public static void main(String args[]) {

        LC020_youxiaokuohao_200127 Solution = new LC020_youxiaokuohao_200127();
        boolean ret = Solution.solution();
        System.out.print(ret);
    }

    public boolean solution() {
        String s = "()[]{}[";
        if (s.length() == 0 || s.equals("")){
            return true;
        } else if ( s.length()%2 == 1) {
            return false;
        }

        String bracket = "([{}])";
        Stack<Character> left = new Stack();
        for (char c : s.toCharArray()) {
            if (bracket.indexOf(c) <3 ){
                left.push(c);
            }else if(bracket.indexOf(c) >2 && left.isEmpty()) {
                return false;
            }else if (bracket.indexOf(c) + bracket.indexOf(left.lastElement()) == 5 ){
                left.pop();
            }else {
                return false;
            }
        }
        return left.isEmpty();
    }

}
