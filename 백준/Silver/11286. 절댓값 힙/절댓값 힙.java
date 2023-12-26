import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static class custom implements Comparable<custom>{
        private int original;
        private int absValue;

        public custom(int original, int absValue) {
            this.original = original;
            this.absValue = absValue;
        }

        public int getOriginal() {
            return original;
        }

        public int getAbsValue() {
            return absValue;
        }

        @Override
        public int compareTo(custom o) {
            if(this.getAbsValue() > o.getAbsValue()){
                return 1;
            }else if(this.getAbsValue() < o.getAbsValue()){
                return -1;
            }else{
                if(this.getOriginal() > o.getOriginal()){
                    return 1;
                }else if(this.getOriginal() < o.getOriginal()){
                    return -1;
                }else{
                    return 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        PriorityQueue<custom> pq = new PriorityQueue<>();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);

        for(int i=0; i<N; i++){
            s = bf.readLine();
            int X = Integer.parseInt(s);

            if (X == 0) {
                if(!pq.isEmpty()){
                    System.out.println(pq.poll().getOriginal());
                }else{
                    System.out.println(0);
                }
            }else{
                pq.add(new custom(X, Math.abs(X)));
            }
        }

    }
}