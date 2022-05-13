import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'minimalHeaviestSetA' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        int n = arr.size();
        int sum = 0;
        int[] T = new int[n + 1];

        for (int i = 0; i < n; i++) {
            sum += arr.get(i); 
        }

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        T[0] = 0;

        int minSize = 0;
        for (int w = 1; w <= n; w++) {
            int tmp1 = 0;
            int tmp2 = 0;
            for (int i = 1; i <= n; i++) {
                tmp2 = T[i - 1] + arr.get(i - 1);
                if (tmp2 > tmp1){
                    queue.add(arr.get(i - 1));
                    System.out.println(arr.get(i - 1));
                }
                else{
                    tmp2 = tmp1;
                }

                T[i - 1] = tmp1;
                tmp1 = tmp2;
            }

            T[n] = tmp1;

            if (T[n] > sum - T[n]) {
                minSize = w;
                break;
            }
        }

        List<Integer> items = new ArrayList<>();

        for (int i = 0; i < minSize; i++) {
            items.add(queue.poll());
        }

        Collections.reverse(items);

        return items;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.minimalHeaviestSetA(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
