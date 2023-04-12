package utils.readers;

import java.util.Scanner;

public class ReaderFromConsole extends Reader{
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getNewLine(){
        return scanner.nextLine();
    }
}
