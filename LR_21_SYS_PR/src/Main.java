import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        String filePath = "1.txt";
        int maxCount = findMaxConsecutiveValidChars(filePath);
        System.out.println("Максимальное количество идущих подряд символов: " + maxCount);
    }
    public static int findMaxConsecutiveValidChars(String filePath) {
        int maxCount = 0, currentCount = 0;
        char[] validChars = {'Q', 'R', 'W', '1', '2', '4'};
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                currentCount = 1;
                for (int i = 1; i < line.length(); i++) {
                    char currentChar = line.charAt(i);
                    char previousChar = line.charAt(i - 1);
                    if ((Character.isLetter(currentChar) && Character.isLetter(previousChar)) ||
                            (Character.isDigit(currentChar) && Character.isDigit(previousChar))) {
                        maxCount = Math.max(maxCount, currentCount);
                        currentCount = 1;
                    } else {
                        currentCount++;
                    }
                }
                maxCount = Math.max(maxCount, currentCount);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        return maxCount;
    }
}