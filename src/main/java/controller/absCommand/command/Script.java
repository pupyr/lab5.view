package controller.absCommand.command;

import controller.Data;
import controller.absCommand.AbsCommand;
import controller.absCommand.Commander;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Script extends AbsCommand {

    /**
     * scriptStart- переменная, проверяющая, работает ли скрипт
     * (каждая команда после своего выполнения выводит "команда успешно выполнена",
     * чтобы во время скрипта эта строка не выводилась, и нужна эта переменная)
     * recursion- переменная, сигнализирующая о рекурсии
     * inner- переменная, сигнализирующая о вложенности
     * scriptName- массив, хранящий названия скриптов, которые вызывались по ходу выполнения команды
     * (требуется для проверки рекурсии)
     * i- переменная, показывающая уровни вложенности
     */
    private static Script Instance;

    public static Script getInstance() {
        if (Instance == null) {
            Instance = new Script();
        }
        return Instance;
    }

    private boolean correctScript=true;
    private boolean scriptStart =false;
    private boolean recursion=false;
    private boolean inner=false;
    private List<String> scriptName=new ArrayList<>();
    private int i=1;

    public boolean isCorrectScript() {
        return correctScript;
    }

    public void setCorrectScript(boolean correctScript) {
        this.correctScript = correctScript;
    }

    public boolean isRecursion() {
        return !recursion;
    }

    public void setRecursion(boolean recursion) {
        this.recursion = recursion;
    }

    public boolean isInner() {
        return inner;
    }

    public void setInner(boolean inner) {
        this.inner = inner;
    }

    public List<String> getScriptName() {
        return scriptName;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setScriptName() {
        scriptName = new ArrayList<>();
    }

    public boolean isScriptStart() {
        return scriptStart;
    }

    public void setScriptStart(boolean scriptStart) {
        this.scriptStart=scriptStart;
    }

    @Override
    public void execute(Data data) {
        Script script=getInstance();
        Data dataInstance=Data.getInstance();
        try (Scanner scanner = new Scanner(new FileReader("src/main/resources/"+data.getSecondWord()))) {
            dataInstance.setScanner(scanner);
            script.setScriptStart(true);
            script.getScriptName().add(data.getSecondWord());
            while (scanner.hasNext() && script.isRecursion()) {
                String[] ss = scanner.nextLine().split(" ");
                if(ss[0].equals("execute_script")) {
                    script.setI(script.getI() + 1);
                    script.setInner(true);
                }
                checkRecursion(ss);
                if (script.isRecursion()) {
                    Commander.castCommand(ss);
                }
            }
            checkEndOfScript();
        }
        catch (FileNotFoundException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Введено неверное имя файла");
        }
    }

    public void checkRecursion(String[] ss){
        Script script=getInstance();
        for ( String q : script.getScriptName()) {
            if (ss.length > 1 && q.equals(ss[1])) {
                System.out.println("в файле есть рекурсия");
                script.setRecursion(true);
                script.setI(script.getI()-1);
                break;
            }
        }
    }

    public void checkEndOfScript(){
        Script script=getInstance();
        if(script.isInner()){
            script.setI(script.getI()-1);
        }else{
            if(getInstance().isCorrectScript())System.out.println("скрипт выполнен");
            getInstance().setCorrectScript(true);
            setScriptStart(false);
            setScriptName();
        }
        if (script.isInner()&&script.getI()==0){
            setScriptStart(false);
            script.setI(1);
            script.setInner(false);
            if(script.isRecursion())System.out.println("скрипт выполнен");
            setCorrectScript(true);
            script.setRecursion(false);
            setScriptName();
        }
    }


}
