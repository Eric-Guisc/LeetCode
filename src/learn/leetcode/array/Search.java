package learn.leetcode.array;

    /*
    搜索旋转排序数组：( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
    你可以假设数组中不存在重复的元素。
    你的算法时间复杂度必须是 O(log n) 级别。
     */

public class Search {
    /*
    要使时间复杂度为O(logN)，需要使用到二分查找
    一趟搞定，旋转后，一边符合升序，一边不符合，利用此特点
     */
    public static int search(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int mid=(left+right)/2;
        while(left<=right){
            if(nums[mid]==target)
                return mid;
            if(nums[left]<=nums[mid]){   //左边升序
                if(target>=nums[left] && target<nums[mid])
                    right=mid-1;
                else
                    left=mid+1;
            }else{  //右边升序
                if(target>nums[mid] && target<=nums[right])
                    left=mid+1;
                else
                    right=mid-1;
            }
            mid=(left+right)/2;
        }
        return -1;
    }
    public static void main(String []args){
        int[] nums={4,5,6,7,8,1,2,3};
        int target=1;
        System.out.println(search(nums,target));
    }
}
