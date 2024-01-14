import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    /*
    * 1. push(정수)
    * 2. pop(), 정수가 없으면 -1
    * 3. size()
    * 4. empty(), 있으면 0, 비었으면 1
    * 5. front() 큐에 가장 앞에 있는 부분, 없으면 -1
    * 6. back() 큐에 가장 뒤에 있는 부분, 없으면 -1
    * */

    static LinkedList<Integer> q = new LinkedList<>();
    static int front = 0;
    static int back = -1;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        int N = Integer.parseInt(n);

        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            if(sa[0].equals("push")){
                push(Integer.parseInt(sa[1]));
            }else if(sa[0].equals("pop")){
                pop();
            }else if(sa[0].equals("size")){
                size();
            }else if(sa[0].equals("empty")){
                empty();
            }else if(sa[0].equals("front")){
                front();
            }else if(sa[0].equals("back")){
                back();
            }
        }
        System.out.println(sb.toString());

    }

    public static void push(int x){
        q.add(x);
        back++;
    }

    public static void pop(){
        // 없는 경우
        if(back == -1){
            sb.append(-1 + "\n");
        }else{
            Integer remove = q.remove(front);
            back--;
            sb.append(remove + "\n");
        }
    }

    public static void size(){
        if(back == -1){
            sb.append(0 + "\n");
        }else{
            sb.append(back + 1 + "\n");
        }
    }

    public static void empty(){
        if(back == -1){
            sb.append(1 + "\n");
        }else{
            sb.append(0 + "\n");
        }
    }

    public static void front(){
        if(back == -1){
            sb.append(-1 + "\n");
        }else{
            sb.append(q.get(front) + "\n");
        }
    }

    public static void back(){
        if(back == -1){
            sb.append(-1 + "\n");
        }else{
            sb.append(q.get(back) + "\n");
        }
    }

}