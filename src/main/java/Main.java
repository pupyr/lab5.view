import test.ParserJackson;

public class Main {
    public static void main(String[] args) {

        /*try {
            IO io = new IO();
            io.input(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Введите имя файла в командную строку");
        }*/


        ParserJackson parserJackson=new ParserJackson();
        parserJackson.parse();


    }
}
