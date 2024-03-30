import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    * 1. 자주 나오는 단어가 앞
    * 2. 길이가 길 수록 앞
    * 3. 사전 순으로 앞
    * 4. M 이상의 단어만 외운다.
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            String s = bf.readLine();
            if(s.length() < M) continue;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>(){
            public int compare(String o1, String o2){
                if(map.get(o1) != map.get(o2)){
                    return map.get(o2) - map.get(o1);
                }
                if(o1.length() != o2.length()){
                    return o2.length() - o1.length();
                }
                return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(s).append("\n");
        }
        System.out.println(sb);

    }
}



