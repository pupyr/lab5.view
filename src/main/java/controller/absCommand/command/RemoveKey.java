package controller.absCommand.command;

import controller.Data;
import controller.absCommand.AbsCommand;
import controller.absCommand.Commander;
import model.Root;

public class RemoveKey extends AbsCommand {

    @Override
    public void execute(Data data){
        Root root=Root.getInstance();
        Script script=Script.getInstance();
        Commander commander=Commander.getInstance();
        try {
            boolean b = true;
            for (Long l : root.getRoot().keySet()) {
                if (l == Long.parseLong(data.getSecondWord())) {
                    root.getRoot().remove(Long.parseLong(data.getSecondWord()));
                    b = false;
                    break;
                }
            }
            if (b) {
                System.out.println("Введенный ключ в коллекции не найден");
                commander.setCorrectCommand(false);
            } else {
                if (script.isScriptStart()) System.out.println("Команда успешно выполнена");
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Введен неверный тип ключа. Требуется Long");
            commander.setCorrectCommand(false);
        }
    }
}
