package HelloTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Strstr {
    public int strStr(String haystack, String needle) {

       if(needle.length()==0){
           return 0;
       }

       if(needle.length()>haystack.length()){
           return -1;
       }

       if(needle.length()==haystack.length()){
           if(needle.equals(haystack)){
               return 0;
           }else{
               return -1;
           }
       }

       if(haystack.length()==0){
           return -1;
       }



       char needleFirst=needle.charAt(0);

        ArrayList<Integer> positionList=new ArrayList<>();

        int needleLength=needle.length();


        for (int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i)==needleFirst){
                if(isLengthOK(haystack.length(),needleLength,i)){
                    positionList.add(i);
                }
            }
        }

        for (int index:positionList) {
            String substr=haystack.substring(index,index+needleLength);
            if(substr.equals(needle)){
                return index;
            }
        }

        return -1;
    }


    private boolean isLengthOK(int haylength,int needlelength,int index){
        if(index+needlelength<=haylength){
            return true;
        }else{
            return false;
        }
    }



    public static void main(String[] args){
        System.out.println(new Strstr().strStr("mississippi","pi"));
    }

}
