import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Sale {
    int index;
    int salePrice;
}

public class Main {

    static int N;
    static int[] potionPrices;
    static List<List<Sale>> salesInfo;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        // 물약의 종류
        N = Integer.parseInt(s);
        visited = new boolean[N + 1];

        String[] sa = bf.readLine().split(" ");
        // 물약의 가격들
        potionPrices = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            potionPrices[i] = Integer.parseInt(sa[i - 1]);
        }

        salesInfo = new ArrayList<>();
        // 할인 정보
        for (int i = 1; i <= N; i++) {
            s = bf.readLine();
            int p = Integer.parseInt(s);
            if (p == 0) {
                salesInfo.add(new ArrayList<>());
                continue;
            }

            List<Sale> list = new ArrayList<>();
            for (int j = 0; j < p; j++) {
                sa = bf.readLine().split(" ");
                Sale sale = new Sale();
                sale.index = Integer.parseInt(sa[0]);
                sale.salePrice = Integer.parseInt(sa[1]);
                list.add(sale);
            }

            salesInfo.add(list);
        }

        permutation(0, 0);
        System.out.println(answer);


    }

    private static void permutation(int depth, int sum){
        if(sum > answer){
            return;
        }
        // 종료 조건 (N개를 다 뽑으면 종료)
        if(depth == N){
            answer = Math.min(answer, sum);
            return;
        }

        // 재귀 조건
        for(int i=1; i<=N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            // 기존 가격 복사 진행
            int[] copyPrice = new int[N+1];
            copyPrice = copy(potionPrices, copyPrice);
            int tempPrice = potionPrices[i];

            // 할인이 있다면 가격 할인 진행
            List<Sale> list = salesInfo.get(i-1);
            for(int j=0; j<list.size(); j++){
                Sale sale = list.get(j);
                int saleIndex = sale.index;
                int salePrice = sale.salePrice;
                if(potionPrices[saleIndex] - salePrice < 1){
                    potionPrices[saleIndex] = 1;
                }else{
                    potionPrices[saleIndex] -= salePrice;
                }
            }
            permutation(depth + 1, sum + tempPrice);
            visited[i] = false;
            // 할인 가격 원상복구
            potionPrices = copy(copyPrice, potionPrices);

        }

    }

    private static int[] copy(int[] origin, int[] copy){
        for(int i=1; i<=N; i++){
            copy[i] = origin[i];
        }
        return copy;
    }

}


