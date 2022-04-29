package controller.absCommand.command;

import controller.Data;
import controller.absCommand.AbsCommand;
import controller.absCommand.Commander;

import java.util.ArrayList;

public class History extends AbsCommand {

    private static History INSTANCE;

    private ArrayList<String> s;

    public void setS() {
        s=new ArrayList<>();
    }

    public ArrayList<String> getS() {
        return s;
    }

    public static History getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new History();
        }
        return INSTANCE;
    }


    @Override
    public void execute(Data data){
        if(data.getSecondWord() == null) {
            for (int i = getInstance().getS().size(); i>=0 && i > getInstance().getS().size()-6; --i) {
            if(getInstance().getS().size()>i)System.out.println(getInstance().getS().get(i));
        }
        }else{
            System.out.println("команда history введена некорректно");
            Commander.getInstance().setCorrectCommand(false);
        }

    }
}
