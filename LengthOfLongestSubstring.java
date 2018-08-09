package HelloTest;

import java.util.ArrayList;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }

        if(s.length()==1){
            return 1;
        }


        HashSet<Character> set=new HashSet<>();

        int maxLength=0;

        int currentLength=0;


        for(int j=0;j<s.length();j++) {
            if(s.length()-j<=maxLength){
                break;
            }

            set.clear();
            set.add(s.charAt(j));
            currentLength=1;



            for (int i = j+1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (set.contains(c)) {

                    currentLength = 1;
                    if (currentLength >= maxLength) {
                        maxLength = currentLength;
                    }

                    set.clear();

                    set.add(c);
                } else {
                    set.add(c);
                    currentLength++;
                    if (currentLength >= maxLength) {
                        maxLength = currentLength;
                    }
                }
            }

        }
        return maxLength;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring test=new LengthOfLongestSubstring();
        System.out.println(test.lengthOfLongestSubstring("pwwkew"));
    }
}
