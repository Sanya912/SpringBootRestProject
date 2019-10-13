package testing;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Max;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws IOException {
/*        List<String> list = Arrays.asList("e", "t", "r", "te", "Lop");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.next();
            if(list.contains("r")){
                System.out.println("rrrrrrr");
                break;
            }
            System.out.println(iterator.toString());
        }*/
//        lists.stream().distinct().forEach(System.out::println);

//        Runtime.getRuntime().exec("notepad");

        List<Integer> lists = Arrays.asList(1,2,32,1,8,8);
        lists.forEach(System.out::println);
    }



}
