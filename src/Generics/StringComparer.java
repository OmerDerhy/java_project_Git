package Generics;

public class StringComparer implements Comparer<String>{
    @Override
    public boolean isEqual(String o1,String o2){
        return (o1 != null) && o1.equals(o2);
    }
}
