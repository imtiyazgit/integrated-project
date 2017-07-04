package com.accion.labs.test1;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by imtiyaz on 7/4/17.
 */
public class XmlOperations {

    public static void main(String[] args) {
        try {
            File fXmlFile = new File("core-java/src/main/resources/test1.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("transaction");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    printItemInfo(eElement.getAttribute("item"), eElement.getAttribute("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void printItemInfo(String item, String amount) throws IOException {
        int amt = 0;
        if (amount.endsWith("$")) {
            amt = Integer.parseInt(amount.substring(0, amount.length() - 1)) * 100;
        } else {
            amt = Integer.parseInt(amount.substring(0, amount.length() - 1));
        }
        String denom = Denominations.find(Optional.of(amt));
        System.out.println(item + " " + denom);
    }


}
