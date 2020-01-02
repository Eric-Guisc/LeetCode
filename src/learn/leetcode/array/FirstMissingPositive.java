package learn.leetcode.array;

import java.util.Arrays;
import java.util.Spliterator;

/*
    难度：困难
    缺失的第一个正数:给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
    你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
//        if(nums.length == 0){
//            return 1;
//        }
//        Arrays.sort(nums);
//        int i = 0;
//        while(i < nums.length){
//            if(nums[i] < nums.length && nums[i] >= 1){
//                int tmp = nums[nums[i]-1];
//                nums[nums[i]-1] = nums[i];
//                nums[i] = tmp;
//            }
//            i++;
//        }
//        for(i = 0; i < nums.length;i++){
//            if(nums[i] != i+1){
//                return i+1;
//            }
//        }
//        return nums.length+1;

        /*
        我们考虑如果整数都出现，那么最后数组排列应该是[1,2,3,4,5,…,n]，每个都是递增1。
        于是乎，如果我们最后也排列成这种形式，那么只要不满足nums[i]-nums[i-1]不等于1，那么就找到了最小的未出现的整数，但是我们没法排序。
        所以我们可以强行另数组下标和存的值产生联系-> 令数字i出现在下标为i-1的位置，如果会越界则不做处理。
        比如[3,4,-1,1]->[-1,4,3,1]->[-1,1,3,4]->[1,-1,3,4];
         */

        for(int i=0;i<nums.length;){
            if(nums[i]>0&&nums[i]<=nums.length&&nums[i]!=nums[nums[i]-1]){
                //确定nums[i]的值对应的下标不越界，同时排除num[i]本身位置正确或者nums[i]应该放入的位置nums[i]-1原本就是nums[i](如[1,1])

                int index = nums[i];//
                nums[i] = nums[index -1];
                nums[index -1]=index;
                //换位置之后需要继续判断换过来的值是否在对的位置上，因此不能i++;
            }else{
                i++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
    public static void main(String []args){
        int[] nums={-3,-4,9,3,4,1,3,1};
        int result=firstMissingPositive(nums);
        System.out.println(result);
    }
}
