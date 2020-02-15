package LeetCode.ZiFuChuan;

import java.util.Stack;

public class LC071_jianhualujing_200202 {

    public static void main(String args[]) {
        LC071_jianhualujing_200202 Solution = new LC071_jianhualujing_200202();
        String ret = Solution.solution();
        System.out.print(ret);
    }

    public String solution() {
        String path = "/home/";
        Stack<String> stack = new Stack<String>();
        String[] strs = path.split("/");
        for (String s : strs) {
            if (s.equals("..") && !stack.isEmpty()){
                    stack.pop();
            }else if (!s.equals(".") && !s.equals("..") && !s.equals("")){
                stack.push(s);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (stack.isEmpty()){
            return "/";
        }
        for (String s :stack){
            stringBuilder.append("/");
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public String solution2() {
        String path = "/home/";
        String[] s = path.split("/");
        for (String st: s) {
            System.out.println(st);
        }
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length; i++) {
            if (!stack.isEmpty() && s[i].equals(".."))
                stack.pop();
            else if (!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."))
                stack.push(s[i]);
        }
        if (stack.isEmpty())
            return "/";

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            res.append("/" + stack.get(i));
        }
        return res.toString();
    }
}
