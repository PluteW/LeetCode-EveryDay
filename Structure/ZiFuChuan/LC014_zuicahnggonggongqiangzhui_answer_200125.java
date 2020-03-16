package LeetCode.Structure.ZiFuChuan;

public class LC014_zuicahnggonggongqiangzhui_answer_200125 {

    public static void main(String args[]) {
        LC014_zuicahnggonggongqiangzhui_answer_200125 Solution = new LC014_zuicahnggonggongqiangzhui_answer_200125();
        String ret = Solution.solution();
        System.out.print(ret);
    }

//    方法 1 ：水平扫描法
    public String solution() {
        String[] strs = {"flower","flow","flight"};
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
//              indexOf(int ch): 返回指定字符在字符串中第一次出现处的索引
//              不等于0说明不是在开头的位置，所以下面将长度减一
                prefix = prefix.substring(0, prefix.length() - 1);
//                substring(int beginIndex, int endIndex)返回一个新字符串，它是此字符串的一个子字符串。
//                该子字符串从指定的 beginIndex 处开始， endIndex:到指定的 endIndex-1处结束。
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public String solution2(){
        String[] strs = {"flower","flow","flight"};
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
