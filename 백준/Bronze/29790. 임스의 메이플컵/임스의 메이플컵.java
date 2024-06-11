
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        String[] sa = bf.readLine().split(" ");
        int problems = Integer.parseInt(sa[0]);
        int union = Integer.parseInt(sa[1]);
        int maxLevel = Integer.parseInt(sa[2]);
        
        if(problems >= 1000){
            if(union >= 8000 || maxLevel >= 260){
                System.out.println("Very Good");
            }else{
                System.out.println("Good");
            }
        }else{
            System.out.println("Bad");
        }

    }
}