import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        parents = new int[N + 1];
        for(int i=1; i<=N; i++){
            parents[i] = i;
        }

        List<Integer> liars = new ArrayList<>();
        sa = bf.readLine().split(" ");

        for(int i=1; i<sa.length; i++){
            liars.add(Integer.parseInt(sa[i]));
        }

        // 거짓말쟁이를 루트로 설정
        for(int i=1; i<liars.size(); i++){
            union(liars.get(0), liars.get(i));
        }


        // 그룹을 저장해놓을 리스트배열
        List<String[]> list = new ArrayList<>();

        for(int i=0; i<M; i++){
            sa = bf.readLine().split(" ");
            sa[0] = "-1";
            Arrays.sort(sa);
            List<String> list1 = Arrays.asList(sa);
            list.add(sa);
            boolean check = false;
            for(int j=0; j<liars.size(); j++){
                int liar = liars.get(j);
                if(list1.contains(String.valueOf(liar))){
                    for(int k=1; k<sa.length; k++){
                        union(liar, Integer.parseInt(sa[k]));
                    }
                    check = true;
                    break;
                }
            }
            if(!check){
                for(int k=2; k<sa.length; k++){{
                    union(Integer.parseInt(sa[1]), Integer.parseInt(sa[k]));
                }}
            }
        }

        int answer = 0;
        for(int i=0; i<list.size(); i++){
            if(liars.size() == 0){
                answer++;
            }else{
                String[] group = list.get(i);
                int liar = liars.get(0);
                boolean check = false;
                for(int j=1; j<group.length; j++){
                    if(findParent(Integer.parseInt(group[j])) == findParent(liar)){
                        check = true;
                        break;
                    }
                }
                if(!check){
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }

    private static int findParent(int x){
        if(parents[x] == x) return x;
        return parents[x] = findParent(parents[x]);
    }

    private static void union(int a, int b){
        int parentA = findParent(a);
        int parentB = findParent(b);
        if(parentA != parentB){
            parents[parentB] = parentA;
        }
    }
}