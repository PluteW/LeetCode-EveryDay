package LeetCode.PunchTheClock;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LC059_duiliezuidazhi_200307 {

    public static void main(String[] args) {
        LC059_duiliezuidazhi_200307 outer = new LC059_duiliezuidazhi_200307();
        //  调用方式举例说明
        MaxQueue obj = outer.new MaxQueue();
        int param_1 = obj.max_value();
        obj.push_back(2);
        int param_3 = obj.pop_front();
    }

    /**
     * @Description：    借助双向队列来保存最大值，使用队列来保存数字列表
     * @Params:
     * @return:     若队列为空，pop_front 和 max_value 返回 -1
     * @author: Mr.Wang
     * @create: 23:05
    */
    class MaxQueue {
        Deque<Integer> deque;       //  双向队列，用于保存当前的最大值
        Queue<Integer> queue;       //  单向队列，用于压退栈
        public MaxQueue() {
            deque = new LinkedList<>();
            queue = new LinkedList<>();
        }

        public int max_value() {
            return deque.isEmpty()?-1:deque.peek();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!deque.isEmpty() && deque.peekLast() < value)    deque.pollLast();
            deque.offerLast(value);
        }

        public int pop_front() {
            int temp = queue.isEmpty()?-1:queue.poll();
            if (!deque.isEmpty() && temp == deque.peek())
                deque.pollFirst();
            return temp;
        }
    }
}
