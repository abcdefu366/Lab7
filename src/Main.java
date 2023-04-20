import Classes.*;
import Commands.CommandEater;
import java.util.NoSuchElementException;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        if (!(args.length == 1)) {
            System.out.println(Colors.YELLOW + "Некорректный путь к файлу с коллекцией" + Colors.RESET);
        }
        else {
            try {
                String varValue = System.getenv(args[0]);
                CommandEater.setFileName(varValue);
                HumanBeingCollection.readerFromFile(CommandEater.getFileName());
                try {
                    CommandEater.commandEat();
                } catch (NoSuchElementException noSuchElementException) {
                    System.out.println(Colors.YELLOW + "Неверный ввод. Продолжение работы программы невозможно" + Colors.RESET);
                }
            }
            catch (NullPointerException e) {
                System.out.println(Colors.YELLOW + "Проверьте корректность введённой переменной окружения!" + Colors.RESET);
            }
        }
    }
}