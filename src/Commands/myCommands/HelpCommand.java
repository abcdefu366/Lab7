package Commands.myCommands;

import Classes.Colors;
import Commands.CommandEater;
import Commands.CommandPattern;

public class HelpCommand implements CommandPattern {

    /** Метод, выводящий справку по доступным командам */
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning() && CommandEater.getSplit().length == 1) {
            System.out.println(Colors.CYAN + "help:" + Colors.RESET + " " + Colors.PURPLE + "вывести справку по доступным командам" + Colors.RESET);
            System.out.println(Colors.CYAN + "info:" + Colors.RESET + " " + Colors.PURPLE + "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)" + Colors.RESET);
            System.out.println(Colors.CYAN + "show:" + Colors.RESET + " " + Colors.PURPLE + "вывести в стандартный поток вывода все элементы коллекции в строковом представлении" + Colors.RESET);
            System.out.println(Colors.CYAN + "add:" + Colors.RESET + " " + Colors.PURPLE + "добавить новый элемент в коллекцию" + Colors.RESET);
            System.out.println(Colors.CYAN + "update {id} {parameter} {new parameter}:" + Colors.RESET + " " + Colors.PURPLE + "обновить значение поля элемента коллекции, id которого указан в {id}. {parameter} должен быть цифрой от 1 до 9" + Colors.RESET);
            System.out.println(Colors.CYAN + "remove_by_id {id}:" + Colors.RESET + " " + Colors.PURPLE + "удалить элемент из коллекции по его id" + Colors.RESET);
            System.out.println(Colors.CYAN + "clear:" + Colors.RESET + " " + Colors.PURPLE + "очистить коллекцию" + Colors.RESET);
            System.out.println(Colors.CYAN + "save:" + Colors.RESET + " " + Colors.PURPLE + "сохранить коллекцию в файл" + Colors.RESET);
            System.out.println(Colors.CYAN + "execute_script file_name:" + Colors.RESET + " " + Colors.PURPLE + "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме" + Colors.RESET);
            System.out.println(Colors.CYAN + "exit:" + Colors.RESET + " " + Colors.PURPLE + "завершить программу (без сохранения в файл)" + Colors.RESET);
            System.out.println(Colors.CYAN + "insert_at {index}:" + Colors.RESET + " " + Colors.PURPLE + "добавить новый элемент в заданную позицию" + Colors.RESET);
            System.out.println(Colors.CYAN + "add_if_max {parameter}:" + Colors.RESET + " " + Colors.PURPLE + "добавить новый элемент в коллекцию, если значение его поля, номер которого указан в {parameter}, превышает значение такого же поля у всех элементов этой коллекции. {parameter} должен быть цифрой от 1 до 9" + Colors.RESET);
            System.out.println(Colors.CYAN + "sort {parameter}:" + Colors.RESET + " " + Colors.PURPLE + "отсортировать коллекцию в естественном порядке по заданному полю. {parameter} должен быть цифрой от 1 до 9" + Colors.RESET);
            System.out.println(Colors.CYAN + "print_unique_mood:" + Colors.RESET + " " + Colors.PURPLE + "вывести уникальные значения поля mood всех элементов в коллекции" + Colors.RESET);
            System.out.println(Colors.CYAN + "print_field_ascending_impact_speed:" + Colors.RESET + " " + Colors.PURPLE + "вывести значения поля impactSpeed всех элементов в порядке возрастания" + Colors.RESET);
            System.out.println(Colors.CYAN + "print_field_descending_car:" + Colors.RESET + " " + Colors.PURPLE + "вывести значения поля car всех элементов в порядке убывания" + Colors.RESET);
            System.out.println();
        }
        else {
            System.out.println(Colors.YELLOW + "Такое количество параметров невозможно для этой команды" + Colors.RESET);
        }
    }
}
