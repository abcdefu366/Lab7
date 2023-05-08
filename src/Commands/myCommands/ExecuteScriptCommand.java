package Commands.myCommands;

import Classes.Colors;
import Commands.*;
import myUtilities.allForReaders.*;


/**
 * The type Execute script command.
 */
public class ExecuteScriptCommand implements CommandPattern {
    private final static int COUNT_RECURSION_MAX = 100;
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
                if (countRecursion < COUNT_RECURSION_MAX) {
                    countRecursion++;
                    String FILE_PATH = CommandEater.getSplit()[1];
                    Reader reader = new ReaderManager(new ReaderFromFile(FILE_PATH), NameOfReader.FILEREADER);
                    CommandEater.setReader(reader);
                    CommandEater.commandEat();
                }
                else {
                    System.out.println(Colors.YELLOW + "Обнаружена рекурсия! Проверьте правильность запускаемых скриптов" + Colors.RESET);
                    countRecursion = 0;
                }
            }
        }
    }
}
