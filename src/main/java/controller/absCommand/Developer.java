package controller.absCommand;

import controller.Data;
import controller.absCommand.command.Script;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Developer
{
    static LinkedHashMap<String, IntCommand> map = new LinkedHashMap<>();
    public void loadMap() {
        map.put("clear", clear);
        map.put("help", help);
        map.put("history", history);
        map.put("info", info);
        map.put("insert", Insert);
        map.put("update", update);
        map.put("min_by_id", min);
        map.put("average_of_number_of_wheels", numOfWheels);
        map.put("print_ascending", print);
        map.put("remove_key", removeKey);
        map.put("remove_greater_key", removeMax);
        map.put("remove_lower_key", removeMin);
        map.put("save", save);
        map.put("show", show);
        map.put("execute_script", script);
        map.put("exit", exit);
    }
    public void castMap(String[] s){
        Data data=new Data();
        Data dataInstance=Data.getInstance();
        if(!Script.getInstance().isScriptStart())dataInstance.setScanner(new Scanner(System.in));
        Commander commander=Commander.getInstance();
        commander.setCorrectCommand(true);
        Script scriptSt=Script.getInstance();
        try{
            if(s.length==1){
                map.get(s[0]).execute(data);
            }
            else if(s.length==2) {
                data.setSecondWord(s[1]);
                map.get(s[0]).execute(data);
            }
            else{
                System.out.println("Введена несуществующая команда. Для справки введите help");
            }
            if(commander.isCorrectCommand()&& !scriptSt.isScriptStart()){
                System.out.println("команда успешно выполнена");
            }else if(!commander.isCorrectCommand()&& !scriptSt.isScriptStart()){
                commander.setCorrectCommand(true);}
        }catch (NullPointerException e){
            System.out.println("Введена несуществующая команда. Введите help для справки");
        }
    }
    IntCommand exit,save,help,Insert,history,info,show,clear,script,numOfWheels,print,min,update,removeKey,removeMin,removeMax;
    public Developer(IntCommand exit, IntCommand save, IntCommand help, IntCommand history, IntCommand info, IntCommand show, IntCommand Insert, IntCommand clear, IntCommand script, IntCommand numOfWheels, IntCommand print, IntCommand min,IntCommand update,IntCommand removeKey,IntCommand removeMin,IntCommand removeMax) {
        this.exit = exit;
        this.save = save;
        this.help = help;
        this.history = history;
        this.info = info;
        this.show = show;
        this.Insert = Insert;
        this.clear = clear;
        this.script = script;
        this.numOfWheels = numOfWheels;
        this.print = print;
        this.min = min;
        this.update = update;
        this.removeKey = removeKey;
        this.removeMin = removeMin;
        this.removeMax = removeMax;
    }
}
