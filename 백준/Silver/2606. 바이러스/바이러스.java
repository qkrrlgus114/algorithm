import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int E;
    static boolean[] check;
    static ArrayList<Integer>[] arr;



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int E = Integer.parseInt(bf.readLine());

        arr = new ArrayList[N+1];
        for(int i=0; i < N+1; i++){
            arr[i] = new ArrayList<>();
        }

        check = new boolean[N+1];

        for(int i=0; i<E; i++){
            String[] str = bf.readLine().split(" ");

            arr[Integer.parseInt(str[0])].add(Integer.parseInt(str[1]));
            arr[Integer.parseInt(str[1])].add(Integer.parseInt(str[0]));
        }

        int count = bfs();
        System.out.println(count);
    }

    public static int bfs(){
        PriorityQueue<Integer> q = new PriorityQueue();
        q.add(1);
        int count = 0;
        check[1] = true;

        while(q.size() != 0){
            int temp = q.poll();

            for(int i=0; i<arr[temp].size(); i++){
                int curr = arr[temp].get(i);
                if(!check[curr]){
                    count ++;
                    check[curr] = true;
                    q.add(curr);
                }
            }
        }
        return count;
    }
}