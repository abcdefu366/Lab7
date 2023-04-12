package Commands.myCommands;

import Commands.CommandEater;
import Commands.CommandPattern;
import utils.readers.NameReader;
import utils.readers.Reader;
import utils.readers.ReaderFromFile;
import utils.readers.ReaderManager;

public class ExecuteScriptCommand implements CommandPattern {
    private final static int MAX_COUNT_RECURSION = 300;
    private static int countRecursion = 0;
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning()) {
            if (CommandEater.getSplit().length < 2) {
                System.out.println("Укажите корректный путь к файлу!");
            }
            if (CommandEater.getSplit().length > 2) {
                System.out.println("Такое количество параметров невозможно для этой команды");
            } else {
                countRecursion++;
                String FILE_PATH = CommandEater.getSplit()[1];
                Reader reader = new ReaderManager(new ReaderFromFile(FILE_PATH), NameReader.READERFILE);
                CommandEater.setReader(reader);
                if (countRecursion < MAX_COUNT_RECURSION) CommandEater.commandEat();
                else {
                    System.out.println("Обнаружена рекурсия! Проверьте правильность запускаемых скриптов");
                    countRecursion = 0;
                }
            }
        }
    }
}
