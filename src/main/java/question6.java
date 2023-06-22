//https://leetcode.cn/problems/string-to-integer-atoi/
public class question6 {
    public int myAtoi(String s) {
        int i = 0;
        int len = s.length();
        // 如果字符串以空格开头，就跳过所有空格，到第一个非空格字符
        while (i < len && s.charAt(i) == ' ') {
            i++;
        }
        //当i== len时，说明字符串全是空格，直接返回0
        if (i == len) {
            return 0;
        }
        //如果第一个非空格字符不是数字或正负号，直接返回0
        if (s.charAt(i) != '+' && s.charAt(i) != '-' && !Character.isDigit(s.charAt(i))) {
            return 0;
        }
        //如果第一个非空格字符是正负号，给定结果时正数还是负数
        int sign = 1;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        int res = 0;
        while (i < len && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            //提前判断res = res * 10 + digit是否会溢出
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            i++;
        }
        return sign * res;

    }

}
