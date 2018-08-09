package HelloTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAnagrams {
    HashSet<String> set=new HashSet<>();

    public List<Integer> findAnagrams(String s, String p) {
        int pLength=p.length();

        List<Integer> list=new ArrayList<>();

        for (int i = 0; i <s.length() ; i++) {
            if(i+pLength>s.length()){
                break;
            }

            String temp=s.substring(i,i+pLength);

            if(set.contains(temp)){
                list.add(i);
                continue;
            }

//            System.out.println(temp);

            if(isAnagram(p,temp)){
                list.add(i);
            }
        }

        return list;
    }

    private boolean isAnagram(String s, String t) {
        int[] a=new int[26];
        int[] b=new int[26];

        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
            a[c-'a']++;
        }

        for (int i = 0; i <t.length() ; i++) {
            char c=t.charAt(i);
            b[c-'a']++;
        }

        for (int i = 0; i <26 ; i++) {
            if(a[i]!=b[i]){
                return false;
            }
        }


        set.add(t);

        return true;


    }

    public static void main(String[] args) {
        FindAnagrams test=new FindAnagrams();
        System.out.println(test.findAnagrams("abab","ab"));
    }
}