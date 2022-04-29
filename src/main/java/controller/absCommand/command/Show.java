package controller.absCommand.command;

import controller.Data;
import controller.absCommand.AbsCommand;
import controller.absCommand.Commander;
import model.Root;

public class Show extends AbsCommand
{
    @Override
    public void execute(Data data) {
        if(data.getSecondWord() == null) {
            Root root = Root.getInstance();
            System.out.println(root.write(0));
        }else{
            System.out.println("команда show введена некорректно");
            Commander.getInstance().setCorrectCommand(false);
        }
    }
}
