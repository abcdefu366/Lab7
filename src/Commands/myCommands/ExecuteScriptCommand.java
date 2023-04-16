package Commands.myCommands;

import Classes.Colors;
import Commands.CommandEater;
import Commands.CommandPattern;
import utils.readers.NameReader;
import utils.readers.Reader;
import utils.readers.ReaderFromFile;
import utils.readers.ReaderManager;

import java.awt.*;

public class ExecuteScriptCommand implements CommandPattern {
    private final static int MAX_COUNT_RECURSION = 300;
    private static int countRecursion = 0;
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning()) {
            if (CommandEater.getSplit().length < 2) {
                System.out.println(Colors.YELLOW + "Укажите корректный путь к файлу!" + Colors.YELLOW);
            }
            else if (CommandEater.getSplit().length > 2) {
                System.out.println(Colors.YELLOW + "Такое количество параметров невозможно для этой команды" + Colors.RESET);
            }
            else {
                countRecursion++;
                String FILE_PATH = CommandEater.getSplit()[1];
                Reader reader = new ReaderManager(new ReaderFromFile(FILE_PATH), NameReader.READERFILE);
                CommandEater.setReader(reader);
                if (countRecursion < MAX_COUNT_RECURSION) CommandEater.commandEat();
                else {
                    System.out.println(Colors.YELLOW + "Обнаружена рекурсия! Проверьте правильность запускаемых скриптов" + Colors.RESET);
                    countRecursion = 0;
                }
            }
        }
    }
}
