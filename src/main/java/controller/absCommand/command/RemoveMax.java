package controller.absCommand.command;

import controller.Data;
import controller.absCommand.AbsCommand;
import controller.absCommand.IntCommand;

public class RemoveMax extends AbsCommand {

    @Override
    public void execute(Data data){
        data.setMinMax(false);
        IntCommand delete=new RemoveMinMax();
        delete.execute(data);
    }

}
