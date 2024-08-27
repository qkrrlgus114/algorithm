import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int C = Integer.parseInt(sa[1]);

        Map<Integer, Integer> map = new LinkedHashMap<>();

        sa = bf.readLine().split(" ");

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(sa[i]);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        while(map.size() != 0){
            Integer count = 0;
            Integer maxNum = 0;

            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(count < entry.getValue()){
                    count = entry.getValue();
                    maxNum = entry.getKey();
                }
            }

            for(int i=0; i<count; i++){
                sb.append(maxNum).append(" ");
            }

            map.remove(maxNum);
        }

        System.out.println(sb);
    }
}
