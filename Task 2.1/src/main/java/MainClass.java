import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MainClass {
    public static void main(String[] args) {
        try {
            File file = new File(System.getProperty("user.dir") + "\\Txt.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            System.out.println("Производим подсчёт количество слов в файле " + file.getName());
            System.out.println();

            String line = reader.readLine();
            String[] words;
            int idLine = 0;
            int countWords = 0;
            int countChar = 0;
            while (line != null) {
                words = line.split(" ");
                System.out.println(++idLine + "-я строка содержит " + words.length + " слов" +
                        endingFromNumber(words.length, "о", "а", ""));
                countWords += words.length;
                countChar += line.length();
                line = reader.readLine();
            }

            System.out.println();
            String itog = "Файл %s содержит %s строк%s, %s слов%s и %s символ%s.";
            System.out.println(String.format(itog, file.getName(),
                    idLine, endingFromNumber(idLine, "у", "и", ""),
                    countWords, endingFromNumber(countWords, "о", "а", ""),
                    countChar, endingFromNumber(countChar, "", "а", "ов")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static String endingFromNumber(int number, String ending1, String ending2_4, String ending5_0) {
        String ending;
        if (number % 100 > 10 & number % 100 < 20) {
            ending = ending5_0;
        } else {
            switch (number % 10) {
                case 1:
                    ending = ending1;
                    break;
                case 2:
                case 3:
                case 4:
                    ending = ending2_4;
                    break;
                default:
                    ending = ending5_0;
            }
        }
        return ending;
    }
}
