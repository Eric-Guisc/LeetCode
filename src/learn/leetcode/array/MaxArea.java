package learn.leetcode.array;

public class MaxArea {
//    时间复杂度太大
//    public static int maxArea(int[] height){
//        int n=height.length;
//        int max=0;
//        int area;
//        for(int i=0;i<n-1;i++)
//            for(int j=i+1;j<n;j++) {
//                if (height[i] <= height[j])
//                    area = height[i] * (j - i);
//                else
//                    area = height[j] * (j - i);
//                if(max<area)
//                    max=area;
//            }
//        return max;
//    }
    //双指针法，题解
    public static int maxArea(int[] height){
        int max=0;
        for(int i=0,j=height.length-1;i<j;){
            int x=j-i;
            int y=height[i]>height[j]?height[j--]:height[i++];
            if(x*y>max)
                max=x*y;
        }
        return max;
    }
    public static void main(String[] args){
        int[] height={1,8,6,2,5,4,8,3,7};
        int max=maxArea(height);
        System.out.println(max);
    }
}
