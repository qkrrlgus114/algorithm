import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] ground;
    static int[][] arr; // 양분
    static Queue<Tree> trees = new LinkedList<>();
    static Queue<Tree> deadTrees = new LinkedList<>();

    // 12시부터 시계방향
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]); // 땅의 크기
        M = Integer.parseInt(sa[1]); // 나무 개수
        K = Integer.parseInt(sa[2]); // 연도

        ground = new int[N][N];
        arr = new int[N][N];

        // 양분 입력
        for (int i = 0; i < N; i++) {
            sa = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(sa[j]);
            }
        }

        // ground 양분 초기화
        for (int i = 0; i < N; i++) {
            Arrays.fill(ground[i], 5);
        }

        // 나무 입력
        for (int q = 0; q < M; q++) {
            sa = bf.readLine().split(" ");
            int y = Integer.parseInt(sa[0]);
            int x = Integer.parseInt(sa[1]);
            int age = Integer.parseInt(sa[2]);

            trees.add(new Tree(y - 1, x - 1, age));
        }

        List<Tree> treeList = new ArrayList<>(trees);
        Collections.sort(treeList);
        trees = new LinkedList<>(treeList);


        // 년도 돌아야함.
        for (int k = 0; k < K; k++) {
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(trees.size());

    }

    // 봄
    private static void spring() {
        int size = trees.size();

        for (int i = 0; i < size; i++) {
            Tree tree = trees.poll();
            if (tree.age > ground[tree.i][tree.j]) {
                deadTrees.add(tree);
            } else {
                ground[tree.i][tree.j] -= tree.age;
                trees.add(new Tree(tree.i, tree.j, tree.age + 1));
            }
        }
    }

    // 여름
    private static void summer() {
        int size = deadTrees.size();

        for (int i = 0; i < size; i++) {
            Tree deadTree = deadTrees.poll();

            ground[deadTree.i][deadTree.j] += (int) (Math.floor(deadTree.age / 2));
        }
    }

    // 가을
    private static void fall() {
        List<Tree> parent = new ArrayList<>();
        int size = trees.size();
        for (int i = 0; i < size; i++) {

            Tree tree = trees.poll();
            int age = tree.age;
            parent.add(tree);

            if (age % 5 != 0) continue;
            // 5의 배수이면
            for (int q = 0; q < 8; q++) {
                int ndy = tree.i + dy[q];
                int ndx = tree.j + dx[q];
                if (ndy < 0 || ndx < 0 || ndy >= N || ndx >= N) continue;
                // 나무를 추가
                trees.add(new Tree(ndy, ndx, 1));
            }
        }
        for(Tree tree : parent){
            trees.add(tree);
        }
    }


    // 겨울
    private static void winter(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                ground[i][j] += arr[i][j];
            }
        }
    }
}

class Tree implements Comparable<Tree> {
    int i;
    int j;
    int age;

    public Tree(int i, int j, int age) {
        this.i = i;
        this.j = j;
        this.age = age;
    }

    public int compareTo(Tree o1) {
        return this.age - o1.age;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "i=" + i +
                ", j=" + j +
                ", age=" + age +
                '}';
    }
}
