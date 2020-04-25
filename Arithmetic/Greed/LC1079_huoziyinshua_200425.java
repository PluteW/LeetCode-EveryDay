package LeetCode.Arithmetic.Greed;

public class LC1079_huoziyinshua_200425 {
    int ret = 0;
    public int numTilePossibilities(String tiles) {

        int[] counter = new int[26];
        char[] chars = tiles.toCharArray();
        for (int i = 0;i<chars.length;i++){
            counter[chars[i]-'A']++;
        }

        ret = helper(counter);
        return ret;

    }

    public int helper(int[] counter){
        int temp = 0;
        for (int i = 0;i<counter.length;i++){
            if (counter[i] == 0)
                continue;
            temp++;
            counter[i]--;
            temp += helper(counter);
            counter[i]++;
        }
        return temp;
    }
}
