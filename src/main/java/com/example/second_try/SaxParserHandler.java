package com.example.second_try;

import com.example.second_try.controllers.TransactionController;
import com.example.second_try.entity.ClientEntity;
import com.example.second_try.entity.TransactionEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;


public class SaxParserHandler extends DefaultHandler {

    private TransactionController controller;

    public SaxParserHandler() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        controller = (TransactionController) context.getBean("transControl");
    }

    private String currentTagName;
    private static final String TAG_TRANSACTION = "transaction";
    private static final String TAG_PLACE = "place";
    private static final String TAG_CURRENCY = "currency";
    private static final String TAG_AMOUNT = "amount";
    private static final String TAG_CARD = "card";
    private static final String TAG_CLIENT = "client";
    private static final String TAG_FIRSTNAME = "firstName";
    private static final String TAG_LASTNAME = "lastName";
    private static final String TAG_MIDDLENAME = "middleName";
    private static final String TAG_INN = "inn";
    private int index;

    private ArrayList<TransactionEntity> transactionsList =new ArrayList<TransactionEntity>();
    private ArrayList<ClientEntity> clientEntitySet = new ArrayList<ClientEntity>();
    private String place=null;
    private Double amount=null;
    private String currency=null;
    private String card=null;
    private String firstName;
    private String lastName;
    private String middleName;
    private String inn;


    @Override
    public void startDocument() throws SAXException {
        index = 0;
    }

    @Override
    public void endDocument() throws SAXException {
    controller.setList(transactionsList, clientEntitySet);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTagName = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals(TAG_TRANSACTION)){
            transactionsList.add(index, new TransactionEntity(place, amount, currency,card, inn));
            index++;
        } else if (qName.equals(TAG_CLIENT)){
            clientEntitySet.add(new ClientEntity(firstName, lastName,middleName,inn));
        }
        currentTagName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (currentTagName != null) {
            switch (currentTagName) {
                case TAG_AMOUNT:
                    amount = Double.valueOf(new String(ch, start, length));
                    break;
                case TAG_CARD:
                    card = new String(ch, start, length);
                    break;
                case TAG_PLACE:
                    place = new String(ch, start, length);
                    break;
                case TAG_CURRENCY:
                    currency = new String(ch, start, length);
                    break;
                case TAG_FIRSTNAME:
                    firstName = new String(ch, start, length);
                    break;
                case TAG_LASTNAME:
                    lastName = new String(ch, start, length);
                    break;
                case TAG_MIDDLENAME:
                    middleName = new String(ch, start, length);
                    break;
                case TAG_INN:
                    inn = new String(ch, start, length);
                    break;

            }
        }

    }
}
