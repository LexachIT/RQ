import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        String filePath = "fl.txt";
        int maxCount = findMaxConsecutivePairs(filePath);
        System.out.println("Максимальное количество идущих подряд пар AB или CB: " + maxCount);
    }
    public static int findMaxConsecutivePairs(String filePath) {
        int maxCount = 0, currentCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < line.length() - 1; i++) {
                    String pair = line.substring(i, i + 2);
                    if ("AB".equals(pair) || "CB".equals(pair)) {
                        currentCount++;
                        i++; // Пропускаем следующий символ
                    } else {
                        maxCount = Math.max(maxCount, currentCount);
                        currentCount = 0;
                    }
                }
                maxCount = Math.max(maxCount, currentCount); // Проверка на конец строки
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        return maxCount;
    }
}
