import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// 9. 三数之和
public class question9 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < len-2; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = len-1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum >0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while (j<k && nums[j] == nums[++j]) ;
                    while (j<k && nums[k] == nums[--k]);

                }
            }
        }
        return res;

    }



    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
}
