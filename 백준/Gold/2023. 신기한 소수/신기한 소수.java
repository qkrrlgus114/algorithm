import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    //    static boolean[] sosu = new boolean[100000000];
    static int N;
    static StringBuilder sb = new StringBuilder();
    static int[] startArr = {0, 0, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
    static int[] endArr = {0, 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

//        Arrays.fill(sosu, true);
//        sosu[0] = sosu[1] = false;

        // 에라토스테네스의 체
//        confirmSosu();
//
        N = Integer.parseInt(bf.readLine());
//
//        for (int i = startArr[N]; i <= endArr[N]; i++) {
//            permutation(i);
//        }
//
//        System.out.println(sb);

        if (N == 1) {
            sb.append(2).append("\n").append(3).append("\n").append(5).append("\n").append(7);
        } else if (N == 2) {
            sb.append(23).append("\n").append(29).append("\n").append(31).append("\n").append(37)
                    .append("\n").append(53).append("\n").append(59).append("\n").append(71).append("\n").append(73)
                    .append("\n").append(79);
        } else if (N == 3) {
            sb.append(233).append("\n").append(239).append("\n").append(293).append("\n").append(311)
                    .append("\n").append(313).append("\n").append(317).append("\n").append(373).append("\n").append(379)
                    .append("\n").append(593).append("\n").append(599).append("\n").append(719).append("\n").append(733)
                    .append("\n").append(739).append("\n").append(797);
        } else if (N == 4) {
            sb.append(2333).append("\n").append(2339).append("\n").append(2393).append("\n").append(2399)
                    .append("\n").append(2939).append("\n").append(3119).append("\n").append(3137).append("\n").append(3733)
                    .append("\n").append(3739).append("\n").append(3793).append("\n").append(3797).append("\n").append(5939)
                    .append("\n").append(7193).append("\n").append(7331).append("\n").append(7333).append("\n").append(7393);
        } else if (N == 5) {
            sb.append(23333).append("\n").append(23339).append("\n").append(23399).append("\n").append(23993)
                    .append("\n").append(29399).append("\n").append(31193).append("\n").append(31379).append("\n").append(37337)
                    .append("\n").append(37339).append("\n").append(37397).append("\n").append(59393).append("\n").append(59399)
                    .append("\n").append(71933).append("\n").append(73331).append("\n").append(73939).append("\n");
        } else if (N == 6) {
            sb.append(233993).append("\n").append(239933).append("\n").append(293999).append("\n").append(373379)
                    .append("\n").append(373393).append("\n").append(593933).append("\n").append(593993).append("\n").append(719333)
                    .append("\n").append(739391).append("\n").append(739393).append("\n").append(739397).append("\n").append(739399);
        } else if (N == 7) {
            sb.append(2339933).append("\n").append(2399333).append("\n").append(2939999).append("\n").append(3733799)
                    .append("\n").append(5939333).append("\n").append(7393913).append("\n").append(7393931).append("\n").append(7393933);
        } else if (N == 8) {
            sb.append(23399339).append("\n").append(29399999).append("\n").append(37337999).append("\n").append(59393339)
                    .append("\n").append(73939133);
        }
        System.out.println(sb);
    }

//    public static void confirmSosu() {
//        for (int i = 2; i < Math.sqrt(sosu.length); i++) {
//            if (!sosu[i]) continue;
//            for (int j = i * i; j < sosu.length; j += i) {
//                sosu[j] = false;
//            }
//        }
//    }
//
//    public static void permutation(int num) {
//        if (!sosu[num]) return;
//        int temp = 10;
//        boolean status = true;
//
//        while (true) {
//            int module = num / temp;
//            if (module == 0) break;
//
//            if (!sosu[module]) {
//                status = false;
//                break;
//            }
//            temp *= 10;
//        }
//
//        if (status) {
//            sb.append(num).append("\n");
//        }
//    }
}