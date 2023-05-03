package Commands.myCommands;

import Classes.*;
import Commands.CommandEater;
import Commands.CommandPattern;
import myUtilities.CreatorHumanBeing;
import myUtilities.allForReaders.Reader;
import java.util.LinkedList;

/**
 * The type Add if max command.
 */
public class AddIfMaxCommand implements CommandPattern {
    private Reader reader;

    /**
     * Instantiates a new Add if max command.
     *
     * @param reader the reader
     */
    public AddIfMaxCommand(Reader reader) {
        this.reader = reader;
    }
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning()) {
            if (CommandEater.getSplit().length > 2) {
                System.out.println(Colors.YELLOW + "Такое количество параметров невозможно для этой команды" + Colors.RESET);
            }
            if (CommandEater.getSplit().length < 2 || !(CommandEater.getSplit()[1].matches("^[+]?\\d+$"))) {
                System.out.println(Colors.YELLOW + "Введён некорректный параметр для сравнения" + Colors.RESET);
            }
            else {
                Integer parameter = Integer.parseInt(CommandEater.getSplit()[1]);
                if (parameter > 10 || parameter < 1) {
                    System.out.println(Colors.YELLOW + "Введён некорректный параметр сортировки" + Colors.RESET);;
                }
                else {
                    CreatorHumanBeing creatorHumanBeing = new CreatorHumanBeing(reader);
                    HumanBeing humanBeing = creatorHumanBeing.create();
                    System.out.println(Colors.BLACK + "Элемент добавлен в коллекцию для сравнения" + Colors.RESET);
                    LinkedList<HumanBeing> humanBeingLinkedList = new LinkedList<>(HumanBeingCollection.getHumanBeings());
                    if (humanBeingLinkedList.isEmpty()) {
                        HumanBeingCollection.addDB(humanBeing);
                        System.out.println(Colors.BLUE + "Элемент добавлен в основную коллекцию" + Colors.RESET);
                    } else {
                        if (parameter.equals(1)) {
                            humanBeingLinkedList.sort(new HumanBeing.SortById());
                            if (humanBeingLinkedList.peekLast().getId() < humanBeing.getId()) {
                                HumanBeingCollection.addDB(humanBeing);
                                System.out.println(Colors.BLUE + "Элемент добавлен в основную коллекцию" + Colors.RESET);
                            }
                        }
                        if (parameter.equals(2)) {
                            humanBeingLinkedList.sort(new HumanBeing.SortByName());
                            if (humanBeingLinkedList.peekLast().getName().compareTo(humanBeing.getName()) < 0) {
                                HumanBeingCollection.addDB(humanBeing);
                                System.out.println(Colors.BLUE + "Элемент добавлен в основную коллекцию" + Colors.RESET);
                            }
                        }
                        if (parameter.equals(3)) {
                            humanBeingLinkedList.sort(new HumanBeing.SortByX_Coordinate());
                            if (humanBeingLinkedList.peekLast().getCoordinates().getX() < humanBeing.getCoordinates().getX()) {
                                HumanBeingCollection.addDB(humanBeing);
                                System.out.println(Colors.BLUE + "Элемент добавлен в основную коллекцию" + Colors.RESET);
                            }
                        }
                        if (parameter.equals(4)) {
                            humanBeingLinkedList.sort(new HumanBeing.SortByY_Coordinate());
                            if (humanBeingLinkedList.peekLast().getCoordinates().getY() < humanBeing.getCoordinates().getY()) {
                                HumanBeingCollection.addDB(humanBeing);
                                System.out.println(Colors.BLUE + "Элемент добавлен в основную коллекцию" + Colors.RESET);
                            }
                        }
                        if (parameter.equals(5)) {
                            humanBeingLinkedList.sort(new HumanBeing.SortByRealHero());
                            if (humanBeing.getRealHero() || !(humanBeing.getRealHero() && humanBeingLinkedList.peekLast().getRealHero())) {
                                HumanBeingCollection.addDB(humanBeing);
                                System.out.println(Colors.BLUE + "Элемент добавлен в основную коллекцию" + Colors.RESET);
                            }
                        }
                        if (parameter.equals(6)) {
                            humanBeingLinkedList.sort(new HumanBeing.SortByHasToothpick());
                            if (humanBeing.getHasToothpick() || !(humanBeing.getHasToothpick() && humanBeingLinkedList.peekLast().getHasToothpick())) {
                                HumanBeingCollection.addDB(humanBeing);
                                System.out.println(Colors.BLUE + "Элемент добавлен в основную коллекцию" + Colors.RESET);
                            }
                        }
                        if (parameter.equals(7)) {
                            humanBeingLinkedList.sort(new HumanBeing.SortByImpactSpeed());
                            if (humanBeingLinkedList.peekLast().getImpactSpeed() < humanBeing.getImpactSpeed()) {
                                HumanBeingCollection.addDB(humanBeing);
                                System.out.println(Colors.BLUE + "Элемент добавлен в основную коллекцию" + Colors.RESET);
                            }
                        }
                        if (parameter.equals(8)) {
                            humanBeingLinkedList.sort(new HumanBeing.SortByWeaponType());
                            if ((humanBeing.getWeaponType().equals(WeaponType.KNIFE)) || (humanBeingLinkedList.peekLast().getWeaponType().equals(WeaponType.MACHINE_GUN) && humanBeing.getWeaponType().equals(WeaponType.KNIFE)) || (humanBeingLinkedList.peekLast().getWeaponType().equals(WeaponType.PISTOL) && (humanBeing.getWeaponType().equals(WeaponType.KNIFE) || humanBeing.getWeaponType().equals(WeaponType.MACHINE_GUN)))) {
                                HumanBeingCollection.addDB(humanBeing);
                                System.out.println(Colors.BLUE + "Элемент добавлен в основную коллекцию" + Colors.RESET);
                            }
                        }
                        if (parameter.equals(9)) {
                            humanBeingLinkedList.sort(new HumanBeing.SortByMood());
                            if ((humanBeing.getMood().equals(Mood.LONGING)) || (humanBeingLinkedList.peekLast().getMood().equals(Mood.SADNESS) && humanBeing.getMood().equals(Mood.LONGING)) || (humanBeingLinkedList.peekLast().getMood().equals(Mood.SORROW) && (humanBeing.getMood().equals(Mood.LONGING) || humanBeing.getMood().equals(Mood.SADNESS)))) {
                                HumanBeingCollection.addDB(humanBeing);
                                System.out.println(Colors.BLUE + "Элемент добавлен в основную коллекцию" + Colors.RESET);
                            }
                        }
                        if (parameter.equals(10)) {
                            humanBeingLinkedList.sort(new HumanBeing.SortByCar());
                            if (humanBeing.getCar().getCool() || !(humanBeing.getCar().getCool() && humanBeingLinkedList.peekLast().getCar().getCool())) {
                                HumanBeingCollection.addDB(humanBeing);
                                System.out.println(Colors.BLUE + "Элемент добавлен в основную коллекцию" + Colors.RESET);
                            }
                        }
                    }
                    humanBeingLinkedList.clear();
                }
            }
        }
    }
}