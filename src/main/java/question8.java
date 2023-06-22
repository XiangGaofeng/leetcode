//https://leetcode.cn/problems/container-with-most-water/
public class question8 {
    public static int solution(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            res = Math.max(res, area);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;

    }

}
