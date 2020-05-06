package LeetCode.Structure.Hash;

import java.util.HashSet;

public class LC0104_huiwenxulie_200505 {

        public boolean canPermutePalindrome(String s) {
            if (s==null||s.length()<1){
                return false;
            }
            char[] chars = s.toCharArray();
            HashSet<Character> characters = new HashSet<Character>();
            for (Character character : chars) {
                if (characters.contains(character)){
                    characters.remove(character);
                }else {
                    characters.add(character);
                }
            }
            return characters.size()<=1;
        }
}
