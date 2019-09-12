import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> pairs = new HashMap<Integer,Integer>();
        List<Integer> lista = new ArrayList<>(n);

        for (int i : ar) {
            lista.add(Integer.valueOf(i));
        }
        
        lista.forEach((sock) -> {
            if (pairs.containsKey(sock)) {
                Integer valor = pairs.get(sock).intValue() + 1;
                pairs.put(sock, valor);
            } else {
                pairs.putIfAbsent(sock, 1);
            }
        });

        AtomicInteger totalPairs = new AtomicInteger(0);
        pairs.entrySet().stream().forEach(e -> {
            totalPairs.set(totalPairs.get() + ((int)e.getValue()/2));
        });

        return totalPairs.intValue();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
