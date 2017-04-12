package testing1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        searchUnitsMax("input.txt");
    }

    public static void searchUnitsMax(String fileName) {                
      
        int standard = 0; // для хранения максимального значения
        int var = 0; // для хранения переменного значения
        // чтение файла
        BufferedReader bufferedReader = null;
        try {        	
            bufferedReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e1) {
            System.out.println("Нет файла");            
            return;
        }

        int symbol = 0;
        try {
            symbol = bufferedReader.read();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            while ((symbol = bufferedReader.read()) != -1) {               
                    char c = (char) symbol;
                    if (c == '1') {
                        var += 1;
                    } else {
                    	if (standard < var) { // запись максимального
                            standard = var;
                        }
                        var = 0;
                    }               
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        // Запись файла
        try (FileWriter writer = new FileWriter("output.txt", false)) {
            // запись всей строки
            String text = "";
            for (int i = 0; i < standard; i++) {
                text = text + "1";
            }
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
