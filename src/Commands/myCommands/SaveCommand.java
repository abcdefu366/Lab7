package Commands.myCommands;

import Classes.Colors;
import Classes.HumanBeing;
import Classes.HumanBeingCollection;
import Commands.CommandEater;
import Commands.CommandPattern;
import java.io.*;

/**
 * The type Save command.
 */
public class SaveCommand implements CommandPattern {
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning() && CommandEater.getSplit().length == 1) {
            try {
                OutputStream os = new FileOutputStream(CommandEater.getFileName());
                Writer osr = new OutputStreamWriter(os);
                for (HumanBeing humanBeing : HumanBeingCollection.getHumanBeings()) {
                    osr.write(humanBeing.getName() + ", " + humanBeing.getCoordinates().getX() + ", " + humanBeing.getCoordinates().getY() + ", " + humanBeing.getRealHero() + ", " + humanBeing.getHasToothpick() + ", " + humanBeing.getImpactSpeed() + ", " + humanBeing.getWeaponType() + ", " + humanBeing.getMood() + ", " + humanBeing.getCar().getCool() + "\n");
                }
                osr.flush();
                osr.close();
                System.out.println(Colors.BLUE + "Коллекция сохранена в файл" + Colors.RESET);
            } catch (FileNotFoundException e) {
                System.out.println(Colors.YELLOW + "Файл с таким именем не найден" + Colors.RESET);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println(Colors.YELLOW + "Такое количество параметров невозможно для этой команды" + Colors.RESET);
        }
    }
}
