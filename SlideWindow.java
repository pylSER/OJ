package HelloTest;

import java.util.HashMap;

public class SlideWindow {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Integer,Character> map=new HashMap<>();

        int startIndex=0;
        int endIndex=0;
        int maxLength=0;

        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
            if(map.containsValue(c)){
                if((endIndex-startIndex+1)>maxLength){
                    maxLength=endIndex-startIndex+1;
                }


                int deleteIndex=startIndex;
                //

                for (;;){
                    char removeChar=map.remove(deleteIndex);
                    deleteIndex++;
                    if(removeChar==c){
                        break;
                    }
                }
                //

                startIndex=deleteIndex;

                map.put(i,c);

                endIndex=i;

            }else{
                map.put(i,c);
                endIndex=i;
                if((endIndex-startIndex+1)>maxLength){
                    maxLength=endIndex-startIndex+1;
                }
            }
        }

        return maxLength;

    }


    public static void main(String[] args) {
        SlideWindow test=new SlideWindow();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(test.lengthOfLongestSubstring("bbbbb"));
        System.out.println(test.lengthOfLongestSubstring(""));
        //310
    }
}
