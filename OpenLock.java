package HelloTest;

public class OpenLock {
    public final String initialState="0000";

    public int step=0;

    public int openLock(String[] deadends, String target) {
        if(target.equals(initialState)){
            return step;
        }


        // USE BFS instead










        return 1;
    }


    private boolean isInDeadEnd(String[] deadends, String target){
        for (String dead: deadends) {
            if(target.equals(dead)){
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args){
        OpenLock openLock=new OpenLock();

        String[] deadends={"0201","0101","0102","1212","2002"};

        System.out.println(openLock.openLock(deadends,"0202"));
    }



}
