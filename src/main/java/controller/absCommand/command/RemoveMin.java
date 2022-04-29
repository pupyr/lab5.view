package controller.absCommand.command;

import controller.Data;
import controller.absCommand.AbsCommand;
import controller.absCommand.IntCommand;

public class RemoveMin extends AbsCommand {

    @Override
    public void execute(Data data){
        data.setMinMax(true);
        IntCommand delete=new RemoveMinMax();
        delete.execute(data);
    }

}
