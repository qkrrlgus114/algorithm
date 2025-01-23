import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    // <유저 아이디, 총 확인 횟수>
    static Map<String, Integer> map = new HashMap<>();
    static int startH, startM, endH, endM, endStH, endStM;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < 3; i++) {
            String[] s = st.nextToken().split(":");
            switch (i) {
                case 0:
                    startH = Integer.parseInt(s[0]);
                    startM = Integer.parseInt(s[1]);
                    break;
                case 1:
                    endH = Integer.parseInt(s[0]);
                    endM = Integer.parseInt(s[1]);
                    break;
                case 2:
                    endStH = Integer.parseInt(s[0]);
                    endStM = Integer.parseInt(s[1]);
            }
        }

        while (true) {
            String input = bf.readLine();
            if (input == null || input.isEmpty()) break;
            String[] str = input.split(" ");

            String[] time = str[0].split(":");
            int H = Integer.parseInt(time[0]);
            int M = Integer.parseInt(time[1]);
            String name = str[1];

            // 개강총회 이전 시간이라면
            if ((H < startH) || (H == startH && M <= startM)) {
                if (map.containsKey(name)) continue;
                map.put(name, 1);
            }
            // 개강총회 끝 <= 채팅기록 <= 스트리밍 끝
            else if (((endH == H && endM <= M) || (endH < H)) && ((endStH > H) || (endStH == H && endStM >= M))) {
                if (map.containsKey(name)) {
                    map.put(name, 2);
                }

            }
        }

        int result = 0;
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() == 2) result++;
        }

        System.out.println(result);

    }


}