package stock_buy_and_sell;

import java.util.ArrayList;

public class StockBuyAndSell {
    static ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
        // code here
        ArrayList<ArrayList<Integer>> profitRangeDays = new ArrayList<>();
        int startDate = -1;
        int endDate = -1;
        for(int i=0;i<n-1;i++){
            int todayProfit = A[i+1]-A[i];
            if(todayProfit>0){
                if(startDate == -1)
                    startDate = i;
                endDate=i+1;
            }
            else{
                if(startDate!=-1 && endDate!=-1){
                    ArrayList<Integer> startEndDates = new ArrayList<>();
                    startEndDates.add(startDate);
                    startEndDates.add(endDate);
                    profitRangeDays.add(startEndDates);
                }
                startDate = i+1;
                endDate = -1;
            }
        }
        if(startDate!=-1 && endDate!=-1){
            ArrayList<Integer> startEndDates = new ArrayList<>();
            startEndDates.add(startDate);
            startEndDates.add(endDate);
            profitRangeDays.add(startEndDates);
        }
        return profitRangeDays;
    }
    static int maxProfit_recursive(int prices[],int start,int end){
        if(start>=end)
            return 0;
        
        int profit = 0;
        for(int i=start;i<=end;i++){
            for(int j=i+1;j<=end;j++){
                int currentProfit=0;
                if(prices[j] > prices[i]){
                    currentProfit = (prices[j]-prices[i])+maxProfit_recursive(prices, start, i-1)+maxProfit_recursive(prices, j+1, end);
                }
                profit = Math.max(profit,currentProfit);
            }
        }
        return profit;
    }
    static int maxProfit_efficient(int prices[]){
        int profit = 0;
        for(int i=0;i<prices.length-1;i++){
            int todayProfit = prices[i+1]-prices[i];
            if(todayProfit>0)
                profit+=todayProfit;
        }
        return profit;
    }
    public static void main(String[] args) {
        int prices[] = { 100, 180, 260, 310, 40, 535, 695 };
        int prices1[] = {4,2,2,2,4};
        int prices2[] = {5,4,1,2,1};

		//System.out.print(maxProfit_recursive(prices, 0, prices.length - 1));
        //System.out.println(maxProfit_efficient(prices));
        System.out.println(stockBuySell(prices2, prices2.length));
    }
}
