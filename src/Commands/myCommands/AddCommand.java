package Commands.myCommands;

import Classes.*;
import Commands.CommandEater;
import Commands.CommandPattern;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddCommand implements CommandPattern {
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning()) {
            try {
                Scanner scanner = new Scanner(System.in);
                String name = scanner.nextLine();
                Long x = Long.parseLong(scanner.nextLine());
                Long y = Long.parseLong(scanner.nextLine());
                Boolean realHero = Boolean.parseBoolean(scanner.nextLine());
                Boolean hasToothpick = Boolean.parseBoolean(scanner.nextLine());
                Integer speed = Integer.parseInt(scanner.nextLine());
                String weaponType = scanner.nextLine();
                String mood = scanner.nextLine();
                Boolean cool = Boolean.parseBoolean(scanner.nextLine());
                HumanBeingCollection.getHumanBeings().add(new HumanBeing(name, new Coordinates(x, y), realHero, hasToothpick, speed, WeaponType.valueOf(weaponType), Mood.valueOf(mood), new Car(cool)));
                System.out.println("Новый элемент добавлен в коллекцию");
            }
            catch (Exception e) {} //exception???  No line found
        }
    }
}
