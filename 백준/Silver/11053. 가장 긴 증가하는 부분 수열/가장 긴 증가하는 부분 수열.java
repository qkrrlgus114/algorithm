import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int A = Integer.parseInt(s);

        int[] arr = new int[A];
        String[] sa = bf.readLine().split(" ");
        for(int i=0; i<A; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for(int i=1; i<A; i++){
            if(arr[i] > list.get(list.size() - 1)){
                list.add(arr[i]);
            }else if(arr[i] < list.get(list.size() - 1)){
                for(int j=0; j<list.size(); j++){
                    // 1. 같으면 못넣는 값이니 종료
                    if(list.get(j) == arr[i]) break;
                    else if(list.get(j) > arr[i]){
                        list.remove(j);
                        list.add(j, arr[i]);
                        break;
                    }
                }
            }
        }



        System.out.println(list.size());

    }





}