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
        new XmlOperations().execute("core-java/src/main/resources/test1.xml");
    }

    public void execute(String file) {
        try {
            XmlOperations xmlOperations = new XmlOperations();
            NodeList nList = xmlOperations.readXmlNodes(file);
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String result = printItemInfo(eElement.getAttribute("item"), eElement.getAttribute("amount"));
                    System.out.println(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public NodeList readXmlNodes(String file) throws Exception {
        File fXmlFile = new File(file);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName("transaction");
    }

    public String printItemInfo(String item, String amount) throws IOException {
        int amt;
        if (amount.endsWith("$")) {
            amt = Integer.parseInt(amount.substring(0, amount.length() - 1)) * 100;
        } else {
            amt = Integer.parseInt(amount.substring(0, amount.length() - 1));
        }
        String denom = Denominations.find(Optional.of(amt));
        return item + " " + denom;
    }


}
