package learn.leetcode.array;

public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int n=nums1.length+nums2.length;
        double[] merge=new double[n];
        int i,j,k;
        for(i=0,j=0,k=0;i<nums1.length&&j<nums2.length;k++){
            if(nums1[i]<=nums2[j])
                merge[k]=nums1[i++];
            else
                merge[k]=nums2[j++];
        }
        while(i<nums1.length)
            merge[k++]=nums1[i++];
        while (j<nums2.length)
            merge[k++]=nums2[j++];
        if(n%2==1)
            return merge[n/2];
        else
            return (merge[n/2-1]+merge[n/2])/2.0;
    }
    public static void main(String[] args){
        int[] nums1={1,4,5,7,9,13,45};
        int[] nums2={2,4,5,6,8,34,67,89,99};
        double result=findMedianSortedArrays(nums1,nums2);
        System.out.println("中位数为："+result);
    }
}
