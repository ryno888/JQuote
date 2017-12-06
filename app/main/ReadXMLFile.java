/*
 * Class 
 * @filename ReadXMLFile 
 * @encoding UTF-8
 * @author Liquid Edge Solutions  * 
 * @copyright Copyright Liquid Edge Solutions. All rights reserved. * 
 * @programmer Ryno van Zyl * 
 * @date 06 Dec 2017 * 
 */
package app.main;

import core.com.utils.ComDirectory;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

/**
 *
 * @author Ryno
 */
public class ReadXMLFile {

    public static void read() {
        try {

            File fXmlFile = new File(ComDirectory.get_base_dir()+"/config.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("databse");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("dbdriver : " + eElement.getElementsByTagName("dbdriver").item(0).getTextContent());
                    System.out.println("dburl : " + eElement.getElementsByTagName("dburl").item(0).getTextContent());
                    System.out.println("dbname : " + eElement.getElementsByTagName("dbname").item(0).getTextContent());
                    System.out.println("dbuser : " + eElement.getElementsByTagName("dbuser").item(0).getTextContent());
                    System.out.println("dbpassword : " + eElement.getElementsByTagName("dbpassword").item(0).getTextContent());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
