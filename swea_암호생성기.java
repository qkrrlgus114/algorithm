import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class swea_암호생성기 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        for(int w=1; w<=10; w++) {
            sc.nextInt();
            Queue<Integer> q = new LinkedList<Integer>();
            for(int i=0; i<8; i++) {
                q.add(sc.nextInt());
                System.out.println(9550%637);
            }
            boolean flag = true;
            while(true) {
                for(int i=1; i<=5; i++) {
                    if(q.peek()-i>0) {
                        q.add(q.remove()-i);                                            
                    }
                    else if(q.peek()-i<=0){
                        q.remove();
                        q.add(0);
                        flag=false;
                        break;
                    }
                }
                if(flag==false) break;
            }
            System.out.printf("#%d ",w);
            for(int i=0; i<8; i++) {
                System.out.printf("%d ",q.remove());
            }
            System.out.println();
        }
    }
}