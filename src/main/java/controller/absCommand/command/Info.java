package controller.absCommand.command;

import controller.Data;
import controller.absCommand.AbsCommand;
import controller.absCommand.Commander;
import model.Root;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Info extends AbsCommand {
    @Override
    public void execute(Data data) {
        if(data.getSecondWord() == null) {
            Root root=Root.getInstance();
            DateFormat df = new SimpleDateFormat("dd MMM yyy HH:mm:ss");
            System.out.println("Тип коллекции-" + root.getRoot().getClass() + "\nДата инициализации-" + df.format(root.getDate()) + "\nКол-во элементов-" + root.getRoot().size());
        }else{
            System.out.println("команда info введена некорректно");
            Commander.getInstance().setCorrectCommand(false);
        }
            }
}
