package HelloTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    HashSet<String> set;
    String orgString;

    boolean result=false;

    HashMap<String,Boolean> memoizeSubstringMap=new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {

        orgString = s;

        set = new HashSet<>();

        for (String str : wordDict) {
            set.add(str);
        }

        String substr=s;

        dp(substr);





        return result;
    }


    private boolean dp(String substr){
        if(substr.equals("")){
            memoizeSubstringMap.put(substr,true);
            //memoize result
            result=true;
            return true;
        }

        if(memoizeSubstringMap.containsKey(substr)){
            return false;
        }


        for (int i = 0; i <substr.length()+1 ; i++) {
            String pre=substr.substring(0,i);
            if(set.contains(pre)){
                // go to splice next substring
                String suffix=substr.substring(i);
                dp(suffix);
                if(result==true){
                    return true;
                }
            }else{
                continue;
            }
        }

        //memoize result
        memoizeSubstringMap.put(substr,false);
        return false;
    }


    public static void main(String[] args) {
        WordBreak test=new WordBreak();

        ArrayList<String> testlist=new ArrayList<>();

        testlist.add("a");

        testlist.add("aa");

        testlist.add("aaa");

        testlist.add("aaaa");

        testlist.add("aaaaa");

        testlist.add("aaaaaa");

        testlist.add("aaaaaaa");

        testlist.add("aaaaaaaa");

        testlist.add("aaaaaaaaa");

        testlist.add("aaaaaaaaaa");

        System.out.println(test.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",testlist));
    }
}
