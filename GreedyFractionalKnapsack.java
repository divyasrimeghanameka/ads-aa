import java.util.*;
class Item
{
    int weight,profit;
    double ratio;
    Item(int weight, int profit)
    {
        this.weight=weight;
        this.profit=profit;
        this.ratio=(double)profit/weight;
    }
}
public class GreedyFractionalKnapsack
{
    public static double getMaxProfit(Item[] items, int m)
    {
        Arrays.sort(items,(a,b)->Double.compare(b.ratio, a.ratio));
        double maxprofit=0.0;
        System.out.println("Items placed in bag:");
        for(Item item:items)
        {
            if(item.weight<=m)
            {
                maxprofit+=item.profit;
                System.out.println("Item: (weight:"+item.weight+", profit:"+item.profit+")-Taken fully");
                m-=item.weight;
            }
            else
            {
                double fraction=(double)m/item.weight;
                maxprofit+=item.profit*fraction;
                System.out.println("Item:(Weight:"+item.weight+"profit:"+item.profit*fraction+")-taken "+fraction*100+"%");
                break;
            }
        }
            return maxprofit;
    }
    public static void main(String[]args)
    {
        Item[] items={new Item(10,60),new Item(20,100),new Item(30,120)};
        int m=50;
        double maxprofit=getMaxProfit(items,m);
        System.out.println("Maximum profit in knapsack:"+maxprofit);
    }
}
output:
Items placed in bag:
Item: (weight:10, profit:60)-Taken fully
Item: (weight:20, profit:100)-Taken fully
Item:(Weight:30profit:80.0)-taken 66.66666666666666%
Maximum profit in knapsack:240.0
