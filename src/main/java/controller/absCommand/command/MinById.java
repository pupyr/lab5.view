package controller.absCommand.command;

import controller.Data;
import controller.absCommand.AbsCommand;
import controller.absCommand.Commander;
import model.Root;

public class MinById extends AbsCommand
{
    @Override
    public void execute(Data data) {
        if(data.getSecondWord() == null) {
            Root root=Root.getInstance();
            if (root.getRoot().size() > 0) {
                Long[] L = root.getRoot().keySet().toArray(new Long[0]);
                Long l0 = L[0];
                for (Long i : root.getRoot().keySet()) {
                    if (l0 > i) {
                        l0 = i;
                    }
                }
                System.out.println(root.getRoot().get(l0).write(0));
            }
            else {
                System.out.println("Список пуст");
            }
        }else{
            System.out.println("команда min_by_id введена некорректно");
            Commander.getInstance().setCorrectCommand(false);
        }

    }
}
