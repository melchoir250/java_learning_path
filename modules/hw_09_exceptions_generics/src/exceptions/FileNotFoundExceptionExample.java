package exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileNotFoundExceptionExample {
    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("data.txt")) {
            System.out.println("Файл открыт");

            int firstChar = fileReader.read();
            if (firstChar == -1) {
                System.out.println("Файл пустой");
            } else {
                System.out.println("Первый символ: " + (char) firstChar);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
