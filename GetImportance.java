package HelloTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetImportance {
    private Map<Integer, Employee> emap;
    int sum=0;

    public int getImportance(List<Employee> employees, int id) {
        emap = new HashMap();
        for (Employee e: employees) emap.put(e.id, e);

        getSum(id);

        return sum;
    }

    private void getSum(int id){
        Employee employee=emap.get(id);
        List<Integer> subList=employee.subordinates;
        if(subList.size()==0){
            sum+=employee.importance;
        }else{
            sum+=employee.importance;
            for (int eid:subList
                 ) {

                getSum(eid);
            }
        }
    }

    public static void main(String[] args){
        GetImportance test=new GetImportance();

        Employee e1=new Employee();
        Employee e2=new Employee();
        Employee e3=new Employee();
        Employee e4=new Employee();

        //[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
        e1.id=1;
        e2.id=2;
        e3.id=3;
        e4.id=4;

        e1.importance=5;
        e2.importance=3;
        e3.importance=4;
        e4.importance=1;

        e1.subordinates=new ArrayList<>();
        e2.subordinates=new ArrayList<>();
        e3.subordinates=new ArrayList<>();
        e4.subordinates=new ArrayList<>();

        e1.subordinates.add(2);
        e1.subordinates.add(3);

        e2.subordinates.add(4);


        List<Employee> list=new ArrayList<>();

        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);

        System.out.println(test.getImportance(list,1));

    }
}
