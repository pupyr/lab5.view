package controller.absCommand.command;

import controller.Data;
import controller.IO;
import controller.absCommand.AbsCommand;
import controller.absCommand.Commander;
import model.Root;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Save extends AbsCommand {

    @Override
    public void execute(Data data){
        if(data.getSecondWord() == null) {
            Root root=Root.getInstance();
            IO io=IO.getInstance();
            StringBuilder s = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<root>\n");
            s.append(root.write(1));
            s.append("\n").append("</root>");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(io.getName()))) {
                writer.write(String.valueOf(s));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("команда save введена некорректно");
            Commander.getInstance().setCorrectCommand(false);
        }

    }

}
