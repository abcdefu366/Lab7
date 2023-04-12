package Commands.myCommands;

import Classes.HumanBeing;
import Classes.HumanBeingCollection;
import Commands.CommandEater;
import Commands.CommandPattern;
import utils.readers.Reader;

public class RemoveByIdCommand implements CommandPattern {
    private Reader reader;
    public RemoveByIdCommand(Reader reader) {
        this.reader = reader;
    }
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning()) {
            if (CommandEater.getSplit().length < 2 || !(CommandEater.getSplit()[1].matches("^[+-]?\\d+$"))) {
                System.out.println("Введён некорректный id");
            }
            if (CommandEater.getSplit().length > 2) {
                System.out.println("Такое количество параметров невозможно для этой команды");
            }
            else {
                Long id = Long.parseLong(CommandEater.getSplit()[1]);
                Boolean isHumanBeingDelete = false;
                if (!HumanBeingCollection.getHumanBeings().isEmpty()) {
                    for (HumanBeing humanBeing : HumanBeingCollection.getHumanBeings()) {
                        if (humanBeing.getId().equals(id)) {
                            HumanBeingCollection.getHumanBeings().remove(humanBeing);
                            isHumanBeingDelete = true;
                            System.out.println("Элемент с Id: " + id + " удалён из коллекции");
                        }
                    }
                    if (!isHumanBeingDelete) {
                        System.out.println("Такой HumanBeing не найден в коллекции");
                    }
                } else {
                    System.out.println("Коллекция не содержит данных");
                }
            }
        }
        else {
            System.out.println("Некорректная команда");
        }
    }
}
