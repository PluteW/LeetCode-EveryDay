package LeetCode.ZiFuChuan;

public class LC003_String_191231 {

    public static void main(String [] args) {

        String target = ""; //判断的额目标字符串

        char[] data = target.toCharArray();

        int num = 1;    //用于记录长度
        int head = 0;   //记录窗口开头位置
        int tail = 1;   //记录窗口末位位置

        while (data.length!=0&&data.length - head >= num && tail < data.length) {
            boolean r = false;
            for (int i = head; i < tail; i++) {
                if (data[i] == data[tail]) {
                    r = true;
                    if (tail - head  >= num) num = tail - head;
                    head++;         //  ①
                    tail = head + 1;
                    break;
                }
            }
            if (!r){
                tail++;
                r = !r;
            }

        }
        System.out.println(num);
    }
}

//
//
//    char[] data = s.toCharArray();
//
////        System.out.println(data[1]);
//
//    int num = 1;
//    int head = 0;
//    int tail = 1;
//
//
//        while (data.length!=0&&data.length - head >= num && tail < data.length) {
//
//        boolean r = false;
//        for (int i = head; i < tail; i++) {
//        if (data[i] == data[tail]) {
//        r = true;
//        if (tail - head  >= num) num = tail - head;
//        head++;
//        tail = head + 1;
//        break;
//        }
//        }
//        if (!r){
//
//        tail++;
//        r = !r;
//        }
//
//        }
//        return num;