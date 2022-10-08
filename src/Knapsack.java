import java.util.Arrays;
import java.util.Comparator;

public class Knapsack {
    public static Double fractional(Item[] items, double W) {
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item x, Item y) {
                return y.vbyw.compareTo(x.vbyw);
            }
        });

        Double profit = 0.0;
        int i = 0;
        while (W > 0 && i < items.length) {
            profit += items[i].vbyw * Math.min(W, items[i].weight);
            W -= items[i].weight;
            i++;
        }

        return profit;
    }

    public static Double zeroOne(Item[] items, int ksWeight) {
        double[][] dp = new double[items.length + 1][ksWeight + 1];

        for (int i = 0; i <= items.length; i++) {
            for (int w = 0; w <= ksWeight; w++) {
                if (i == 0 || w == 0)
                    continue;

                if (w - items[i - 1].weight < 0)
                    dp[i][w] = dp[i - 1][w];
                else
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - items[i - 1].weight] + items[i - 1].value);

                System.out.print(dp[i][w] + " ");
            }
            System.out.println();
        }

        return dp[items.length][ksWeight];
    }
}

class Item {
    Integer value;
    Integer weight;
    Integer vbyw;

    Item(Integer value, Integer weight) {
        this.value = value;
        this.weight = weight;
        vbyw = value / weight;
    }
}
