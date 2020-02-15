package LeetCode.ZiFuChuan;

public class LC043_zifuchuanxiancheng_answer_200130 {
    public static void main(String args[]) {
        LC043_zifuchuanxiancheng_answer_200130 Solution = new LC043_zifuchuanxiancheng_answer_200130();
        String ret = Solution.solution();
        System.out.print(ret);
    }

    public String solution(){
        String num1 = "123";
        String num2 = "12345";

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int len = len1 + len2;
        int[] nums = new int[len];
        if (len1 <= len2) {
            multiplyTwoString(num1, num2, nums);
        } else {
            multiplyTwoString(num2, num1, nums);
        }
        for (int index = len - 1;index >= 0; index--) {
            if (nums[index] >= 10) {
                int temp = nums[index];
                nums[index] = temp % 10;
                nums[index - 1] += temp / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean begin = false;
        for (int i = 0; i < len; i++) {
            if (begin) {
                sb.append(nums[i]);
            } else {
                if (nums[i] != 0) {
                    sb.append(nums[i]);
                    begin = true;
                }
            }
        }
        return sb.toString();
    }

    private void multiplyTwoString(String str_short, String str_long, int[] nums) {
        int len_short = str_short.length();
        int len_long = str_long.length();
        int len = nums.length;
        for (int i = len_short - 1; i >= 0; i--) {
            int last = len - (len_short - i);
            int numA = str_short.charAt(i) - 48;
            for (int j= len_long - 1; j >= 0; j--) {
                int numB = str_long.charAt(j) - 48;
                int value = numA * numB;
                nums[last] += value;
                last--;
            }
        }
    }

    public String solution2(){
        String num1 = "123";
        String num2 = "12345";
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 保存计算结果
        String res = "0";

        // num2 逐位与 num1 相乘
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            // 保存 num2 第i位数字与 num1 相乘的结果
            StringBuilder temp = new StringBuilder();
            // 补 0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            int n2 = num2.charAt(i) - '0';

            // num2 的第 i 位数字 n2 与 num1 相乘
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = (n1 * n2 + carry) % 10;
                temp.append(product);
                carry = (n1 * n2 + carry) / 10;
            }
            // 将当前结果与新计算的结果求和作为新的结果
            res = addStrings(res, temp.reverse().toString());
        }
        return res;
    }

    /**
     * 对两个字符串数字进行相加，返回字符串形式的和
     */
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }
}
