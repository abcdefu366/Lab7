package Commands.myCommands;

import Classes.*;
import Commands.CommandEater;
import Commands.CommandPattern;


public class UpdateCommand implements CommandPattern {
    /** Метод, обновляющий значение элемента коллекции, id которого равен заданному */
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning()) {
            if (!(CommandEater.getSplit().length == 4)) {
                System.out.println(Colors.YELLOW + "Такое количество параметров невозможно для этой команды" + Colors.RESET);
            }
            else {
                if (!(CommandEater.getSplit()[1].matches("^[+]?\\d+$"))) {
                    System.out.println(Colors.YELLOW + "Введён некорректный id" + Colors.RESET);
                }
                if (!(CommandEater.getSplit()[2].matches("[1-9]"))) {
                    System.out.println(Colors.YELLOW + "Введён некорректный параметр" + Colors.RESET);
                } else {
                    Long id = Long.parseLong(CommandEater.getSplit()[1]);
                    Integer parameter = Integer.parseInt(CommandEater.getSplit()[2]);
                    String newParameter = CommandEater.getSplit()[3];
                    if (!HumanBeingCollection.getHumanBeings().isEmpty()) {
                        for (HumanBeing humanBeing : HumanBeingCollection.getHumanBeings()) {
                            if (humanBeing.getId().equals(id)) {
                                if (parameter.equals(1)) {
                                    humanBeing.setName(newParameter);
                                }
                                if (parameter.equals(3)) {
                                    if (newParameter.matches("^[+-]?\\d+$")) {
                                        Long y = humanBeing.getCoordinates().getY();
                                        humanBeing.setCoordinates(new Coordinates(Long.valueOf(newParameter), y));
                                    } else {
                                        System.out.println(Colors.YELLOW + "Некорректный новый параметр" + Colors.RESET);
                                    }
                                }
                                if (parameter.equals(2)) {
                                    if (newParameter.matches("^[+-]?\\d+$")) {
                                        Long x = humanBeing.getCoordinates().getX();
                                        humanBeing.setCoordinates(new Coordinates(x, Long.valueOf(newParameter)));
                                    } else {
                                        System.out.println(Colors.YELLOW + "Некорректный новый параметр" + Colors.RESET);
                                    }
                                }
                                if (parameter.equals(4)) {
                                    humanBeing.setRealHero(Boolean.valueOf(newParameter));
                                }
                                if (parameter.equals(5)) {
                                    humanBeing.setHasToothpick(Boolean.valueOf(newParameter));
                                }
                                if (parameter.equals(6)) {
                                    if (newParameter.matches("^[+-]?\\d+$")) {
                                        humanBeing.setImpactSpeed(Integer.valueOf(newParameter));
                                    } else {
                                        System.out.println(Colors.YELLOW + "Некорректный новый параметр" + Colors.RESET);
                                    }
                                }
                                if (parameter.equals(7)) {
                                    String str = newParameter.toUpperCase();
                                    if (str.equals("PISTOL") || str.equals("KNIFE") || str.equals("MACHINE_GUN")) {
                                        humanBeing.setWeaponType(WeaponType.valueOf(str));
                                    }
                                    else if (newParameter.equals("1")) {
                                        humanBeing.setWeaponType(WeaponType.PISTOL);
                                    }
                                    else if (newParameter.equals("2")) {
                                        humanBeing.setWeaponType(WeaponType.KNIFE);
                                    }
                                    else if (newParameter.equals("3")) {
                                        humanBeing.setWeaponType(WeaponType.MACHINE_GUN);
                                    } else {
                                        System.out.println(Colors.YELLOW + "Некорректный новый параметр" + Colors.RESET);
                                    }
                                }
                                if (parameter.equals(8)) {
                                    String str = newParameter.toUpperCase();
                                    if (str.equals("SORROW") || str.toUpperCase().equals("SADNESS") || str.equals("LONGING")) {
                                        humanBeing.setMood(Mood.valueOf(str));
                                    }
                                    else if (newParameter.equals("1")) {
                                        humanBeing.setMood(Mood.SADNESS);
                                    }
                                    else if (newParameter.equals("2")) {
                                        humanBeing.setMood(Mood.SORROW);
                                    }
                                    else if (newParameter.equals("3")) {
                                        humanBeing.setMood(Mood.LONGING);
                                    } else {
                                        System.out.println(Colors.YELLOW + "Некорректный новый параметр" + Colors.RESET);
                                    }
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
    }
}
