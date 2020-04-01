package LeetCode.Arithmetic.Greed;

import java.util.LinkedList;
import java.util.Queue;

public class LC649_Dota2canyiyuan_200401 {
    /**
     * @Description： 判断一方时，首先看对方还剩不剩下 ban
     *                  有ban，则自己被ban
     *                  否则，己方ban数量增加
     * @Params:     String senate  参议院人员组成
     * @return:     String  ret  获胜的一方标致
     * @author: Mr.Wang
     * @create: 22:28
    */
    public String predictPartyVictory(String senate) {
        Queue<Integer> queue = new LinkedList();
        int[] people = new int[]{0, 0};
        int[] bans = new int[]{0, 0};

        for (char person: senate.toCharArray()) {
            int x = person == 'R' ? 1 : 0;
            people[x]++;
            queue.add(x);
        }

        while (people[0] > 0 && people[1] > 0) {
            int x = queue.poll();
            if (bans[x] > 0) {
                bans[x]--;
                people[x]--;
            } else {
                bans[x^1]++;
                queue.add(x);
            }
        }

        return people[1] > 0 ? "Radiant" : "Dire";
    }
}
