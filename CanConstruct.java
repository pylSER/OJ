package HelloTest;

public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr=new int[26];


        for (int i = 0; i <magazine.length() ; i++) {
            char c=magazine.charAt(i);

            int index=c-'a';

            arr[index]++;
        }

        for (int i = 0; i <ransomNote.length() ; i++) {
            char c=ransomNote.charAt(i);

            int index=c-'a';

            arr[index]--;

            if(arr[index]<0){
                return false;
            }


        }

        return true;
    }

    public static void main(String[] args) {
        CanConstruct test=new CanConstruct();
        System.out.println(test.canConstruct("aa","ab"));
    }
}
