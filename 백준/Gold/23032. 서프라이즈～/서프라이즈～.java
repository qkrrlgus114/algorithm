import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);
        String[] sa = bf.readLine().split(" ");
        int[] arr = new int[N];
        int[] prefixSum = new int[N+1];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        int e = Integer.MAX_VALUE;
        int steak = 0;

        for (int mid = 1; mid < N; mid++) {
            int leftSum = arr[mid - 1];
            int rightSum = arr[mid];
            int left = mid - 1;
            int right = mid;

            while (true) {
                int diff = Math.abs(leftSum - rightSum);
                if (diff == e) {
                    steak = Math.max(steak, leftSum + rightSum);
                } else if (diff < e) {
                    e = diff;
                    steak = leftSum + rightSum;
                }

                if (leftSum < rightSum) {
                    if (left == 0) {
                        break;
                    }
                    left--;
                    leftSum += arr[left];
                } else if (leftSum > rightSum) {
                    if (right == N - 1) {
                        break;
                    }
                    right++;
                    rightSum += arr[right];
                } else {
                    if (left == 0 || right == N - 1) {
                        break;
                    }
                    left--;
                    right++;
                    leftSum += arr[left];
                    rightSum += arr[right];
                }
            }
        }

        System.out.println(steak);
    }
}

