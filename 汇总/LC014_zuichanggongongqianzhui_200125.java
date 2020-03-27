package LeetCode.汇总;

public class LC014_zuichanggongongqianzhui_200125 {

    public static void main(String args[]) {
        LC014_zuichanggongongqianzhui_200125 Solution = new LC014_zuichanggongongqianzhui_200125();
        String ret = Solution.solution2();
        System.out.print(ret);
    }
//      方法 1 ： 扫描法
    public String solution( ){
        String[] strs = {"flower","flow","flight"};
        if (strs.length == 0) return "";        // 这一步一定要有，避免空数组的出现
        String profile = strs[0];
        for (int i = 0; i<strs.length ; i++) {
            while ( strs[i].indexOf(profile) != 0 ){
                profile = profile.substring(0,profile.length()-1);
                if (profile == ""){
                    return profile;
                }
            }
        }
        return profile;

    }

    public String solution2() {

        String[] strs = {"flower","flow","flight"};

        if (strs.length == 0) return "";

        for (int i = 0; i<strs[0].length();i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j<strs.length;j++) {
                if ( i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];

    }
}
