package com.example.fujitsu;

import com.example.fujitsu.model.Weather;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
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
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class FujitsuApplication {

	//Logger logger = (Logger) LoggerFactory.getLogger(FujitsuApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FujitsuApplication.class, args);
	}

	@Scheduled(fixedDelayString = "PT1H", initialDelay = 2000L)
	public void ScheduleHourly() throws InterruptedException {
		//logger.info("Current time" + new Date());
		Thread.sleep(59*60*1000);
	}

	public static List<Weather> XMLParser() {

		List<Weather> weatherList = new ArrayList<>();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document document = builder.parse(new File("https://www.ilmateenistus.ee/ilma_andmed/xml/observations.php"));

			document.getDocumentElement().normalize();

			NodeList stationList = document.getElementsByTagName("station");

			for (int i = 0; i < stationList.getLength(); i++) {
				Node station = stationList.item(i);

				if (station.getNodeType() == Node.ELEMENT_NODE) {
					NodeList stationDetails = station.getChildNodes();

					for (int j = 0; j < stationDetails.getLength(); j++) {
						Node detail = stationDetails.item(j);
						if (detail.getNodeType() == Node.ELEMENT_NODE) {
							Element detailElement = (Element) detail;
							Weather weather = new Weather(null, detailElement.getAttribute("name"), Long.parseLong(detailElement.getAttribute("wmocode")), Double.parseDouble(detailElement.getAttribute("temperature")), Double.parseDouble(detailElement.getAttribute("windSpeed")), detailElement.getAttribute("phenomenon"));
							weatherList.add(weather);
						}

					}
				}
			}

		} catch (ParserConfigurationException | IOException | SAXException e) {
			throw new RuntimeException(e);
		}
		return weatherList;
	}





}
