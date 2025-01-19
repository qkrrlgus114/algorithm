import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(bf.readLine());
        Deque<Ground> dq = new ArrayDeque<>();

        int maxW = 0;
        int maxH = 0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            if (dir == 1 || dir == 2) maxW = Math.max(maxW, len);
            else maxH = Math.max(maxH, len);

            dq.add(new Ground(dir, len));
        }

        // 가장 긴 가로를 먼저 찾아서 양 옆의 세로의 차이를 구한다. -> 빈 공간의 세로가 된다
        int diffH = 0;
        while (true) {
            Ground ground = dq.pollFirst();
            if ((ground.direction == 1 || ground.direction == 2) && ground.length == maxW) {
                Ground first = dq.pollFirst();
                Ground last = dq.pollLast();
                diffH = Math.abs(first.length - last.length);
                dq.addFirst(first);
                dq.addLast(last);
                dq.add(ground);
                break;
            }
            dq.add(ground);
        }

        // 가장 긴 세로를 먼저 찾아서 양 옆의 가로의 차이를 구한다. -> 빈 공간의 가로가 된다
        int diffW = 0;
        while (true) {
            Ground ground = dq.pollFirst();
            if ((ground.direction == 3 || ground.direction == 4) && ground.length == maxH) {
                Ground first = dq.pollFirst();
                Ground last = dq.pollLast();
                diffW = Math.abs(first.length - last.length);
                dq.addFirst(first);
                dq.addLast(last);
                dq.add(ground);
                break;
            }
            dq.add(ground);
        }
        
        System.out.println(((maxW * maxH) - (diffH * diffW)) * K);
    }
}

class Ground {
    Integer direction;
    Integer length;

    public Ground(Integer direction, Integer length) {
        this.direction = direction;
        this.length = length;
    }
}