package controller;

import controller.absCommand.Commander;
import controller.absCommand.IntCommand;
import controller.absCommand.command.Save;
import controller.pars.Parser;
import model.Root;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IO
{

    private static IO INSTANCE;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static IO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new IO();
        }
        return INSTANCE;
    }

    public void input(String s) {
        Commander commander=Commander.getInstance();
        fileCreator(s);
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(Paths.get(getInstance().getName())))){
            Parser parser=new Parser();
            parser.pars(bufferedInputStream);
            Root root= Root.getInstance();
            root.sorting(true);
            commander.useCommander();
        } catch (IOException e) {
            System.out.println("В файле некорректные данные");
        }
    }

    public void fileCreator(String s){
        IO io=getInstance();
        if(!s.endsWith(".xml")){s+=".xml";}
        io.setName("src/main/resources/"+s);
        File file=new File(io.getName());
        try {
            if(file.createNewFile()){
                System.out.println("Файл с указанным именем не найден. Создан новый файл");
                IntCommand save=new Save();
                save.execute(new Data());
            }
        } catch (IOException e) {
            System.out.println("В файле некорректные данные");
        }
    }

}
