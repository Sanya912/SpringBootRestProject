package testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TraditionalSearch {
    public static void main(String[] args) {
//        String ari = "ar";
//        String art = "art";

        List<String> bunnies = /*Arrays.asList("long ear","floppy","happy");*/
                new ArrayList<>();
        bunnies.add("long ear");
        bunnies.add("floppy");
        bunnies.add("hoppy");

        bunnies.removeIf(s -> !s.startsWith("h"));
//        (String ari, String art)->{ ari.equals(art);};
        //____________________________________________
//        List<Animal> animals = new ArrayList<Animal>();  // list of animals
//        animals.add(new Animal("fish", false, true));
//        animals.add(new Animal("kangaroo", true, false));
//        animals.add(new Animal("rabbit", true, false));
//        animals.add(new Animal("turtle", false, true));
//        print(animals, new CheckIfHopper()); //------------------
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Animal("fish", false, true));
        print(animals, a -> a.canHop());

    }
    private static void print(List<Animal> animals, Predicate<Animal> checker) {
//    private static void print(List<Animal> animals, CheckTrait checker) {
        for (Animal animal : animals) {
            if (checker.test(animal))
                System.out.print(animal + " ");
        }
    }
}
