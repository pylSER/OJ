package HelloTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> res=new ArrayList<>();

        int[][] arr=new int[S.length()][26];

        for (int i = S.length()-1; i >=1 ; i--) {
            for (int j = 0; j <26 ; j++) {
                arr[i-1][j]=arr[i][j];
            }

            char c=S.charAt(i);
            arr[i-1][c-'a']++;
        }

        HashSet<Character> set=new HashSet<>();

        int preLength=-1;
        int length=0;

        boolean isOK=true;

        for (int i = 0; i <S.length() ; i++) { // cut from i
            set.add(S.charAt(i));
            for (Character c:set) {
                if(arr[i][c-'a']!=0){
                    isOK=false;
                    break;
                }
            }

            if(!isOK){
                isOK=true;
                continue;
            }

            //ok
            set.clear();
            int realLength=i-preLength;
            res.add(realLength);
            preLength=i;
        }

        return res;
    }

    public static void main(String[] args) {
        PartitionLabels test=new PartitionLabels();
        System.out.println(test.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
