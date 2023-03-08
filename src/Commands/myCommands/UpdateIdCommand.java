package Commands.myCommands;

import Classes.*;
import Commands.CommandEater;
import Commands.CommandPattern;

import java.util.Scanner;

public class UpdateIdCommand implements CommandPattern {
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning()) {
            Long id = Long.parseLong(CommandEater.getSplit()[1]);
            Integer parameter = Integer.parseInt(CommandEater.getSplit()[2]);
            String newParameter = CommandEater.getSplit()[3];
            if (!HumanBeingCollection.getHumanBeings().isEmpty()) {
                for (HumanBeing humanBeing : HumanBeingCollection.getHumanBeings()) {
                    if (humanBeing.getId().equals(id)) {
                        if (parameter.equals(1)) {
                            humanBeing.setName(newParameter);
                        }
                        if (parameter.equals(2)) {
                            Long y = humanBeing.getCoordinates().getY();
                            humanBeing.setCoordinates(new Coordinates(Long.valueOf(newParameter), y));
                        }
                        if (parameter.equals(3)) {
                            Long x = humanBeing.getCoordinates().getX();
                            humanBeing.setCoordinates(new Coordinates(x, Long.valueOf(newParameter)));
                        }
                        if (parameter.equals(4)) {
                            humanBeing.setRealHero(Boolean.valueOf(newParameter));
                        }
                        if (parameter.equals(5)) {
                            humanBeing.setHasToothpick(Boolean.valueOf(newParameter));
                        }
                        if (parameter.equals(6)) {
                            humanBeing.setImpactSpeed(Integer.valueOf(newParameter));
                        }
                        if (parameter.equals(7)) {
                            humanBeing.setWeaponType(WeaponType.valueOf(newParameter));
                        }
                        if (parameter.equals(8)) {
                            humanBeing.setMood(Mood.valueOf(newParameter));
                        }
                        if (parameter.equals(9)) {
                            humanBeing.setCar(new Car(Boolean.valueOf(newParameter)));
                        }
                    }
                }
            }
        }
    }
}
