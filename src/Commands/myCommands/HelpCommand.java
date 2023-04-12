package Commands.myCommands;

import Commands.CommandEater;
import Commands.CommandPattern;

public class HelpCommand implements CommandPattern {
    private String description = "help : вывести справку по доступным командам";
    /** Метод, выводящий справку по доступным командам */
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning() && CommandEater.getSplit().length == 1) {
            System.out.println("""
                help : вывести справку по доступным командам
                info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                add {element} : добавить новый элемент в коллекцию
                update id {element} : обновить значение элемента коллекции, id которого равен заданному
                remove_by_id id : удалить элемент из коллекции по его id
                clear : очистить коллекцию
                save : сохранить коллекцию в файл
                execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
                exit : завершить программу (без сохранения в файл)
                insert_at index {element} : добавить новый элемент в заданную позицию
                add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
                sort : отсортировать коллекцию в естественном порядке
                print_unique_mood : вывести уникальные значения поля mood всех элементов в коллекции
                print_field_ascending_impact_speed : вывести значения поля impactSpeed всех элементов в порядке возрастания
                print_field_descending_car : вывести значения поля car всех элементов в порядке убывания""");
        }
        else {
            System.out.println("Такое количество параметров невозможно для этой команды");
        }
    }
    public String getDescription() {
        return description;
    }
}
