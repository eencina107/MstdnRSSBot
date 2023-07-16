/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.edusinho.mstdnrssbot;

import com.edusinho.mstdnrssbot.rss.pojo.abc.Item;
import com.edusinho.mstdnrssbot.rss.pojo.abc.Rss;
import com.edusinho.mstdnrssbot.utils.mastodon.impl.MastodonUtilImpl;
import com.edusinho.mstdnrssbot.utils.rss.RssReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import mastodon4j.domain.Service;

/**
 *
 * @author user
 */
public class MstdnRSSBot {

    public static void main(String[] args) {
        System.out.println("Hello World! Starting bot...");

        System.out.println("Accesing Mastodon...");
        MastodonUtilImpl mastAccount = new MastodonUtilImpl();

        //Next step for this line: take data from properties file
        mastAccount.login(Service.MASTODON, "https://mastodon.social", "");

        int statusIterator =0;
        Map<String, String> publishedStatusMap = new HashMap();
        
        
        while (true) {
            
            
            
            System.out.println("Reading RSS from uri...");
            RssReader reader = new RssReader();
            Rss rssMain = reader.getRssObjectFromUrl("https://www.abc.com.py/arc/outboundfeeds/rss/nacionales/?outputType=xml");
            
            
            
            int itemCount = rssMain.getChannel().getItems().length;
            System.out.println("Getting count of the items to publish... " + itemCount);

            int millisBetweenToots = 3600000 / itemCount;
            System.out.println("Calculating time elapsed between toots... " + millisBetweenToots);

            for (int i = 0; i < itemCount; i++) {
                String isOnline = mastAccount.isOnline();
                Item actualItem = rssMain.getChannel().getItems()[i];
                if (isOnline.equals("")) {
                    System.out.println("Error accessing account. Trying again...");
                    i--;
                } else {
                    StringBuilder sbPublicacion = new StringBuilder();
                    sbPublicacion.append(actualItem.getTitle());
                    sbPublicacion.append("\n");
                    sbPublicacion.append(actualItem.getLink());
                    if (!publishedStatusMap.containsKey(actualItem.getPubDate())) {
                        mastAccount.publish(sbPublicacion.toString(), "public");
                        publishedStatusMap.put(actualItem.getPubDate(), sbPublicacion.toString());
                    }
                    else {
                        System.out.println("Title - "+sbPublicacion.toString()+" is published yet");
                        System.out.println();
                    }

                }
                System.out.println("Waiting " + millisBetweenToots + " milliseconds before publish");
                try {
                    Thread.sleep(millisBetweenToots);
                } catch (InterruptedException ex) {
                    System.out.println("Exception in sleep: " + ex.getMessage());
                }
            }

        }
    }
    
   
}
