import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
 
public class 체스 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        outer: for (int tc = 1; tc <= T; tc++) {
            char[][] arr = new char[8][8];
            for (int i = 0; i < 8; i++) {
                String str = sc.next();
                arr[i] = str.toCharArray();
            }
 
            char[] cr, cc;
            int cntc = 0;
            int cntr = 0;
            cr = new char[8];
            for (int i = 0; i < 8; i++) {
                cc = new char[8];
                for (int j = 0; j < 8; j++) {
                    if (arr[i][j] == 'O') {
                        cc[j]++;
                        cr[i]++;
                    }
 
                    if (cc[j] > 1) {
                        System.out.println("#" + tc + " " + "no");
                        continue outer;
                    }
                    cntc += cc[j];
                }
                if (cr[i] > 1) {
                    System.out.println("#" + tc + " " + "no");
                    continue outer;
                }
                cntr += cr[i];
            }
 
            if (cntc == 8 && cntr == 8) {
                System.out.println("#" + tc + " " + "yes");
 
            } else {
                System.out.println("#" + tc + " " + "no");
            }
        }
    }
 
}