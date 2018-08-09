package HelloTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculate {

    public int calculate(String s) {
        List<String> list=parseFirst(s);

        Stack<String> stack=new Stack<>();

        for (int i = 0; i <list.size() ; i++) {
            if(i==0){
                stack.push(list.get(0));
            }else{
                String topStr=stack.peek();
                if(topStr.equals("*")||topStr.equals("/")){
                    stack.pop();
                    String first=stack.pop();
                    String second=list.get(i);
                    String res="";

                    int firstNum=Integer.parseInt(first);
                    int secondNum=Integer.parseInt(second);
                    if(topStr.equals("*")){
                        int resNum=firstNum*secondNum;
                        res=resNum+"";
                    }else if(topStr.equals("/")){
                        int resNum=firstNum/secondNum;
                        res=resNum+"";
                    }
                    stack.push(res);

                    continue;
                }else{
                    stack.push(list.get(i));
                }
            }
        }

//        System.out.println(stack.toString());

        int sum=0;

        while (stack.size()>1){
            String second=stack.pop();
            String oper=stack.pop();

            int secondNum=Integer.parseInt(second);

            if(oper.equals("+")){
                sum+=secondNum;
            }else if(oper.equals("-")){
                sum-=secondNum;
            }
        }


        return sum+Integer.parseInt(stack.pop());
    }

    private List<String> parseFirst(String s){
        List<String> list=new ArrayList<>();
        String str="";

        s=s.replaceAll(" ","");

        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
            if(c=='+'||c=='-'||c=='*'||c=='/'){
                list.add(str);

                list.add(c+"");
                str="";
            }else{
                str+=c;
            }
        }

        list.add(str);

        return list;
    }



    public static void main(String[] args) {
        Calculate test=new Calculate();

        System.out.println(test.calculate("1-1+1"));

        System.out.println(test.calculate("2*4+2"));

        System.out.println(test.calculate("3+2*2"));

        System.out.println(test.calculate(" 3/2 "));

        System.out.println(test.calculate(" 3+5 / 2 "));
    }
}
