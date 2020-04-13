package LeetCode.Arithmetic.ReCall;

import java.util.ArrayList;
import java.util.List;

public class LC401_erjinzhishoubiao_200413 {
    /**
     * @Description：  根据有多少个灯亮，返回可能的时间
     * @Params:     int num  亮灯的个数
     * @return:     List<String> times  可能的时间
     * @author: Mr.Wang
     * @create: 23:30
    */
    public List<String> readBinaryWatch(int num) {
        List<String> times=new ArrayList<>();
        for(int h=0;h<12;h++){
            for(int m=0;m<60;m++){
                if(Integer.bitCount(h)+Integer.bitCount(m)==num)
                    times.add(String.format("%d:%02d",h,m));
            }
        }
        return times;
    }
}
