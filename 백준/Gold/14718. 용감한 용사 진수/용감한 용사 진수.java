import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    /**
     * 0부터 300만까지 모든 스탯으로 몬스터를 잡으면 3억으로 시초가 발생한다.
     * 
     * 몬스터의 스탯을 기준으로 돌면서 탐색을 해야 함.
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);

        int answer = Integer.MAX_VALUE;

        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            sa = bf.readLine().split(" ");
            nodeList.add(new Node(Integer.parseInt(sa[0]), Integer.parseInt(sa[1]), Integer.parseInt(sa[2])));
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int hit = 0; // 잡은 몬스터

                    for (int l = 0; l < N; l++) {
                        Node node = nodeList.get(l); // 몬스터
                        if (nodeList.get(i).str >= node.str &&
                                nodeList.get(j).dex >= node.dex &&
                                nodeList.get(k).inte >= node.inte) {
                            hit++;
                        }
                    }

                    if (hit >= K) {
                        answer = Math.min(answer, nodeList.get(i).str + nodeList.get(j).dex + nodeList.get(k).inte);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}

class Node {
    int str;
    int dex;
    int inte;

    public Node(int str, int dex, int inte) {
        this.str = str;
        this.dex = dex;
        this.inte = inte;
    }
}