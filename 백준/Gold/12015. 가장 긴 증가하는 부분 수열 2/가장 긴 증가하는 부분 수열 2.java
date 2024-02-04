import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> list;
    static int[] arr;
    static int temp = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int A = Integer.parseInt(s);

        arr = new int[A];
        String[] sa = bf.readLine().split(" ");
        for(int i=0; i<A; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        list = new ArrayList<>();
        list.add(arr[0]);

        for(int i=1; i<A; i++){
            if(arr[i] > list.get(list.size() - 1)){
                list.add(arr[i]);
            }else if(arr[i] < list.get(list.size() - 1)){
                // 이분탐색 시작
                temp = 0;
                binarySearch(0, list.size() - 1, i);
                list.set(temp, arr[i]);
            }
        }
        System.out.println(list.size());
    }

    public static void binarySearch(int low, int high, int t_index){
        if(low > high){
            return;
        }

        int mid = (low + high) / 2;

        if(list.get(mid) < arr[t_index]){
            binarySearch(mid+1, high, t_index);
        }
        else if(list.get(mid) >= arr[t_index]){
            temp = mid;
            binarySearch(low, mid-1, t_index);
        }
    }




}