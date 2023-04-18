package Commands.myCommands;

import Classes.Colors;
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
            if (CommandEater.getSplit().length > 2) {
                System.out.println(Colors.YELLOW + "Такое количество параметров невозможно для этой команды" + Colors.RESET);
            }
            if (CommandEater.getSplit().length < 2 || !(CommandEater.getSplit()[1].matches("^[+-]?\\d+$"))) {
                System.out.println(Colors.YELLOW + "Введён некорректный id" + Colors.RESET);
            }
            else {
                try {
                    Long id = Long.parseLong(CommandEater.getSplit()[1]);
                    Boolean isHumanBeingDelete = false;
                    if (!HumanBeingCollection.getHumanBeings().isEmpty()) {
                        for (HumanBeing humanBeing : HumanBeingCollection.getHumanBeings()) {
                            if (humanBeing.getId().equals(id)) {
                                HumanBeingCollection.getHumanBeings().remove(humanBeing);
                                isHumanBeingDelete = true;
                                System.out.println(Colors.BLUE + "Элемент с Id:" + Colors.RESET + " " + id + " " + Colors.BLUE + "удалён из коллекции" + Colors.RESET);
                            }
                        }
                        if (!isHumanBeingDelete) {
                            System.out.println(Colors.YELLOW + "Такой HumanBeing не найден в коллекции" + Colors.RESET);
                        }
                    } else {
                        System.out.println(Colors.YELLOW + "Коллекция не содержит данных" + Colors.RESET);
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод данных (значение не принадлежит допустимому диапазону). Введите ещё раз!");
                }
            }
        }
    }
}
