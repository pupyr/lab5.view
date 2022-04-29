package controller.absCommand.command;

import controller.Data;
import controller.absCommand.AbsCommand;
import controller.absCommand.Commander;
import controller.absCommand.ElementCreator;
import model.Root;

public class Insert extends AbsCommand {

    @Override
    public void execute(Data data/*String command*/){
        Root root=Root.getInstance();
        Commander commander=Commander.getInstance();
        ElementCreator elementCreator=new ElementCreator();
        try {
            root.add(Long.parseLong(data.getSecondWord()), elementCreator.createElement(data));
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Введен неверный ключ и тело");
            commander.setCorrectCommand(false);
        }
    }
}
