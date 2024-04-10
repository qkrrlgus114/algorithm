import java.util.*;


// 1. 대소문자 구분 안 함
// 2. HEAD 정렬
// 3. NUMBER 정렬
// 4. HEAD, NUMBER 전부 같은 경우는 유지
class Solution {
    static StringBuilder sb = new StringBuilder();
    static List<Word> list = new ArrayList<>();
    
    public String[] solution(String[] files) {
        
        for(String file : files){
            String head = "";
            String number = "";
            String tail = "";
            int index = 0;
            // 헤드 뽑아내기
            for(int i=0; i<file.length(); i++){
                if(file.charAt(i) >= '0' && file.charAt(i) <= '9') {
                    index = i;
                    break;
                }
                sb.append(file.charAt(i));
            }
            head = sb.toString();
            sb.setLength(0);
            // 넘버 뽑아내기
            int count = 0;
            for(int i=index; i<file.length(); i++){
                if(file.charAt(i) < '0' || file.charAt(i) > '9' || count == 5) {
                    index = i;
                    break;
                }
                count++;
                sb.append(file.charAt(i));
            }
            number = sb.toString();
            sb.setLength(0);
            // System.out.println(head + " " + number + " " + tail);
            list.add(new Word(file, head, number));
        }
        
        Collections.sort(list, new Comparator<Word>(){
            public int compare(Word o1, Word o2){
                String head1 = o1.head.toLowerCase();
                String head2 = o2.head.toLowerCase();
                int temp = head1.compareTo(head2);
                if(temp != 0) return temp;
                
                int n1 = Integer.parseInt(o1.number);
                int n2 = Integer.parseInt(o2.number);
                return Integer.compare(n1, n2);
            }
        });

        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            Word word = list.get(i);
            answer[i] = word.ori;
        }
        
        return answer;
    }
}

class Word{
    String ori;
    String head;
    String number;
    
    public Word(String ori, String head, String number){
        this.ori = ori;
        this.head = head;
        this.number = number;
    }
}