import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] tree;
    static int max_tree = Integer.MIN_VALUE;
    static int result = Integer.MIN_VALUE;

    /*
    * M의 나무를 가져가기 위해서는 1부터 절단기의 높이를 올리면서 탐색해야함.
    * 근데 나무의 개수가 100만까지 가능해서 전체를 탐색하면 시초\
    * 1~나무의 최대 길이까지 절단기를 올려야함.
    * 1씩 올려서 확인하면 탐색이 많아지니 이분탐색을 이용
    * */



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        tree = new int[N];

        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            tree[i] = Integer.parseInt(sa[i]);
            if(max_tree < tree[i]) max_tree = tree[i];
        }

        binarySearch(0, max_tree);
        if(result == Integer.MIN_VALUE){
            System.out.println(0);
        }else{
            System.out.println(result);
        }
    }

    public static void binarySearch(int start, int end){
        // 종료 조건
        if(start >= end -1){
            return;
        }

        int mid = (start + end) / 2;
        Long sum = 0L;

        for(int i=0; i<tree.length; i++){
            if(tree[i] > mid){
                sum += tree[i] - mid;
                if(result > mid) return;
            }
        }

        // 합이 작으면
        if(sum < M){
            binarySearch(start, mid);
        }
        // 합이 크거나 같으면
        else{
            if(result < mid) result = mid;
            binarySearch(mid, end);
        }

    }



}