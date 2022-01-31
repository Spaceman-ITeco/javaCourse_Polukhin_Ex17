package converter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try
        {
            String text;
            List<String> bigWords = new ArrayList<>();
            char [] intermediateArray = new char[128];
            FileInputStream fileInputStream = new FileInputStream("src/source.txt");
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt",false);
            //добавляем файл любого размера, но вычитывает только первые 128 символов
            for (int i=0; i<128;i++)
            {
                try    {
                    intermediateArray[i]=(char)buffer[i];

                }catch ( IndexOutOfBoundsException ignored){}}
            text = new String(intermediateArray).replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
            String[] words = text.split(" ");
            for (String word : words) {
                if (word.length()>=6)
                bigWords.add(word);
            }
            fileOutputStream.write((text.getBytes()));
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.write((bigWords.toString().getBytes()));
        } catch (IOException ioException)
        {System.out.println(ioException);}

    }


}
