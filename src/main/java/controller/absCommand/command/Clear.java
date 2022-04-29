package controller.absCommand.command;

import controller.Data;
import controller.absCommand.AbsCommand;
import controller.absCommand.Commander;
import model.Root;

public class Clear extends AbsCommand
{
    @Override
    public void execute(Data data) {

        if(data.getSecondWord() == null) {
            Root root=Root.getInstance();
            root.getRoot().clear();
        }else{
            System.out.println("команда clear введена некорректно");
            Commander.getInstance().setCorrectCommand(false);
        }
    }
}
