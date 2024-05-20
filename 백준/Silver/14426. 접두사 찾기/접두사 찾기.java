import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        String[] arrN = new String[N];
        for(int i=0; i<arrN.length; i++){
            String s = bf.readLine();
            arrN[i] = s;
        }

        String[] arrM = new String[M];
        for(int i=0; i<arrM.length; i++){
            String s = bf.readLine();
            arrM[i] = s;
        }

        Arrays.sort(arrN);

        // 정답 개수
        int answer = 0;

        for(int i=0; i<M; i++){
            String word = arrM[i];

            int l = 0;
            int r = arrN.length - 1;

            while(l <= r){
                int mid = (l + r) / 2;
                String wordN = arrN[mid];
                int length = word.length();
                // 두 단어가 전부 일치하는지 확인
                boolean check = true;
                // 단어가 틀린 인덱스
                int index = 0;

                for(int j=0; j<length; j++){
                    if(wordN.charAt(j) != word.charAt(j)){
                        check = false;
                        index = j;
                        break;
                    }
                }

                // check가 true면 포함됐으니
                if(check){
                    answer++;
                    break;
                }else{
                    if(wordN.charAt(index) > word.charAt(index)){
                        r = mid - 1;
                    }else if(wordN.charAt(index) < word.charAt(index)){
                        l = mid + 1;
                    }
                }
            }
        }

        System.out.println(answer);
    }

}

