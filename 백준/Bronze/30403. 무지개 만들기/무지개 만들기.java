
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        char[] c = bf.readLine().toCharArray();

        int[] lower = new int[7];
        int[] upper = new int[7];

        for(int i=0; i<c.length; i++){
            char word = c[i];

            switch (word){
                case 'R': upper[0]++; break;
                case 'O': upper[1]++; break;
                case 'Y': upper[2]++; break;
                case 'G': upper[3]++; break;
                case 'B': upper[4]++; break;
                case 'I': upper[5]++; break;
                case 'V': upper[6]++; break;
                case 'r': lower[0]++; break;
                case 'o': lower[1]++; break;
                case 'y': lower[2]++; break;
                case 'g': lower[3]++; break;
                case 'b': lower[4]++; break;
                case 'i': lower[5]++; break;
                case 'v': lower[6]++; break;
            }
        }

        int upperCount = Integer.MAX_VALUE;
        int lowerCount = Integer.MAX_VALUE;
        for(int i=0; i<7; i++){
            upperCount = Math.min(upperCount, upper[i]);
        }
        for(int i=0; i<7; i++){
            lowerCount = Math.min(lowerCount, lower[i]);
        }

        if(upperCount == Integer.MAX_VALUE) upperCount = 0;
        if(lowerCount == Integer.MAX_VALUE) lowerCount = 0;

        if(upperCount != 0 && lowerCount != 0){
            System.out.println("YeS");
        }else if(upperCount != 0){
            System.out.println("YES");
        }else if(lowerCount != 0){
            System.out.println("yes");
        }else{
            System.out.println("NO!");
        }
    }
}