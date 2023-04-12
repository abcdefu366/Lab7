package Commands.myCommands;

import Classes.*;
import Commands.CommandEater;
import Commands.CommandPattern;
import utils.CreatorHumanBeing;
import utils.readers.Reader;

import java.util.Collections;
import java.util.LinkedList;

public class AddIfMaxCommand implements CommandPattern {
    private Reader reader;

    public AddIfMaxCommand(Reader reader) {
        this.reader = reader;
    }
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning()) {
            if (CommandEater.getSplit().length > 2) {
                System.out.println("Такое количество параметров невозможно для этой команды");
            }
            if (CommandEater.getSplit().length < 2 || !(CommandEater.getSplit()[1].matches("[1-9]"))) {
                System.out.println("Введён некорректный параметр сортировки");
            }
            else {
                Integer parameter = Integer.parseInt(CommandEater.getSplit()[1]);
                LinkedList<HumanBeing> humanBeingsAdded = new LinkedList<>();
                CreatorHumanBeing creatorHumanBeing = new CreatorHumanBeing(reader);
                HumanBeing humanBeing = creatorHumanBeing.create();
                humanBeingsAdded.add(humanBeing);
                System.out.println("Элемент добавлен в коллекцию для сравнения");
                LinkedList<HumanBeing> humanBeingLinkedList = new LinkedList<>(HumanBeingCollection.getHumanBeings());
                if (humanBeingLinkedList.isEmpty()) {
                    HumanBeingCollection.getHumanBeings().add(humanBeingsAdded.peek());
                    System.out.println("Элемент добавлен в основную коллекцию");
                }
                else {
                    if (parameter.equals(1)) {
                        Collections.sort(humanBeingLinkedList, new HumanBeing.SortById());
                        if (humanBeingLinkedList.peekLast().getId() < humanBeingsAdded.peek().getId()) {
                            HumanBeingCollection.getHumanBeings().add(humanBeingsAdded.peek());
                            System.out.println("Элемент добавлен в основную коллекцию");
                        }
                    }
                    if (parameter.equals(2)) {
                        Collections.sort(humanBeingLinkedList, new HumanBeing.SortByX_Coordinate());
                        if (humanBeingLinkedList.peekLast().getCoordinates().getX() < humanBeingsAdded.peek().getCoordinates().getX()) {
                            HumanBeingCollection.getHumanBeings().add(humanBeingsAdded.peek());
                            System.out.println("Элемент добавлен в основную коллекцию");
                        }
                    }
                    if (parameter.equals(3)) {
                        Collections.sort(humanBeingLinkedList, new HumanBeing.SortByY_Coordinate());
                        if (humanBeingLinkedList.peekLast().getCoordinates().getY() < humanBeingsAdded.peek().getCoordinates().getY()) {
                            HumanBeingCollection.getHumanBeings().add(humanBeingsAdded.peek());
                            System.out.println("Элемент добавлен в основную коллекцию");
                        }
                    }
                    if (parameter.equals(4)) {
                        Collections.sort(humanBeingLinkedList, new HumanBeing.SortByRealHero());
                        if (humanBeingsAdded.peek().getRealHero() || !(humanBeingsAdded.peek().getRealHero() && humanBeingLinkedList.peekLast().getRealHero())) {
                            HumanBeingCollection.getHumanBeings().add(humanBeingsAdded.peek());
                            System.out.println("Элемент добавлен в основную коллекцию");
                        }
                    }
                    if (parameter.equals(5)) {
                        Collections.sort(humanBeingLinkedList, new HumanBeing.SortByHasToothpick());
                        if (humanBeingsAdded.peek().getHasToothpick() || !(humanBeingsAdded.peek().getHasToothpick() && humanBeingLinkedList.peekLast().getHasToothpick())) {
                            HumanBeingCollection.getHumanBeings().add(humanBeingsAdded.peek());
                            System.out.println("Элемент добавлен в основную коллекцию");
                        }
                    }
                    if (parameter.equals(6)) {
                        Collections.sort(humanBeingLinkedList, new HumanBeing.SortByImpactSpeed());
                        if (humanBeingLinkedList.peekLast().getImpactSpeed() < humanBeingsAdded.peek().getImpactSpeed()) {
                            HumanBeingCollection.getHumanBeings().add(humanBeingsAdded.peek());
                            System.out.println("Элемент добавлен в основную коллекцию");
                        }
                    }
                    if (parameter.equals(7)) {
                        Collections.sort(humanBeingLinkedList, new HumanBeing.SortByWeaponType());
                        if ((humanBeingsAdded.peek().getWeaponType().equals(WeaponType.KNIFE)) || (humanBeingLinkedList.peekLast().getWeaponType().equals(WeaponType.MACHINE_GUN) && humanBeingsAdded.peek().getWeaponType().equals(WeaponType.KNIFE)) || (humanBeingLinkedList.peekLast().getWeaponType().equals(WeaponType.PISTOL) && (humanBeingsAdded.peek().getWeaponType().equals(WeaponType.KNIFE) || humanBeingsAdded.peek().getWeaponType().equals(WeaponType.MACHINE_GUN)))) {
                            HumanBeingCollection.getHumanBeings().add(humanBeingsAdded.peek());
                            System.out.println("Элемент добавлен в основную коллекцию");
                        }
                    }
                    if (parameter.equals(8)) {
                        Collections.sort(humanBeingLinkedList, new HumanBeing.SortByMood());
                        if ((humanBeingsAdded.peek().getMood().equals(Mood.LONGING)) || (humanBeingLinkedList.peekLast().getMood().equals(Mood.SADNESS) && humanBeingsAdded.peek().getMood().equals(Mood.LONGING)) || (humanBeingLinkedList.peekLast().getMood().equals(Mood.SORROW) && (humanBeingsAdded.peek().getMood().equals(Mood.LONGING) || humanBeingsAdded.peek().getMood().equals(Mood.SADNESS)))) {
                            HumanBeingCollection.getHumanBeings().add(humanBeingsAdded.peek());
                            System.out.println("Элемент добавлен в основную коллекцию");
                        }
                    }
                    if (parameter.equals(9)) {
                        Collections.sort(humanBeingLinkedList, new HumanBeing.SortByCar());
                        if (humanBeingsAdded.peek().getCar().getCool() || !(humanBeingsAdded.peek().getCar().getCool() && humanBeingLinkedList.peekLast().getCar().getCool())) {
                            HumanBeingCollection.getHumanBeings().add(humanBeingsAdded.peek());
                            System.out.println("Элемент добавлен в основную коллекцию");
                        }
                    }
                }
                humanBeingsAdded.clear();
                humanBeingLinkedList.clear();
            }
        }
    }
}
