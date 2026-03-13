import java.util.*;

class Solution {

    static String[] words;
    static List<Word> wordList = new ArrayList<>();
    // 범위에 없는 단어들
    static Set<String> publicWord = new HashSet<>();
    // 이미 중요 단어로 체크된 단어들
    static Set<String> countedWord = new HashSet<>();

    public int solution(String message, int[][] spoiler_ranges) {
        words = message.split(" ");
        
        StringBuilder sb = new StringBuilder();
        int startIdx = 0;
        for(int i=0; i<message.length(); i++){
            if(message.charAt(i) != ' '){
                sb.append(message.charAt(i));
            }else{
                Word word = new Word(sb.toString(), startIdx, i - 1);
                wordList.add(word);
                sb.setLength(0);
                startIdx = i + 1;
            }
        }
        wordList.add(new Word(sb.toString(), startIdx, message.length() - 1));
        
        // 마스킹 구간 계산
        for(int i=0; i<spoiler_ranges.length; i++){
            int start = spoiler_ranges[i][0];
            int end = spoiler_ranges[i][1];
            for (Word word : wordList) {
                int overlap = Math.max(0, Math.min(word.end, end) - Math.max(word.start, start) + 1);
                if (overlap > 0) {
                    word.maskedCnt += overlap;
                }
            }
        }
        
        for(Word word : wordList){
            if(word.maskedCnt == 0){
                publicWord.add(word.name);
            }
        }
        
        int answer = 0;

        // 클릭 순서대로 공개 진행
        for(int i=0; i<spoiler_ranges.length; i++){
            int start = spoiler_ranges[i][0];
            int end = spoiler_ranges[i][1];

            for (Word word : wordList) {
                int overlap = Math.max(0, Math.min(word.end, end) - Math.max(word.start, start) + 1);
                if (overlap == 0) continue;

                int before = word.publicCnt;
                word.publicCnt += overlap;

                if (before < word.maskedCnt && word.publicCnt == word.maskedCnt) {
                    if (!publicWord.contains(word.name) && !countedWord.contains(word.name)) {
                        answer++;
                        countedWord.add(word.name);
                    }
                }
            }
        }
        
        return answer;
        
    }

}

class Word{
    String name;
    int start;
    int end;
    int maskedCnt; // 마스킹 문자수
    int publicCnt; // 공개 문자수
    
    public Word(String name, int start, int end){
        this.name = name;
        this.start = start;
        this.end = end;
    }
}