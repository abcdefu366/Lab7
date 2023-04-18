import Classes.*;
import Commands.CommandEater;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        if (!(args.length == 1)) {
            System.out.println(Colors.YELLOW + "Некорректный путь к файлу с коллекцией" + Colors.RESET);
        }
        else {
            CommandEater.setFileName(args[0]);
            HumanBeingCollection.readerFromFile(CommandEater.getFileName());
            try {
                CommandEater.commandEat();
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println(Colors.YELLOW + "Неверный ввод. Продолжение работы программы невозможно" + Colors.RESET);
            }
        }
    }
}