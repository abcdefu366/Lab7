package utils.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReaderFromFile extends Reader{

    private final String FILE_PATH;
    private final List<String> allCommands = new ArrayList<>();
    private int numberString = -1;

    public ReaderFromFile(String FILE_PATH) {
        this.FILE_PATH = FILE_PATH;
        addAllCommands();
    }
    public String getNewLine(){
        numberString++;
        if(numberString >= allCommands.size()) return null;
        return allCommands.get(numberString);
    }
    private void addAllCommands(){
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                allCommands.add(line);
            }
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл");
        }
    }
}