package learn.leetcode.sort;

    /*
    合并区间:给出一个区间的集合，请合并所有重叠的区间。
     */

    /*
    首先按照区间的左端点进行排序,形成【1，6】【2，5】，【7，9】，【8，15】
    取第一个区间【1，6】，然后判断该区间的右端点是否大于等于下一个区间的左端点，
    记为条件1，好，现在满足，再取【1，6】【2，5】右端点的最大值为6，则不用修改
    【1，6】的区间。再次判断【1，6】【7，9】，不满足条件1，则将【1，6】加入到
    结果区间中。使得当前区间变为【7，9】，判断【7，9】与【8，15】，满足条件1，
    取右端点最大值为15，将【7，9】改为【7，15】，由于遍历结束，将【7，15】加
    入到结果区间中。最后返回【1，6】【7，15】。
     */

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Merge {
    private static class Interval{
        int start;
        int end;

        Interval(int[] interval){
            this.start=interval[0];
            this.end=interval[1];
        }
        int[] toArray(){
            return new int[]{this.start,this.end};
        }
    }

    private static class IntervalComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval a, Interval b) {
            return Integer.compare(a.start,b.start);
        }
    }

    public static int[][] merge(int[][] intervals){
        List<Interval> intervalsList=new LinkedList<>();
        for(int[] interval:intervals){
            intervalsList.add(new Interval(interval));
        }
        intervalsList.sort(new IntervalComparator());

        LinkedList<Interval> merged=new LinkedList<>();
        for(Interval interval:intervalsList){
            if(merged.isEmpty() || merged.getLast().end<interval.start){
                merged.add(interval);
            }
            else {
                merged.getLast().end=Math.max(merged.getLast().end,interval.end);
            }
        }
        int i=0;
        int[][] result=new int[merged.size()][2];
        for(Interval mergedInterval:merged){
            result[i]=mergedInterval.toArray();
            i++;
        }
        return result;
    }

    public static void main(String []args){
        int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        int[][] result=new int[3][2];
        result=merge(intervals);
        for(int i=0;i<result.length;i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(result[i][j] + "  ");
            }
            System.out.println();
        }

    }
}
