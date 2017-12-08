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

import core.com.string.ComString;
import core.com.utils.ComDirectory;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

/**
 *
 * @author Ryno
 */
public class ReadXMLFile {

    public static HashMap<String, String> read() {
		HashMap <String, String> result = new HashMap();
        try {
            File fXmlFile = new File(ComDirectory.get_base_dir()+"/config.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("databse");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
					result.put("dbdriver", eElement.getElementsByTagName("dbdriver").item(0).getTextContent());
					result.put("dburl", eElement.getElementsByTagName("dburl").item(0).getTextContent());
					result.put("dbname", eElement.getElementsByTagName("dbname").item(0).getTextContent());
					result.put("dbuser", eElement.getElementsByTagName("dbuser").item(0).getTextContent());
					result.put("dbpassword", ComString.decrypt(eElement.getElementsByTagName("dbpassword").item(0).getTextContent()));
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException | DOMException e) {
            e.printStackTrace();
        }
		
		return result;
    }
    
}
