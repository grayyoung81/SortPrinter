import java.util.ArrayList;

interface Sort{
    public void sort(ArrayList<Integer> lst);
}

class BubbleSort implements Sort{
    @Override
    public void sort(ArrayList<Integer> lst) {
        for(int cycle = 0 ;cycle < lst.size(); cycle ++) {
            for(int i = 0 ; i < lst.size() - 1 - cycle; i ++) {
                if(lst.get(i) > lst.get(i + 1)){
                    //swap
                    int tmp = lst.get(i);
                    lst.set(i, lst.get(i + 1));
                    lst.set(i + 1, tmp);
                }
            }
        }
    }
}

class SelectionSort implements Sort{
    @Override
    public void sort(ArrayList<Integer> lst) {
        for(int i = 0 ; i < lst.size(); i++) {
            for(int j = i + 1 ; j < lst.size(); j ++) {
                if(lst.get(i) > lst.get(j)){
                    int tmp = lst.get(i);
                    lst.set(i, lst.get(j));
                    lst.set(j, tmp);
                }
            }
        }
    }
}

class SortPrinter{
    ArrayList<Integer> machine = new ArrayList<Integer>();
    Sort choice ;
    public void insert(int i){
        machine.add(i);
    }

    public void selection(Sort s){
        this.choice = s;
    }

    public void run(){
        choice.sort(machine);
    }

    public void show(){
        System.out.println(machine);
    }

}

public class Main {
    public static void main(String[] args) {
        SortPrinter sortPrinter = new SortPrinter();
        sortPrinter.insert(3);
        sortPrinter.insert(3);
        sortPrinter.insert(3);
        sortPrinter.insert(1);
        sortPrinter.insert(2);
        sortPrinter.insert(2);
        sortPrinter.insert(1);
        sortPrinter.insert(3);
        sortPrinter.selection(new BubbleSort());
        sortPrinter.run();
        sortPrinter.show();

        sortPrinter.insert(7);
        sortPrinter.insert(6);
        sortPrinter.insert(2);
        sortPrinter.insert(1);
        sortPrinter.insert(23);
        sortPrinter.selection(new SelectionSort());
        sortPrinter.run();
        sortPrinter.show();
    }
}
