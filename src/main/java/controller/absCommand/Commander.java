package controller.absCommand;

import controller.absCommand.command.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Commander {

    private static Commander INSTANCE;

    public static Commander getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Commander();
        }
        return INSTANCE;
    }
    private boolean correctCommand;

    public boolean isCorrectCommand() {
        return correctCommand;
    }

    public void setCorrectCommand(boolean correctCommand) {this.correctCommand = correctCommand;}


    public void useCommander(){
        History history=History.getInstance();
        history.setS();
        while(true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Введите команду");
                String ss = reader.readLine();
                String[] command = new String[0];
                int i = 1;
                while (true) {
                    try {
                        history.getS().add(ss);
                        if (i == 1) {
                            command = ss.split(" ");
                            castCommand(command);
                        }
                        i = 0;
                        if (command[0].equals("exit")&&command.length==1) {
                            reader.close();
                            castCommand(command);
                            System.exit(0);
                        }
                        System.out.println("Введите команду");
                        ss=reader.readLine();
                        command = ss.split(" ");
                        castCommand(command);
                    } catch (NullPointerException e) {
                        System.out.println("Введен EoF(символ конца ввода).");
                        reader = new BufferedReader(new InputStreamReader(System.in));
                    }
                }
            } catch (IOException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Введена пустая строка");
            }
        }
    }

    public static void castCommand( String[] command) {
        Developer developer = new Developer(new Exit(),new Save(),new Help(),new History(), new Info(), new Show(), new Insert(), new Clear(), new Script(), new NumOfWheels(), new PrintAscending(), new MinById(),new Update(), new RemoveKey(),new RemoveMin(),new RemoveMax());
        developer.loadMap();
        developer.castMap(command);
    }
}
