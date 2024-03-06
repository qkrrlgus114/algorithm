import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static String[] name;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        name = new String[N];
        for(int i=0; i<N; i++){
            String s = bf.readLine();
            name[i] = s;
        }
        Arrays.sort(name);

        int count = 0;

        for(int i=0; i<M; i++){
            String s = bf.readLine();
            boolean result = binarySearch(0, N - 1, s);
            count += result ? 1 : 0;
        }
        System.out.println(count);
    }

    public static boolean binarySearch(int low, int high, String target){
        if(low > high){
            return false;
        }

        int mid = (low + high) / 2;

        // 뒤에 있다는 뜻
        if(name[mid].compareTo(target) < 0){
            return binarySearch(mid + 1, high, target);
        }

        // 앞에 있다는 뜻
        if(name[mid].compareTo(target) > 0){
            return binarySearch(low, mid - 1, target);
        }

        // 일치함
        if(name[mid].compareTo(target) == 0){
            return true;
        }

        return false;
    }
}
