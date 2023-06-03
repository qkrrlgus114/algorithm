class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                sb.append(s.charAt(i));
            }
            else if(s.charAt(i) == 'z'){
                sb.append('0');
                if(i+3<s.length()) i+=3;
                else break;
            }
            else if(s.charAt(i) == 'o'){
                sb.append('1');
                if(i+2<s.length()) i+=2;
                else break;
            }
            else if(s.charAt(i) == 't'){
                if(s.charAt(i+1) == 'w'){
                    sb.append('2');
                    if(i+2<s.length()) i+=2;
                    else break;
                }else{
                    sb.append('3');
                    if(i+4<s.length()) i+=4;
                    else break;
                }
            }
            else if(s.charAt(i) == 'f'){
                if(s.charAt(i+1) == 'o'){
                    sb.append('4');
                    if(i+3<s.length()) i+=3;
                    else break;
                }else{
                    sb.append('5');
                    if(i+3<s.length()) i+=3;
                    else break;
                }
            }
            else if(s.charAt(i) == 's'){
                if(s.charAt(i+1) == 'i'){
                    sb.append('6');
                    if(i+2<s.length()) i+=2;
                    else break;
                }else{
                    sb.append('7');
                    if(i+4<s.length()) i+=4;
                    else break;
                }
            }
            else if(s.charAt(i) == 'e'){
                sb.append('8');
                if(i+4<s.length()) i+=4;
                else break;
            }
            else if(s.charAt(i) == 'n'){
                sb.append('9');
                if(i+3<s.length()) i+=3;
                else break;
            }
        }
        int result = Integer.parseInt(sb.toString());
        return result;
    }
}