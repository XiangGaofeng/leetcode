//给你一个字符串 s，找到 s 中最长的回文子串。
//如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
public class question3 {
    private static String solution1(String s) {
        //定义最长回文子串
        String longestPalindrome = "";
        int max = 0;

        // 这两个循环相当于列举了所有的子串
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String example = s.substring(i, j);
                //判断当前子串是否为回文子串
                if (isPalindrome(example)) {
                    //如果是回文子串，判断当前子串的长度是否大于之前的最长回文子串
                    if (example.length() > max) {
                        //如果大于，将当前子串赋值给最长回文子串
                        longestPalindrome = example;
                        max = example.length();
                    }
                }

            }
        }
        return longestPalindrome;

    }

    private static boolean isPalindrome(String example) {
        for (int i = 0; i < example.length() / 2; i++) {
            if (example.charAt(i) != example.charAt(example.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcbbcab";
        String s1 = solution3(s);
        System.out.println(s1);
    }


    private static String solution2(String s) {

        //初始化最大长度和字符串起始位置
        int maxLen = 1; //最大长度至少为1
        int begin = 0;
        int len = s.length();
        if (len < 2) {
            return s;
        }

        //状态容器，dp[i][j]表示s[i...j]是否是回文串
        boolean[][] dp = new boolean[len][len];

        //初始化状态，显然单个字符一定是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();

        //i表示最左边字符串的字符索引，j表示最右边字符串的字符索引，所以必须j<i
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i && j < len - 1; j++) {
                //假设s[i...j]是回文串，那么s[i-1]和s[j+1]一定相等
                if (charArray[i] != charArray[j]) {
                    dp[j][i] = false;
                } else {
                    //之所以i - j < 3时，dp[j][i] = true，是因为当i - j<3时，
                    // s[i...j]最多只有3个字符，既然能走到这一步，说明s[i]和s[j]相等，那么s[i...j]一定是回文串
                    if (i - j < 3) {
                        dp[j][i] = true;
                    } else {
                        //否则，s[i...j]是否是回文串取决于s[i+1...j-1]是否是回文串，也就是状态转移
                        dp[j][i] = dp[j + 1][i - 1];
                    }

                    //如果s[i...j]是回文串，那么更新最大长度和起始位置
                    if (dp[j][i] && i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        begin = j;
                    }
                }

            }

        }
        return s.substring(begin, begin + maxLen);
    }

    private static String solution3(String s) {
        // maxL：记录最长回文串长度
        // maxl：记录最长回文串的开头位置
        int maxLen = 0, maxl = 0;
        // 枚举每个数
        int len = s.length();
        char[] charArray = s.toCharArray();
        for( int i = 0; i < len; ++i ) {
            // 1.以这个数和前一个数之间的空隙 作为对称中点
            int l = i-1, r = i ;
            // 左右寻找该回文列的尽头，注意边界
            for( ; l >= 0 && r < len && charArray[l] == charArray[r]; --l, ++r);
            if( maxLen < r-l-1 ) {
                maxl = l+1;
                maxLen = r-l-1;
            }

            // 2.以这个数 作为对称中点
            l = i-1;
            r = i+1;
            // 左右寻找该回文列的尽头，注意边界
            for( ; l >= 0 && r < len && charArray[l] == charArray[r]; --l, ++r);
            if( maxLen < r-l-1 ) {
                maxl = l+1;
                maxLen = r-l-1;
            }
        }
        return s.substring(maxl, maxl+maxLen);
    }
}
