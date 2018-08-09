package HelloTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    class CharAndNum implements Comparable{
        public char letter;
        public int num;

        public CharAndNum(char letter,int num){
            this.letter=letter;
            this.num=num;
        }

        @Override
        public int compareTo(Object o) {
            CharAndNum current=(CharAndNum) o;
            if(current.num>this.num){
                return 1;
            }else if(current.num==this.num){
                return 0;
            }

            return -1;
        }
    }




    public String reorganizeString(String S) {
        PriorityQueue<CharAndNum> queue=new PriorityQueue<>();
        HashMap<Character,Integer> map=new HashMap<>();


        for (int i = 0; i <S.length() ; i++) {
            char c=S.charAt(i);
            if(map.containsKey(c)){
                int num=map.get(c);
                map.put(c,num+1);
            }else{
                map.put(c,1);
            }
        }

        for (Map.Entry<Character,Integer> entry:map.entrySet()) {
            CharAndNum charAndNum=new CharAndNum(entry.getKey(),entry.getValue());
            queue.offer(charAndNum);
        }

        String res="";

        char previous=queue.peek().letter;

        for (int i = 0; i <S.length() ; i++) {
            CharAndNum c1=queue.poll();


            if(i!=0){
                if(previous==c1.letter){
                    //find a lower one
                    CharAndNum c2=queue.poll();

                    if(c2==null){
                        return "";
                    }

                    queue.offer(c1);

                    c1=c2;
                    previous=c1.letter;
                }else {
                    previous=c1.letter;
                }
            }

            res+=c1.letter;

            c1.num--;
            if(c1.num>0){
                queue.offer(c1);
            }

        }

        return res;
    }


    public static void main(String[] args) {
        ReorganizeString test=new ReorganizeString();
        System.out.println(test.reorganizeString("vvvlo"));
    }
}
