/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusinho.mstdnrssbot.utils.rss;

import com.edusinho.mstdnrssbot.rss.pojo.abc.Rss;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author user
 */
public class RssReader {
    public RssReader(){
        
    }
    
    public Rss getRssObjectFromUrl(String url){
        String rssUrl = url; // Replace with the actual RSS URL
        Rss rssResult= new Rss();
        
        try {
            // Create the JAXBContext for the target POJO class
            JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);

            // Create the Unmarshaller
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Open a connection to the RSS URL
            HttpURLConnection connection = (HttpURLConnection) new URL(rssUrl).openConnection();
            connection.setRequestMethod("GET");

            // Retrieve the XML data from the RSS URL
            InputStream inputStream = connection.getInputStream();

            // Deserialize the XML data into the POJO object
            rssResult = (Rss) unmarshaller.unmarshal(inputStream);

            // Process the deserialized POJO object as needed
            // ...

            // Close the input stream and connection
            inputStream.close();
            connection.disconnect();
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        
        return rssResult;
    }
}
