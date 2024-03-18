import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InterfaceAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int N;
    static List<Egg> eggs = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        N = Integer.parseInt(s);
        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            eggs.add(new Egg(Integer.parseInt(sa[0]), Integer.parseInt(sa[1])));
        }

        dfs(0, 0);

        System.out.println(result);

    }

    // 지금 쥐어야 할 계란의 번호
    public static void dfs(int depth, int count) {
        // 마지막 계란이면 개수 판단
        if (depth == N) {
            result = Math.max(result, count);
            return;
        }

        Egg egg = eggs.get(depth);

        // 손에 쥔 계란이 깨졌으면 넘어감
        if (egg.getStr() == 0) {
            dfs(depth + 1, count);
            return;
        }

        // 현재 계란과 타겟의 내구도
        int cur_str = egg.getStr();
        int break_point = 0;
        // 깼는지 판단
        boolean breaking = false;

        for (int i = 0; i < N; i++) {
            // 자신이면 넘어감
            if (i == depth) continue;
            if (eggs.get(i).getStr() != 0) {
                breaking = true;
                Egg target = eggs.get(i);
                // 대상 복구용 내구도
                int target_index = i;
                int target_str = target.getStr();

                if (target.getStr() - egg.getWeight() <= 0) {
                    target.setStr(0);
                    break_point++;
                } else target.setStr(target.getStr() - egg.getWeight());
                if (egg.getStr() - target.getWeight() <= 0) {
                    egg.setStr(0);
                    break_point++;
                } else egg.setStr(egg.getStr() - target.getWeight());
                dfs(depth + 1, count + break_point);
                // 깼으면 원상복구
                eggs.get(target_index).setStr(target_str);
                egg.setStr(cur_str);
                break_point = 0;
            }
        }

        if(!breaking){
            dfs(depth + 1, count);
        }

    }
}

class Egg {
    private int str;
    private int weight;

    public Egg(int str, int weight) {
        this.str = str;
        this.weight = weight;
    }

    public int getStr() {
        return this.str;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setStr(int str) {
        this.str = str;
    }
}