package generics;

import generics.advanced.Container;
import generics.advanced.NumberBox;
import generics.advanced.SimpleContainer;
import generics.advanced.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static generics.advanced.MapPrinter.printMap;
import static generics.advanced.NumberBox.addNubmer;

public class Main {
    public static void main(String[] args) {
        Box<String> boxString = new Box<>();
        boxString.setElement("Element");
        System.out.println(boxString.getElement());

        Box<Integer> boxInteger = new Box<>();
        boxInteger.setElement(12);
        System.out.println(boxInteger.getElement());

        Integer[] num = {1, 2, 3};
        GenericMethods.printArray(num);

        String[] word = {"one", "two", "tree"};
        GenericMethods.printArray(word);

        Pair<String, Integer> pair = new Pair<>();
        pair.setFirst("Elem");
        pair.setSecond(12);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());

        Storage<String> stringStorage = new Storage<>();
        stringStorage.setItem("Plane");
        System.out.println(stringStorage.getItem());

        Storage<Integer> integerStorage = new Storage<>();
        integerStorage.setItem(131);
        System.out.println(integerStorage.getItem());

        String[] elem = {"Antonov", "Petrov", "Ivanov"};
        GenericMethods.printArray(elem);

        Integer[] elems = {1, 3, 5, 7};
        NumberBox<Integer> box = new NumberBox<>(List.of(elems));
        System.out.println(box.getSum());

        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);

        double sum = NumberBox.sum(intList);
        System.out.println("Сумма: " + sum);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        addNubmer(list);

        Container<String> container = new SimpleContainer<>();
        container.add("Hello");
        System.out.println(container.get());

        Map<String, Integer> map = new java.util.HashMap<>();
        map.put("Apple", 3);
        map.put("Banana", 5);

        printMap(map);
    }
}
