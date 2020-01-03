package learn.leetcode.sort;

    /*
    颜色分类：给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
    使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。此题中，我们使用整数
    0、 1 和 2 分别表示红色、白色和蓝色。
    要求：仅使用常数空间的一趟扫描算法
     */

    /*
    算法思路：沿着数组移动curr指针，若nums[curr]=0,则将其与nums[p0]互换，指针都右移；
    若nums[curr]=2，则将其与nums[p2]互换，p2--;
    若nums[curr]=1，则curr++;
     */

public class SortColors {
    public static void sortColors(int[] nums){
        int[] result=new int[nums.length];
        int p0=0;
        int p2=nums.length-1;
        int curr=p0;

        while(curr<=p2){
            if(nums[curr]==0){
                int tmp=nums[p0];
                nums[p0]=nums[curr];
                nums[curr]=tmp;
                curr++;
                p0++;
            }else if(nums[curr]==2){
                int tmp=nums[p2];
                nums[p2]=nums[curr];
                nums[curr]=tmp;
                p2--;
            }else
                curr++;
        }
    }
    public static void main(String []args){
        int[] nums={1,0,2,1,1,0};
        sortColors(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}
