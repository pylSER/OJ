package HelloTest;

import java.util.*;

public class AccountsMerge {
    int[] arr=new int[10000];

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        return null;
    }


    private void initUnionSet(){
        for (int i = 0; i <10000 ; i++) {
            arr[i]=i;
        }
    }

    private void doUnion(int x,int y){
        int xBoss=findBoss(x);
        int yBoss=findBoss(y);

        if(xBoss!=yBoss){
            arr[y]=xBoss;
        }
    }

    private int findBoss(int x){
        if(x!=arr[x]){
            return findBoss(arr[x]);
        }else{
            return x;
        }
    }


    public static void main(String[] args) {
        List<String> list1=new ArrayList<>();
        List<String> list2=new ArrayList<>();
        List<String> list3=new ArrayList<>();
        List<String> list4=new ArrayList<>();


        list1.add("John");
        list1.add("johnsmith@mail.com");
        list1.add("john00@mail.com");

        list2.add("John");
        list2.add("johnnybravo@mail.com");

        list3.add("John");
        list3.add("johnsmith@mail.com");
        list3.add("john_newyork@mail.com");

        list4.add("Mary");
        list4.add("mary@mail.com");


        List<List<String>> teststr=new ArrayList<>();
        teststr.add(list1);
        teststr.add(list2);
        teststr.add(list3);
        teststr.add(list4);

        AccountsMerge test=new AccountsMerge();
        System.out.println(test.accountsMerge(teststr));
    }

}
