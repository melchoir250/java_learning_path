package generics;


public class GenericMethods {
    public static <T> void printArray(T[] array) {
        for (T elememnt : array) {
            System.out.println(elememnt);
        }
    }
}
