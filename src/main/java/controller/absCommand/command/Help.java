package controller.absCommand.command;

import controller.Data;
import controller.absCommand.AbsCommand;
import controller.absCommand.Commander;

public class Help extends AbsCommand
{
    @Override
    public void execute(Data data) {

        if(data.getSecondWord() == null) {
            System.out.println("help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "insert null {element} : добавить новый элемент с заданным ключом\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_key null : удалить элемент из коллекции по его ключу\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "history : вывести последние 5 команд (без их аргументов)\n" +
                "remove_greater_key null : удалить из коллекции все элементы, ключ которых превышает заданный\n" +
                "remove_lower_key null : удалить из коллекции все элементы, ключ которых меньше, чем заданный\n" +
                "average_of_number_of_wheels : вывести среднее значение поля numberOfWheels для всех элементов коллекции\n" +
                "min_by_id : вывести любой объект из коллекции, значение поля id которого является минимальным\n" +
                "print_ascending : вывести элементы коллекции в порядке возрастания\n");
        }else{
            System.out.println("команда help введена некорректно");
            Commander.getInstance().setCorrectCommand(false);
        }
    }
}
