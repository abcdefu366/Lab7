package Commands.myCommands;

import Classes.*;
import Commands.CommandEater;
import Commands.CommandPattern;
import myUtilities.CreatorHumanBeing;
import myUtilities.allForReaders.Reader;

/**
 * The type Add command.
 */
public class AddCommand implements CommandPattern {

    private Reader reader;

    /**
     * Instantiates a new Add command.
     *
     * @param reader the reader
     */
    public AddCommand(Reader reader) {
        this.reader = reader;
    }

    /** Метод, добавляющий в коллекцию нового HumanBeing */


    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning() && CommandEater.getSplit().length == 1) {
            CreatorHumanBeing creatorHumanBeing = new CreatorHumanBeing(reader);
            HumanBeing humanBeing = creatorHumanBeing.create();
            HumanBeingCollection.add(humanBeing);
            System.out.println(Colors.BLUE + "Новый объект был успешно добавлен в коллекцию" + Colors.RESET);
        }
        else {
            System.out.println(Colors.YELLOW + "Такое количество параметров невозможно для этой команды" + Colors.RESET);
        }
    }
}
