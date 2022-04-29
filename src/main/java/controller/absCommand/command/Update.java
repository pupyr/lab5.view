package controller.absCommand.command;

import controller.Data;
import controller.absCommand.AbsCommand;
import controller.absCommand.Commander;
import controller.absCommand.ElementCreator;
import model.Root;

public class Update extends AbsCommand {
    @Override
    public void execute(Data data){
        Root root=Root.getInstance();
        Commander commander=Commander.getInstance();
        boolean b = true;
        ElementCreator elementCreator=new ElementCreator();
        try {
            for (Long l : root.getRoot().keySet()) {
                if (l == Long.parseLong(data.getSecondWord())) {
                    root.add(l, elementCreator.createElement(data));
                    b=false;
                    break;
                }
            }
            if (b) {
                System.out.println("Введенный ключ в коллекции не найден");
                commander.setCorrectCommand(false);
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Введен неверный тип ключа. Требутся Long");
            commander.setCorrectCommand(false);
        }
    }

}
