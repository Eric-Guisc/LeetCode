package learn.leetcode.array;

    /*
    在排序数组中查找元素的第一个和最后一个位置：给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    你的算法时间复杂度必须是 O(log n) 级别。
    如果数组中不存在目标值，返回 [-1, -1]。
     */

    //使用二分查找找到目标值的其中一个下标，再根据该下标向左向右分别遍历得到初始下标和结束下标
public class SearchRange {
    public static int[] searchRange(int[] nums,int target){
        int[] result = new int[]{-1, -1};
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left + right)/2;
            if(nums[mid]==target){                   //核心部分
                while(mid>=left && nums[mid]==target){
                    mid--;
                }
                result[0] = mid+1;
                mid = (left + right)/2;      //上面用了mid--这里将它恢复
                while(mid<=right && nums[mid]==target){
                    mid++;
                }
                result[1] = mid - 1;
                break;
            }else if (nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return result;
    }
    public static void main(String []args){
        int[] nums={5,7,7,8,8,10};
        int target=8;
        int[] result=searchRange(nums,target);
        System.out.println("["+result[0]+","+result[1]+"]");
    }

}
