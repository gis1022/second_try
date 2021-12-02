package com.example.second_try;


import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxMyParser {

    public Boolean parce(){

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        }  catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        File file = new File("src/main/resources/Java_test.xml");
        try {
            parser.parse(file, handler);
        } catch (SAXException e) {
            System.out.println("Sax parsing error"+e.toString());
            return null;
        } catch (IOException e) {
            System.out.println("IO parsing error"+e.toString());
            return null;
        }
        return true;
    }
}
