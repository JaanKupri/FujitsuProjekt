package com.example.fujitsu;

import com.example.fujitsu.model.AirConditions;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLParser {



    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File("https://www.ilmateenistus.ee/ilma_andmed/xml/observations.php"));

            document.getDocumentElement().normalize();

            NodeList stationList = document.getElementsByTagName("station");

            for (int i = 0; i < stationList.getLength(); i++) {
                Node station = stationList.item(i);

                if (station.getNodeType() == Node.ELEMENT_NODE) {
                    //Element stationElement = (Element) station;
                    NodeList stationDetails = station.getChildNodes();

                    for (int j = 0; j < stationDetails.getLength(); j++) {
                        Node detail = stationDetails.item(j);
                        if (detail.getNodeType() == Node.ELEMENT_NODE) {
                            Element detailElement = (Element) detail;
                            AirConditions airConditions = new AirConditions(detailElement.getAttribute("name"), Long.parseLong(detailElement.getAttribute("wmocode")), Double.parseDouble(detailElement.getAttribute("airtemperature")), Double.parseDouble(detailElement.getAttribute("windspeed")), detailElement.getAttribute("phenomenon"));
                        }

                    }
                }
            }

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

    }
}