import java.util.HashSet;

public class question2 {
    static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        // 定义一个HashMap，用来存储字符和字符的位置
        HashSet<Character> map = new HashSet<>();
        // 定义一个最大长度
        int maxLen = 0;
        int left = 0;
        int currentLen = 0;
        for (int right = 0; right < s.length(); right++) {
            // 如果map中包含当前字符，将left指针指向当前字符的下一个位置
            if (!(map.contains(s.charAt(right)))) {
                map.add(s.charAt(right));
                currentLen++;
                maxLen = Math.max(maxLen, currentLen);
                right++;
            } else {
                while (map.contains(s.charAt(right))) {
                    map.remove(s.charAt(left));
                    left++;
                    currentLen--;
                }
                map.add(s.charAt(right));
                currentLen++;
                right++;

            }


        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcbbcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }
}

