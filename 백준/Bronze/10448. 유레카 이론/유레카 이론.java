import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> list;
    static boolean[] isEureka = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String t = bf.readLine();
        int T = Integer.parseInt(t);
        list = new ArrayList<>();

        // 삼각수 리스트 구함
        getTriangleNum();
        // 미리 유레카 넘버 체크
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.size(); j++){
                for(int k=0; k<list.size(); k++){
                    int sum = list.get(i) + list.get(j) + list.get(k);
                    if(sum <= 1000) isEureka[sum] = true;
                }
            }
        }

        for(int q=0; q<T; q++){
            String s = bf.readLine();
            int N = Integer.parseInt(s);
            if(isEureka[N]) System.out.println(1);
            else System.out.println(0);
        }
    }

    // 삼각수의 리스트를 구하는 메서드
    public static void getTriangleNum(){
        int value = 1;
        while(true){
            int n = value * (value + 1) / 2;
            if(n > 1000) break;
            list.add(n);
            value++;
        }
    }



}
