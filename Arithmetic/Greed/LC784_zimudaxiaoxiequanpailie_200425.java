package LeetCode.Arithmetic.Greed;

import java.util.LinkedList;
import java.util.List;

public class LC784_zimudaxiaoxiequanpailie_200425 {

    List<String> ret = new LinkedList<>();
    public List<String> letterCasePermutation(String S) {

        char[] chars = S.toCharArray();
        helper(chars,0,chars.length);
        return ret;
    }

    public void helper(char[] chars,int begin,int length){
        if (begin == length){
            ret.add(new String(chars));
            return;
        }
        if (chars[begin] >= 'A' && chars[begin] <= 'Z'){
            chars[begin] = (char)(chars[begin]-'A'+'a');
            helper(chars,begin+1,length);
            chars[begin] = (char)(chars[begin]-'a'+'A');
        }
        if (chars[begin] >= 'a' && chars[begin] <= 'z'){
            chars[begin] = (char)(chars[begin]-'a'+'A');
            helper(chars,begin+1,length);
            chars[begin] = (char)(chars[begin]-'A'+'a');
        }

        helper(chars,begin+1,length);

    }
}
