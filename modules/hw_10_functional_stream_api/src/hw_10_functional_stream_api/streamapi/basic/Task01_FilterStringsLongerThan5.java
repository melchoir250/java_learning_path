package hw_10_functional_stream_api.streamapi.basic;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task01_FilterStringsLongerThan5 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "Car",
                "Bus",
                "Truck",
                "Train",
                "Tram",
                "Trolleybus",
                "Bicycle",
                "Motorcycle",
                "Scooter",
                "Plane",
                "Helicopter",
                "Hot air balloon",
                "Glider",
                "Ship",
                "Boat",
                "Yacht",
                "Submarine",
                "Ferry"
        );

        List<String> filters = words.stream()
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList());

        System.out.println("Исходный список: " + words);
        System.out.println("Отфильтрованный список: " + filters);
    }
}
