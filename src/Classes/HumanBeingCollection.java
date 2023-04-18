package Classes;

import Commands.CommandEater;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;

public class HumanBeingCollection {
    private static LinkedList<HumanBeing> humanBeings = new LinkedList<>();
    private static Date dateOfInitialization = new Date();
    /** Метод для добавления HumanBeing из файла в коллекцию */
    public static void readerFromFile(String path) {
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(", ");
                try {
                    humanBeings.add(new HumanBeing(data[0], new Coordinates(Long.parseLong(data[1]), Long.parseLong(data[2])), Boolean.parseBoolean(data[3]), Boolean.parseBoolean(data[4]), Integer.parseInt(data[5]), WeaponType.valueOf(data[6]), Mood.valueOf(data[7]), new Car(Boolean.parseBoolean(data[8]))));
                } catch (Exception ignored) {}
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(Colors.YELLOW + "Файл с коллекцией не найден" + Colors.RESET);
            CommandEater.setIsProgramRunning(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /** Метод, выводящий информацию о коллекции */
    public static void getInfo() {
        System.out.println(Colors.GREEN + "Тип коллекции:" + Colors.RESET + " " + Colors.WHITE + humanBeings.getClass().getTypeName() + Colors.RESET);
        System.out.println(Colors.GREEN + "Дата инициализации:"+ Colors.RESET + " " + Colors.WHITE + dateOfInitialization + Colors.RESET);
        System.out.println(Colors.GREEN + "Количество элементов:" + Colors.RESET + " " + Colors.WHITE + humanBeings.size() + Colors.RESET);
    }
    public static LinkedList<HumanBeing> getHumanBeings() {
        return humanBeings;
    }

    public static void add(HumanBeing humanBeing){
        humanBeings.add(humanBeing);
    }
}
