package controller.absCommand.command;


import controller.Data;
import controller.absCommand.AbsCommand;
import controller.absCommand.Commander;
import model.Root;

public class NumOfWheels extends AbsCommand
{
    @Override
    public void execute(Data data) {
        if(data.getSecondWord() == null) {
            Root root=Root.getInstance();
            float f = 0.0f;
            int i = 0;
            for (Long l : root.getRoot().keySet()) {
                if (root.getRoot().get(l).getNumberOfWheels() != null) {
                    f += root.getRoot().get(l).getNumberOfWheels();
                    ++i;
                }
            }
            System.out.println(f / i);
        }else{
            System.out.println("команда average_of_number_of_wheels введена некорректно");
            Commander.getInstance().setCorrectCommand(false);
        }

    }
}
