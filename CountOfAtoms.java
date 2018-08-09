package HelloTest;

import java.util.HashMap;
import java.util.Stack;

public class CountOfAtoms { //HARD
    public String countOfAtoms(String formula) {
        HashMap<String,Integer> map=new HashMap<>();

        Stack<String> stack=new Stack<>();


        for (int i = 0; i <formula.length() ; i++) {
            char c=formula.charAt(i);
            if(c>='a'&&c<='z'){
                continue;
            }


            String atom=c+"";

            if(c>='1'&&c<='9'){
                int nextStart=i+1;
                for (int j = i+1; j <formula.length() ; j++) {
                    char nextNum=formula.charAt(j);
                    if(nextNum>='1'&&nextNum<='9'){
                        atom+=nextNum;
                    }else {
                        nextStart=j-1;
                        break;
                    }
                }
                i=nextStart;
                stack.push(atom);
                if(i>=formula.length()){
                    break;
                }
                continue;
            }


            //next char
            if(i!=formula.length()-1) {
                char nextChar=formula.charAt(i+1);
                if(nextChar>='a'&&nextChar<='z'){
                    atom+=nextChar;
                }
            }

            //now we got the atom
            stack.push(atom);
        }

        System.out.println(stack.toString());


        int elementNum=0;
        String eleBuffer="";

        while(!stack.isEmpty()){
            String topStr=stack.pop();
            if(topStr.length()>=2){
                //definitly an chem element
                eleBuffer+=topStr;
            }else if(topStr.equals("(")){

            }else if(topStr.equals(")")){

            }else if(topStr.equals("c")){ // number

            }else{ // single Letter

            }

        }


        return "";
    }

    public static void main(String[] args) {
        CountOfAtoms test=new CountOfAtoms();
        System.out.println(test.countOfAtoms("Mg244(OH)21222"));
    }

}
