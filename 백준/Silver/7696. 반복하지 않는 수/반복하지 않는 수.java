import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        getNumber();

        while(true){
            String s = bf.readLine();
            int N = Integer.parseInt(s);
            if(N == 0) break;
            System.out.println(list.get(N-1));

        }
    }

    public static void getNumber(){
        int[] counting = new int[10];
        for(int i=1; list.size() < 1000001; i++){
            int num = i;
            boolean check = true;
            Arrays.fill(counting, 0);
            while(num > 0){
                int digit = num % 10;
                if(counting[digit] != 0){
                    check = false;
                    break;
                }else{
                    counting[digit]++;
                    num /= 10;
                }
            }
            if(check) list.add(i);
        }
    }
}