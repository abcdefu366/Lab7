package Commands.myCommands;

import Classes.HumanBeing;
import Classes.HumanBeingCollection;
import Commands.CommandEater;
import Commands.CommandPattern;

import java.io.*;

public class SaveCommand implements CommandPattern {
    /** Метод, сохраняющий коллекцию в файл */
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning() && CommandEater.getSplit().length == 1) {
            try {
                OutputStream os = new FileOutputStream(CommandEater.getFileName());
                Writer osr = new OutputStreamWriter(os);
                for (HumanBeing humanBeing : HumanBeingCollection.getHumanBeings()) {
                    osr.write(humanBeing.getName() + "," + humanBeing.getCoordinates().getX() + "," + humanBeing.getCoordinates().getY() + "," + humanBeing.getRealHero() + "," + humanBeing.getHasToothpick() + "," + humanBeing.getImpactSpeed() + "," + humanBeing.getWeaponType() + "," + humanBeing.getMood() + "," + humanBeing.getCar().getCool() + "\n");
                }
                osr.flush();
                osr.close();
                System.out.println("Коллекция сохранена в файл");
            } catch (FileNotFoundException e) {
                System.out.println("Файл с таким именем не найден");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Такое количество параметров невозможно для этой команды");
        }
    }
}
