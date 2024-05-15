import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int a = Integer.parseInt(sa[0]);
        int b = Integer.parseInt(sa[1]);
        int c = Integer.parseInt(sa[2]);

        int[] A = new int[a];
        int[] B = new int[b];
        int[] C = new int[c];

        sa = bf.readLine().split(" ");
        for (int i = 0; i < a; i++) {
            A[i] = Integer.parseInt(sa[i]);
        }
        sa = bf.readLine().split(" ");
        for (int i = 0; i < b; i++) {
            B[i] = Integer.parseInt(sa[i]);
        }
        sa = bf.readLine().split(" ");
        for (int i = 0; i < c; i++) {
            C[i] = Integer.parseInt(sa[i]);
        }

        Arrays.sort(B);
        Arrays.sort(C);
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < a; i++) {
            if (answer == 0) break;
            int aCard = A[i];
            int bCard = search(aCard, B);
            int cCard1 = search(aCard, C);
            int cCard2 = search(bCard, C);

            int max = Math.max(Math.max(aCard, bCard), cCard1);
            int min = Math.min(Math.min(aCard, bCard), cCard1);
            answer = Math.min(answer, Math.abs(max - min));

            max = Math.max(Math.max(aCard, bCard), cCard2);
            min = Math.min(Math.min(aCard, bCard), cCard2);
            answer = Math.min(answer, Math.abs(max - min));
        }

        System.out.println(answer);
    }

    public static int search(int target, int[] card) {
        int l = 0;
        int r = card.length - 1;
        int answer = card[(l + r) / 2];

        while (l <= r) {
            int mid = (l + r) / 2;
            if (card[mid] == target) {
                return target;
            } else if (card[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

            if (Math.abs(answer - target) > Math.abs(card[mid] - target)) {
                answer = card[mid];
            }
        }
        return answer;
    }
}

