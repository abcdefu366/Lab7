package Classes;

import java.io.*;
import java.util.LinkedList;

public class HumanBeingCollection {
    private static LinkedList<HumanBeing> humanBeings = new LinkedList<>();
    public static void readerFromFile(String path) {
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                try {
                    humanBeings.add(new HumanBeing(data[0], new Coordinates(Long.parseLong(data[1]), Long.parseLong(data[2])), Boolean.parseBoolean(data[3]), Boolean.parseBoolean(data[4]), Integer.parseInt(data[5]), WeaponType.valueOf(data[6]), Mood.valueOf(data[7]), new Car(Boolean.parseBoolean(data[8]))));
                } catch (Exception ignored) {}
                //catch (ArrayIndexOutOfBoundsException ignored) {}
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static LinkedList<HumanBeing> getHumanBeings() {
        return humanBeings;
    }
}
