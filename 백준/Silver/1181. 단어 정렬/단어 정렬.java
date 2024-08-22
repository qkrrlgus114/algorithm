import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(bf.readLine());
        }

        String[] arr = set.stream().toArray(String[]::new);

        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String o1, String o2){
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}
