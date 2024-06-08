import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();

        StringBuilder mainSb = new StringBuilder();
        StringBuilder subSb = new StringBuilder();

        boolean check = false;

        for(int i=0; i<s.length(); i++){
            if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                if(check) mainSb.append(s.charAt(i));
                else subSb.append(s.charAt(i));
            }else if(s.charAt(i) == '<' || s.charAt(i) == '>'){
                if(subSb.length() != 0){
                    mainSb.append(subSb.reverse());
                    subSb.setLength(0);
                }
                if(s.charAt(i) == '<') check = true;
                else check = false;
                mainSb.append(s.charAt(i));
            }else if(s.charAt(i) == ' '){
                if(check) mainSb.append(' ');
                else {
                    subSb.reverse();
                    mainSb.append(subSb).append(' ');
                    subSb.setLength(0);
                }
            }
        }
        if(subSb.length() != 0){
            mainSb.append(subSb.reverse());
        }

        System.out.println(mainSb);
    }


}


