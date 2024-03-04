import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();

        int N = Integer.parseInt(s);
        Set<String> set = new TreeSet<>();

        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            if("enter".equals(sa[1])) set.add(sa[0]);
            else set.remove(sa[0]);
        }

        List<String> list = new ArrayList<>(set);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String name : list){
            sb.append(name).append("\n");
        }

        System.out.println(sb);

    }
}
