package lab_9;
import java.util.regex.*;
import java.util.*;
import java.io.*;


/*
16. В программу подается текст из файла, в котором находится некий текст, либо набор текстов.
Необходимо определить “настроение” текста. Это значит, что если в тексте будет употреблено много
негативных слов, то текст будет иметь отрицательное значение “настроения”. Должно быть вычислено
точно число “настроения”, для возможности сравнения различных текстов.
*/


import java.util.*;

public class Lab9 {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        boolean flag = true;
        int counter = 0;


        // Добавление в список "негативных" слов
        words.add("ткачиха");
        words.add("повариха");
        words.add("полотна");


        // Чтение файла
        try{
            String path = "D://Projects//Java//regexp_lab//lab_9//data.txt";
            File file = new File(path);

            if(!file.exists()) file.createNewFile();

            BufferedReader br = new BufferedReader(new FileReader(path));
            String line, word;

            while((line = br.readLine()) != null) {
                for (int i = 0; i < words.size(); i++) {
                    word = words.get(i).toLowerCase();
                    if(line.toLowerCase().contains(word)) counter += 1;
                }
            }

            br.close();

            // Определение настроения текста
            if (counter > 10) flag = false;

            if (flag) {
                System.out.println("Положительное значение настроения текста:\nкол-во совпадений = " + counter);
            } else {
                System.out.println("Отрицательное значение настроения текста:\n кол-во совпадений = " + counter);
            }

        } catch(IOException e) {
            System.out.print("Error: " + e);
        }
    }
}
