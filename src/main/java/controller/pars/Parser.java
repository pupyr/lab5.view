package controller.pars;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedInputStream;
import java.io.IOException;

public class Parser {


        //XmlMapper mapper = new XmlMapper();
        //s=mapper.readValue(src, Simples.class);


    public void pars(BufferedInputStream bufferedInputStream) {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            parser.parse(bufferedInputStream, handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("В файле неверные данные. Файл будет перезаписан, если вы введете команду save");
        }

    }

}
