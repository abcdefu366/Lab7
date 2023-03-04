package Commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Classes.SaveCommand;
import Commands.myCommands.*;

public class CommandEater {
    private static Boolean isProgramRunning = true;
    private static String fileName;
    private static String[] split;

    public static void setIsProgramRunning(Boolean isProgramRunning) {
        CommandEater.isProgramRunning = isProgramRunning;
    }
    public static Boolean getIsProgramRunning() {
        return isProgramRunning;
    }
    public static String[] getSplit() {
        return split;
    }
    public static void commandEat() {
        Map<String, CommandPattern> commandPatternHashMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        commandPatternHashMap.put("help", new HelpCommand());
        commandPatternHashMap.put("exit", new ExitCommand());
        commandPatternHashMap.put("show", new ShowCommand());
        commandPatternHashMap.put("add", new AddCommand());
        commandPatternHashMap.put("remove_by_id", new RemoveByIdCommand());
        commandPatternHashMap.put("clear", new ClearCommand());
        commandPatternHashMap.put("update", new UpdateIdCommand());
        commandPatternHashMap.put("save", new SaveCommand());
        while (getIsProgramRunning()) {
            split = scanner.nextLine().split(" ");
            CommandPattern commandPattern = commandPatternHashMap.get(split[0]);
            commandPattern.execute();
        }
    }
    public static void setFileName(String fileName) {
        CommandEater.fileName = fileName;
    }
    public static String getFileName() {
        return fileName;
    }
}
