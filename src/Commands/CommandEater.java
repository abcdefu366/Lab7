package Commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Commands.myCommands.SaveCommand;
import Commands.myCommands.*;
import utils.readers.Reader;
import utils.readers.ReaderFromConsole;
import utils.readers.ReaderFromFile;

public class CommandEater {

    private static Boolean isProgramRunning = true;
    protected static String fileName;
    protected static String[] split;

    protected static Reader reader = new ReaderFromConsole();


    protected static Map<String, CommandPattern> commandPatternHashMap = new HashMap<>();

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
        init();
        while (getIsProgramRunning()) {
            String request = reader.getNewLine();
            if(request == null) {
                CommandEater.setReader(new ReaderFromConsole());
                break;
            }
            split = request.split(" ");
            CommandPattern commandPattern = commandPatternHashMap.get(split[0]);
            if(commandPattern == null) System.out.println("Введена несуществующая команда");
            else commandPattern.execute();
        }
    }

    protected static void init(){
        commandPatternHashMap.put("help", new HelpCommand());
        commandPatternHashMap.put("exit", new ExitCommand());
        commandPatternHashMap.put("show", new ShowCommand());
        commandPatternHashMap.put("add", new AddCommand(reader));
        commandPatternHashMap.put("remove_by_id", new RemoveByIdCommand(reader));
        commandPatternHashMap.put("clear", new ClearCommand());
        commandPatternHashMap.put("update", new UpdateIdCommand());
        commandPatternHashMap.put("save", new SaveCommand());
        commandPatternHashMap.put("sort", new SortCommand());
        commandPatternHashMap.put("info", new InfoCommand());
        commandPatternHashMap.put("insert_at", new InsertAtCommand(reader));
        commandPatternHashMap.put("print_field_ascending_impact_speed", new PrintFieldAscendingImpactSpeedCommand());
        commandPatternHashMap.put("print_field_descending_car", new PrintFieldDescendingCarCommand());
        commandPatternHashMap.put("print_unique_mood", new PrintUniqueMoodCommand());
        commandPatternHashMap.put("add_if_max", new AddIfMaxCommand(reader));
        commandPatternHashMap.put("execute_script", new ExecuteScriptCommand());
    }

    public static void setFileName(String fileName) {
        CommandEater.fileName = fileName;
    }
    public static String getFileName() {
        return fileName;
    }

    public static void setReader(Reader reader) {
        CommandEater.reader = reader;
        init();
    }

}