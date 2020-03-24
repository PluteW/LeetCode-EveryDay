package LeetCode._test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FrogJump_200322 {

    public int forgJump(int n){
        Set<Integer> set = new HashSet<>();
        if (n == 1) return 1;
        if (n == 2) return 2;
        Stack<Integer> stack = new Stack<>();
        stack.add(n);
        int counter = 0;
        while (!stack.isEmpty()){
            int left = stack.pop();
            if (left == 0) set.add(counter);
            if (left - 1 >=0) stack.add(left-1);
            if (left - 2 >=0) stack.add(left-2);
            counter++;
        }
        return set.size();
    }

    public int frogJump2(int n){
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
