import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int T = Integer.parseInt(input);

        for(int t=0; t<T; t++){
            String[] inputs = br.readLine().split(" ");
            List<Integer> list = new LinkedList<>();
            list.add(Integer.parseInt(inputs[1]));
            int count = 0;

            // 돌면서 키 비교
            for(int i=2; i<inputs.length; i++){
                // 현재 투입할 아이의 키
                int target = Integer.parseInt(inputs[i]);
                for(int j=0; j<list.size(); j++){
                    if(list.get(j) < target && j == list.size() - 1){
                        list.add(target);
                    }else if(list.get(j) > target) {
                        list.add(j, target);
                        count += list.size() - j - 1;
                        break;
                    }
                }
            }
            System.out.println(inputs[0] + " " + count);
        }
    }


}
