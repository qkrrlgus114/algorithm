import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int r = Integer.parseInt(sa[1]);
        int c = Integer.parseInt(sa[2]);

        int size = (int) Math.pow(2, N);
        divide(size, r, c);

        System.out.println(count);
    }

    private static void divide(int size, int r, int c){
        if(size == 1) return;

        // 좌상
        if(r < size / 2 && c < size / 2){
            divide(size / 2, r, c);
        }
        // 우상
        else if(r < size / 2 && c >= size / 2){
            count += (int) Math.pow(size / 2, 2);
            divide(size / 2, r, c - size / 2);
        }
        // 좌하
        else if(r >= size / 2 && c < size / 2){
            count += (int) Math.pow(size / 2, 2) * 2;
            divide(size / 2, r - size / 2, c);
        }
        // 우하
        else if(r >= size / 2 && c >= size / 2){
            count += (int) Math.pow(size / 2, 2) * 3;
            divide(size / 2, r - size / 2, c - size / 2);
        }
    }

}
