//https://leetcode.cn/problems/palindrome-number/
public class question7 {
    public boolean solution1(int x) {
        String s = String.valueOf(x);
        //定义两个指针，一个指向头，一个指向尾
        int i = 0;
        int j = s.length() - 1;
        //当i<j时，说明还没遍历完
        while (i < j) {
            //如果当前两个指针指向的字符不相等，说明不是回文串
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            //如果相等，两个指针向中间移动
            i++;
            j--;
        }
        //如果遍历完了，说明是回文串
        return true;

    }

    public boolean solution2(int x){
        if (x < 0){
            return false;
        }
        int res = 0;
        int temp = x;
        while (temp != 0){
            int digit = temp % 10;
            res = res * 10 + digit;
            temp /= 10;
        }
        return res == x;

    }

    public boolean solution3(int x){
        int res = 0;
        int temp = x;
        while (res < temp){
            int digit = temp % 10;
            res = res * 10 + digit;
            if (res == temp) return true;
            temp /= 10;
        }

        return false;

    }
}
