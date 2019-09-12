import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    	int cont = 0;
    	
    	
    	for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				int sum = arr[x][y] + arr[x][y + 1] + arr [x][y + 2]
						        + arr[x + 1][y + 1] 
					 + arr[x + 2][y] + arr[x + 2][y + 1] + arr [x + 2][y + 2];
				
				if (x==0 && y==0) {
					cont = sum;
				} else if (sum > cont){
					cont = sum;
				}
				
			}
		}
    	
    	return cont;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/willy/Escritorio/archivo.txt"));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
