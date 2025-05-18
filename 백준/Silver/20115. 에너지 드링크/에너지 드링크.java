import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        double[] arr = new double[N];
        Deque<Double> dq = new LinkedList<>();
        String[] sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(sa[i]);
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            dq.add(arr[i]);
        }


        while (dq.size() != 1) {
            double first = dq.pollFirst();
            double last = dq.pollLast();

            last += first / 2;
            dq.addLast(last);
        }

        System.out.println(dq.peek());
    }
}
