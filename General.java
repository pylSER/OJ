package HelloTest;

import java.util.ArrayList;

public class General<T> {
    private T item;


    public String getName(){
        return item.getClass().getName();
    }


    public void add(){
        ArrayList<Integer> list=(ArrayList<Integer>)item;
        list.add(1);
    }
}
