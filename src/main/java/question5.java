//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
//        如果反转后整数超过 32 位的有符号整数的范围 [$−2^{31}$, $ 2^{31} − 1$] ，就返回 0。
//
//        假设环境不允许存储 64 位整数（有符号或无符号）
public class question5 {
    private static final int MAX = (int) (Math.pow(2, 31)-1);
    private static final int MIN = (int) (-Math.pow(2, 31));

    private static int reverse(int x) {
        System.out.println(MAX);
        System.out.println(MIN);
        int res = 0;
        while (x != 0) {
            //每次取末尾数字
            int tmp = x % 10;
            // 获取MAX的末尾数字
            int max = MAX % 10;
            // 获取MIN的末尾数字
            int min = MIN % 10;
            if(res>MAX/10 || (res==MAX/10 && tmp>max))
                return 0;
            if(res<MIN/10 || (res==MIN/10 && tmp<min))
                return 0;
            res = res * 10 + tmp;
            System.out.println(res);
            x /= 10;
        }
        return res;
    }
public static void main(String[] args) {
    int a = 1147483649;
    System.out.println(reverse(a));
}
}
