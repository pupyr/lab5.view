package controller.absCommand.command;

import controller.Data;
import controller.absCommand.AbsCommand;
import controller.absCommand.Commander;
import model.Root;

public class PrintAscending extends AbsCommand
{
    @Override
    public void execute(Data data) {
        if(data.getSecondWord() == null) {
            Root root= Root.getInstance();
            root.sorting(false);
        }else{
            System.out.println("команда print_ascending введена некорректно");
            Commander.getInstance().setCorrectCommand(false);
        }

    }
}
