package LeetCode.ShuZu;

import java.util.HashMap;
import java.util.Iterator;

public class LC001_Hashmap_191230 {

    public static void main(String [] args){

        HashMap hs = new HashMap();
        hs.put("语文",100);
        hs.put("英语",80);
        hs.put("数学",90);

        Iterator iterator = hs.keySet().iterator();

        System.out.println(hs.hashCode());
        System.out.println(iterator.hashCode());
        while(iterator.hasNext()){
            System.out.println(iterator.hashCode());
            System.out.println(hs.get((String)iterator.next()));
        }

    }
}
