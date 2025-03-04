import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        List<Block> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            list.add(new Block(Integer.parseInt(sa[0]), Integer.parseInt(sa[1])));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.height == o2.height) {
                return o1.index - o2.index;
            }

            return o1.index - o2.index;
        });

        int answer = 0;

        int maxHeight = 0;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            if (maxHeight < list.get(i).height) {
                maxHeight = list.get(i).height;
                maxIndex = i;
            }
        }

        // 왼쪽 계산
        int leftHeight = list.get(0).height;
        int leftIndex = 0;
        for (int i = 0; i <= maxIndex; i++) {
            if (list.get(i).height >= leftHeight) {
                answer += (list.get(i).index - list.get(leftIndex).index) * leftHeight;
                leftHeight = list.get(i).height;
                leftIndex = i;
            }
        }
        
        // 오른쪽 계산
        int rightHeight = list.get(N - 1).height;
        int rightIndex = N - 1;
        for (int i = N - 1; i >= maxIndex; i--) {
            if (list.get(i).height >= rightHeight) {
                answer += (list.get(rightIndex).index - list.get(i).index) * rightHeight;
                rightHeight = list.get(i).height;
                rightIndex = i;
            }
        }

        System.out.println(answer + maxHeight);

    }

}

class Block {
    int index;
    int height;

    public Block(int index, int height) {
        this.index = index;
        this.height = height;
    }
}

