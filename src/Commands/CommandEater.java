package Commands;

import java.util.HashMap;
import java.util.Map;
import Classes.Colors;
import Commands.myCommands.SaveCommand;
import Commands.myCommands.*;
import myUtilities.allForReaders.Reader;
import myUtilities.allForReaders.ReaderFromConsole;

/**
 * The type Command eater.
 */
public class CommandEater {
    private static Boolean isProgramRunning = true;
    /**
     * The constant fileName.
     */
    protected static String fileName;
    /**
     * The Split.
     */
    protected static String[] split;

    /**
     * The constant reader.
     */
    protected static Reader reader = new ReaderFromConsole();

    /**
     * The constant commandPatternHashMap.
     */
    protected static Map<String, CommandPattern> commandPatternHashMap = new HashMap<>();

    /**
     * Sets is program running.
     *
     * @param isProgramRunning the is program running
     */
    public static void setIsProgramRunning(Boolean isProgramRunning) {
        CommandEater.isProgramRunning = isProgramRunning;
    }

    /**
     * Gets is program running.
     *
     * @return the is program running
     */
    public static Boolean getIsProgramRunning() {
        return isProgramRunning;
    }

    /**
     * Get split string [ ].
     *
     * @return the string [ ]
     */
    public static String[] getSplit() {
        return split;
    }

    /**
     * Command eat.
     */
    public static void commandEat() {
        loadCommands();
        while (getIsProgramRunning()) {
            String request = reader.getNewLine();
            if(request == null) {
                CommandEater.setReader(new ReaderFromConsole());
                break;
            }
            split = request.split(" ");
            boolean condition = true;
            while (condition) {
                try {
                    commandPatternHashMap.get(split[0]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(Colors.YELLOW + "Введена несуществующая команда" + Colors.RESET);
                }
            }
            CommandPattern commandPattern = commandPatternHashMap.get(split[0]);
            if(commandPattern == null) System.out.println(Colors.YELLOW + "Введена несуществующая команда" + Colors.RESET);
            else commandPattern.execute();
        }
    }

    /**
     * loadCommands.
     */
    protected static void loadCommands(){
        commandPatternHashMap.put("help", new HelpCommand());
        commandPatternHashMap.put("exit", new ExitCommand());
        commandPatternHashMap.put("show", new ShowCommand());
        commandPatternHashMap.put("add", new AddCommand(reader));
        commandPatternHashMap.put("remove_by_id", new RemoveByIdCommand(reader));
        commandPatternHashMap.put("clear", new ClearCommand());
        commandPatternHashMap.put("update", new UpdateCommand());
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

    /**
     * Sets file name.
     *
     * @param fileName the file name
     */
    public static void setFileName(String fileName) {
        CommandEater.fileName = fileName;
    }

    /**
     * Gets file name.
     *
     * @return the file name
     */
    public static String getFileName() {
        return fileName;
    }

    /**
     * Sets reader.
     *
     * @param reader the reader
     */
    public static void setReader(Reader reader) {
        CommandEater.reader = reader;
        loadCommands();
    }

}