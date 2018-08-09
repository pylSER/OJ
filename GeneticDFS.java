package HelloTest;

import java.util.HashMap;

public class GeneticDFS {

    HashMap<Integer,String> map=new HashMap<>();

    int[] markArr;

    int minLength;

    String endStr;

    String[] bankPublic;

    public int minMutation(String start, String end, String[] bank) {


        markArr=new int[bank.length];
        minLength=bank.length+100;
        endStr=end;
        bankPublic=bank;

        for (int i = 0; i <bank.length ; i++) {
            map.put(i,bank[i]);
            markArr[i]=0;
        }

        // end shall in the bank
        if(!map.containsValue(end)){
            return -1;
        }


        dfs(start,0);

        if(minLength==bank.length+100){
            minLength=-1;
        }

        return minLength;
    }

    private void dfs(String start,int step){
        if(start.equals(endStr)){
            if(step<minLength){
                minLength=step;
            }
            return ;
        }

        for (int i = 0; i <bankPublic.length ; i++) {
            if(markArr[i]==0 && isNextStep(start,bankPublic[i])){
                markArr[i]=1;
                dfs(bankPublic[i],step+1);
                markArr[i]=0;
            }
        }
    }

    private boolean isNextStep(String start,String next){
        int diffNum=0;

        if(start.length()!=next.length()){
            return false;
        }


        for (int i = 0; i <start.length() ; i++) {
            char s=start.charAt(i);
            char n=next.charAt(i);
            if(n!=s){
                diffNum++;
            }
        }

        if(diffNum==1){
            return true;
        }else{
            return false;
        }
    }





    public static void main(String[] args) {
        String[] arr={"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        GeneticDFS test=new GeneticDFS();
        System.out.println(test.minMutation("AACCGGTT","AAACGGTA",arr));
    }
}
