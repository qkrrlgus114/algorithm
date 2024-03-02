import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String t = bf.readLine();
        int T = Integer.parseInt(t);
        List<Integer> list = new ArrayList<>();
        int value = 1;
        while(true) {
            int n = value * (value + 1) / 2;
            if(n>1000) break;
            list.add(n);
            value++;
        }

        for(int q=0; q<T; q++){
            String s = bf.readLine();
            int N = Integer.parseInt(s);
            boolean check = false;
            outer: for(int i=0; i < list.size(); i++){
                for(int j=0; j < list.size(); j++){
                    for(int k=0; k < list.size(); k++){
                        if(list.get(i) + list.get(j) + list.get(k) == N){
                            check = true;
                            break outer;
                        }
                    }
                }
            }
            if(!check) System.out.println(0);
            else System.out.println(1);

        }
    }


}
