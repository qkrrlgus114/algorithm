import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    * 득표수를 1~14로 나눈 실수를 구한다. -> 이게 스태프의 점수
    * PQ를 이용한다.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(bf.readLine());
        int N = Integer.parseInt(bf.readLine());
        double voteCut = X * 0.05;
        boolean[] candidate = new boolean[26];
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>(){
            public int compare(double[] o1, double[] o2){
                return (int) (o2[0] - o1[0]);
            }
        });
        int[] chip = new int[26];
        Arrays.fill(chip, -1);

        for(int n=0; n<N; n++){
            String[] sa = bf.readLine().split(" ");
            int vote = Integer.parseInt(sa[1]);
            if((double)vote >= voteCut){
                int index = sa[0].charAt(0) - 'A';
                chip[index] = 0;
                candidate[index] = true;
                for(int i=1; i<=14; i++){
                    pq.add(new double[]{(double) vote / i, index});
                }
            }
        }


        for(int i=0; i<14; i++){
            double[] value = pq.poll();
            int index = (int) value[1];
            chip[index]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++){
            if(chip[i] != -1){
                sb.append((char) (i + 'A')).append(" ").append(chip[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

}