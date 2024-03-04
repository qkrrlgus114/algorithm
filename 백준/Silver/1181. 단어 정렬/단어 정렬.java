import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);

        List<String> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            s = bf.readLine();
            list.add(s);
        }

        HashSet<String> set = new HashSet<>(list);
        List<String> new_list = new ArrayList<>(set);

        Collections.sort(new_list, new Comparator<String>(){
            public int compare(String o1, String o2){
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }else{
                    return o1.length() - o2.length();
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String word : new_list){
            sb.append(word).append("\n");
        }
        System.out.println(sb);
    }
}
