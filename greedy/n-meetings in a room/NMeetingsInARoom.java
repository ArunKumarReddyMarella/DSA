import java.util.*;
public class NMeetingsInARoom{
  static class interval implements Comparable<interval>{
    int s,e;
    interval(int s,int e){
      this.s=s;
      this.e=e;
    }
    public int compareTo(interval i){
     return this.e-i.e;
    }
  }
  static void meetingsPossible(int[] start, int[] finish) {
    // Write your code here
    interval[] intervals=new interval[start.length];
    for(int i=0;i<start.length;i++){
      intervals[i]=new interval(start[i],finish[i]);
    }
    Arrays.sort(intervals);
    int timelimit=intervals[0].e;
    System.out.print(intervals[0].s+" ");
    for(int i=1;i<start.length;i++){
      if(intervals[i].s>=timelimit){
        System.out.print(intervals[i].s+" ");
        timelimit=intervals[i].e;
      }
    }
  }
  public static void main(String[] args) {
    int[] s={20,22,30};
    int[] e={30,35,40};
    meetingsPossible(s,e);
  }
}
