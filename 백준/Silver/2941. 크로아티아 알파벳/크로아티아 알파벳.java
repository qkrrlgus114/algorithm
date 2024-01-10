import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = bf.readLine().toCharArray();
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'c') {
                if (i + 1 < arr.length && (arr[i + 1] == '=' || arr[i + 1] == '-')) {
                    i += 1;
                }
            } else if (arr[i] == 'd') {
                if (i + 1 < arr.length && arr[i + 1] == '-') {
                    i += 1;
                } else if (i + 1 < arr.length && arr[i + 1] == 'z') {
                    if (i + 2 < arr.length && arr[i + 2] == '=') {
                        i += 2;
                    }
                }
            } else if (arr[i] == 'l') {
                if (i + 1 < arr.length && arr[i + 1] == 'j') {
                    i += 1;
                }
            } else if (arr[i] == 'n') {
                if (i + 1 < arr.length && arr[i + 1] == 'j') {
                    i += 1;
                }
            } else if (arr[i] == 's') {
                if (i + 1 < arr.length && arr[i + 1] == '=') {
                    i += 1;
                }
            } else if (arr[i] == 'z') {
                if (i + 1 < arr.length && arr[i + 1] == '=') {
                    i += 1;
                }
            }
            count++;
        }
        System.out.println(count);
    }
}