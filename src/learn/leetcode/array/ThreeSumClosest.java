package learn.leetcode.array;

import java.util.Arrays;

/*
排序、双指针
初始化：ans=前三个数之和
    前指针指向start=i+1，后指针指向end=nums.length-1
    根据sum=nums[start]+nums[end]+nums[i]的结果，判断sum与target的距离（ Math.abs(target-sum)<Math.abs(target-ans) )成立，则更新ans
    同时判断sum和target的大小，若sum>target则end--，若sum<target则start++
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums,int target){
        Arrays.sort(nums);
        int ans=nums[0]+nums[1]+nums[2];//初始化
        for(int i=0;i<nums.length;i++){
            int start=i+1;
            int end=nums.length-1;
            while(start<end){
                int sum=nums[start]+nums[end]+nums[i];
                if(Math.abs(target-sum)<Math.abs(target-ans))
                    ans=sum;
                if(sum>target)
                    end--;
                else if(sum<target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }
    public static void main(String []args){
        int[] nums={-1,2,1,-4};
        int target=1;
        int result;
        result=threeSumClosest(nums,target);
        System.out.println(result);
    }
}
