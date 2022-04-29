package controller.absCommand.command;

import controller.Data;
import controller.absCommand.AbsCommand;
import controller.absCommand.Commander;
import model.Root;
import java.util.Iterator;

public class RemoveMinMax extends AbsCommand implements Iterator<Long>
{
    int index=0;
    Long i;
    int size;
    boolean b;

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    public Long next() {
        Root root=Root.getInstance();
        b=true;
        while (b) {
            ++i;
            for ( Long l : root.getRoot().keySet()) {
                if (l.equals(i)) {
                    b=false;
                    ++index;
                    break;
                }
            }
        }
        return i;
    }

    @Override
    public void remove() {
        Root root=Root.getInstance();
        root.getRoot().remove(i);
    }

    @Override
    public void execute(Data data/*String s,  String ss*/) {
        Root root=Root.getInstance();
        Commander commander=Commander.getInstance();
        long l;
        try {
            l = Long.parseLong(data.getSecondWord());
            index = 0;
            i = 0L;
            size = root.getRoot().size();
            if (data.isMinMax()) {
                while (hasNext()) {
                    if (l > next()) {
                        remove();
                    }
                }
            }
            else {
                while (hasNext()) {
                    if (l < next()) {
                        remove();
                    }
                }
            }
        }catch(ArrayIndexOutOfBoundsException|NumberFormatException e) {
                System.out.println("Введен неверный ключ");
                commander.setCorrectCommand(false);
        }
    }
}
