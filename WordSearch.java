package HelloTest;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char startChar=word.charAt(0);
        boolean isOK=false;

        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[i].length ; j++) {
                if(startChar==board[i][j]){
                    //start explore
                    char[][] mark=new char[board.length][board[0].length];

                    isOK=explore(board,word,i,j,mark);
                    if(isOK){
                        return isOK;
                    }
                }
            }
        }

        return isOK;
    }

    private boolean explore(char[][] board,String word,int startI,int startJ,char[][] mark){
        if(word.length()==1){
            return true;
        }

        if(mark[startI][startJ]==1){
            return false;
        }

        if(startI<0||startI>=board.length){
            return false;
        }

        if(startJ<0||startJ>=board[0].length){
            return false;
        }

        char nextChar=word.charAt(1);

        //this point is explored

        mark[startI][startJ]=1;

        String newWord=word.substring(1);

        boolean upOK=false;
        boolean downOK=false;
        boolean leftOK=false;
        boolean rightOK=false;

        if(startI>0&&board[startI-1][startJ]==nextChar){//up
            upOK=explore(board,newWord,startI-1,startJ,mark);
        }else if(startI<board.length-2&&board[startI+1][startJ]==nextChar){//down
            downOK=explore(board,newWord,startI+1,startJ,mark);
        }else if (startJ>0&&board[startI][startJ-1]==nextChar){ //left
            leftOK=explore(board,newWord,startI,startJ-1,mark);
        }else {//right
            if(startJ<board[0].length-2){
                rightOK=explore(board,newWord,startI,startJ+1,mark);
            }
        }

        return upOK||downOK||leftOK||rightOK;
    }


    public static void main(String[] args) {
        WordSearch test=new WordSearch();
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'B','D','E','E'}};

        System.out.println(test.exist(board,"ABCCED"));
    }
}
