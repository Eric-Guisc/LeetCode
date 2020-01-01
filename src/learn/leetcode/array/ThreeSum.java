package learn.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums){
//        不太会的   先排序，再用双指针
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;   //-4 -1 -1 0 1 2
            int j = nums.length - 1;
            int target = 0 - nums[i];
            int k = i + 1;
            while (k < j) {
                if (nums[k] + nums[j] == target) {
                    List<Integer> item = Arrays.asList(nums[i], nums[k], nums[j]);
                    result.add(item);
                    while (k < j && nums[k] == nums[k + 1]) k++;
                    while (k < j && nums[j] == nums[j - 1]) j--;
                    k++;j--;
                } else if (nums[k] + nums[j] < target) {
                    k++;
                } else {
                    j--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
//        int[] nums={-1,0,1,2,-1,-4};
        int[] nums={1,1,1};
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        result=threeSum(nums);
        for(int i=0;i<result.size();i++) {
            System.out.print("[");
            for (int j = 0; j < 3; j++) {
                System.out.print(result.get(i).get(j)+" ");
            }
            System.out.println("]");
        }
    }
}
//死循环了
//        for(int i=0;i<nums.length-2;i++){
//            for(int j=nums.length-1;j>0;){
//                List<Integer> list=new ArrayList<>();
//                if(nums[i]+nums[j-1]+nums[j]==0){
//                    list.add(nums[i]);
//                    list.add(nums[j-1]);
//                    list.add(nums[j]);
//                    result.add(list);
//                }
//                else if(nums[i]+nums[j-1]+nums[j]<0)
//                    break;
//                else
//                    j--;
//            }
//        }
//        return result;