package HelloTest;

import java.util.Stack;

public class BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        String res1=getRealString(S);

        String res2=getRealString(T);

        if(res1.equals(res2)){
            return true;
        }else {
            return false;
        }
    }


    private String getRealString(String str){
        Stack<Character> stack1=new Stack<>();

        for (int i = 0; i <str.length() ; i++) {
            char c=str.charAt(i);

            if(c=='#'){
                if(!stack1.isEmpty()){
                    stack1.pop();
                }
            }else{
                stack1.push(c);
            }
        }

        String res="";
        while (!stack1.isEmpty()){
            res+=stack1.pop();
        }

        return res;
    }



    public static void main(String[] args) {
        BackspaceCompare test=new BackspaceCompare();
        System.out.println(test.backspaceCompare("a##c","#a#c"));
    }
}
