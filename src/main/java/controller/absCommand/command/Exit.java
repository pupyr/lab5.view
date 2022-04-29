package controller.absCommand.command;

import controller.Data;
import controller.absCommand.AbsCommand;
import controller.absCommand.Commander;

public class Exit extends AbsCommand {

    @Override
    public void execute(Data data){
        if(data.getSecondWord() == null) {
            System.out.println("работа с xml окончена");
            System.exit(0);
        }else{
            System.out.println("команда exit введена некорректно");
            Commander.getInstance().setCorrectCommand(false);
        }
    }
}
