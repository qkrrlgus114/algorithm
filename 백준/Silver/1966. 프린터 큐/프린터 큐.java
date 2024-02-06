import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String t = bf.readLine();
        int T = Integer.parseInt(t);

        for(int p=0; p<T; p++){
            boolean out = false;
            String[] sa = bf.readLine().split(" ");
            int N = Integer.parseInt(sa[0]);
            int M = Integer.parseInt(sa[1]);
            Queue<int[]> q = new LinkedList<>();
            sa = bf.readLine().split(" ");
            for(int i=0; i<N; i++){
                // 찾고자 하는 인덱스에 위치하면 1을 삽입.
                if(i == M){
                    q.add(new int[]{Integer.parseInt(sa[i]), 1});
                }else{
                    q.add(new int[]{Integer.parseInt(sa[i]), 0});
                }
            }

            int count = 1;
            if(q.size() == 1){
                System.out.println(1);
            }else{
                while(q.size() != 1){
                    int[] temp = q.poll();
                    int max = temp[0];
                    int check = temp[1];
                    int index = -1;
                    for(int i=0; i<q.size(); i++){
                        int[] poll = q.poll();
                        if(poll[0] > max){
                            max = poll[0];
                            check = poll[1];
                            index = i;
                        }
                        q.add(poll);
                    }
                    if(max == temp[0]){
                        if(check == 1){
                            out = true;
                            System.out.println(count);
                            break;
                        }
                    }else{
                        q.add(temp);
                        for(int i=0; i<index; i++){
                            q.add(q.poll());
                        }
                        int[] poll = q.poll();
                        if(poll[1] == 1){
                            out = true;
                            System.out.println(count);
                        }
                    }
                    count++;
                }
                if(!out){
                    System.out.println(count);
                }
            }
        }
    }
}