package HelloTest;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        int[] a=new int[26];
        int[] b=new int[26];

        if(s.length()!=t.length()){
            return false;
        }

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


        return true;


    }

    public static void main(String[] args) {
        IsAnagram test=new IsAnagram();
        System.out.println(test.isAnagram("cat","rat"));
    }

}
