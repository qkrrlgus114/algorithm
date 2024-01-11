import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Main {

    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 명령의 개수
        String n = bf.readLine();
        int N = Integer.parseInt(n);

        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            int index = Integer.parseInt(sa[0]);

            if(index == 1){
                int value = Integer.parseInt(sa[1]);
                s.push(value);
            }else if(index == 2){
                if(!s.isEmpty()){
                    sb.append(s.pop() + "\n");
                }else{
                    sb.append(-1 + "\n");
                }
            }else if(index == 3){
                sb.append(s.size() + "\n");
            }else if(index == 4){
                if(s.isEmpty()){
                    sb.append(1 + "\n");
                }else{
                    sb.append(0 + "\n");
                }
            }else{
                if(!s.isEmpty()){
                    sb.append(s.peek() + "\n");
                }else{
                    sb.append(-1 + "\n");
                }
            }
        }

        System.out.println(sb.toString());


    }

//    // 추가
//    public static void push(int value){
//        s.add(value);
//        top++;
//    }
//
//    // 비었는지 체크
//    public static int isEmpty(){
//        if(top == -1){
//            return 1;
//        }else{
//            return 0;
//        }
//    }
//
//    // 스택 pop 구현
//    public static void pop(){
//        if(isEmpty() == 0){
//            System.out.println(s.get(top));
//            s.remove(top--);
//        }else{
//            System.out.println(-1);
//        }
//    }
//
//    // 스택 사이즈 출력
//    public static void size(){
//        System.out.println(top + 1);
//    }
//
//    // 스택 peek 구현
//    public static void peek(){
//        if(isEmpty() == 0){
//            System.out.println(s.get(top));
//        }else{
//            System.out.println(-1);
//        }
//    }


}