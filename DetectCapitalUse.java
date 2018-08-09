package HelloTest;

public class DetectCapitalUse {
    private int lowerStart=65;
    private int lowerEnd=90;
    private int higherStart=97;
    private int higherEnd=122;


    public boolean detectCapitalUse(String word) {
        if(word.length()==0){
            return true;
        }




        if(preCheck(word)){
            char firstChar=word.charAt(0);
            if(isCapital(firstChar)){

                //all cap
                if(isAllCap(word)){
                    return true;
                }

                //first cap
                for (int i = 1; i <word.length() ; i++) {
                    char c=word.charAt(i);
                    if(isCapital(c)){
                       return false;
                    }
                }

                return true;
            }else{
                //all small
                for (int i = 1; i <word.length() ; i++) {
                    char c=word.charAt(i);
                    if(isCapital(c)){
                        return false;
                    }
                }
                return true;
            }
        }else{
            return false;
        }
    }

    private boolean isAllCap(String word){
        for (int i = 0; i <word.length() ; i++) {
            char c=word.charAt(i);
            if(!(c>=lowerStart&&c<=lowerEnd)){
                return false;
            }
        }

        return true;
    }

    private boolean preCheck(String word){
        for (int i = 0; i <word.length() ; i++) {
            char c=word.charAt(i);
            if(!((c>=lowerStart&&c<=lowerEnd)||(c>=higherStart&&c<=higherEnd))){
                return false;
            }
        }

        return true;
    }

    private boolean isCapital(char c){
        if(c>=lowerStart&&c<=lowerEnd){
            return true;
        }else{
            return false;
        }
    }


    public static void main(String[] args){
        DetectCapitalUse test=new DetectCapitalUse();

        System.out.println(test.detectCapitalUse("uSa"));
    }
}
