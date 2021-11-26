import java.util.*;
public class fractionalKnapsack {
    private static double getMaxValue(int[] wt, int[] val,int capacity) {
        Items[] items = new Items[wt.length];
        for (int i = 0; i < wt.length; i++) {
            items[i] = new Items(wt[i], val[i], i);
        }
  
        Arrays.sort(items, new Comparator < Items > () {
            @Override
            public int compare(Items o1, Items o2) {
                return (int)(o2.cost - o1.cost);
            }
        });
  
        double totalValue = 0;
  
        for (Items i: items) {
            int curWt = (int) i.wt;
            int curVal = (int) i.val;
            if (capacity - curWt >= 0) {
                capacity = capacity - curWt;
                totalValue += curVal;
            }else{
                double fraction=((double) capacity / (double) curWt);
                totalValue += (curVal * fraction);
                capacity= (int)(capacity - (curWt * fraction));
                break;
            }
        }
        return totalValue;
    }
  
    static class Items {
       
        double wt, val, ind,cost;
  
        public Items(int wt, int val, int ind) {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = (double) val / (double) wt;
        }
    }
  
    public static void main(String[] args) {
        int[] wt = { 5, 30, 25};
        int[] val = { 45, 60, 125 };
  
        int capacity = 50;
  
        double maxValue = getMaxValue(wt, val, capacity);
  
        System.out.println("Maximum value we can obtain = "+maxValue);
    }
}
