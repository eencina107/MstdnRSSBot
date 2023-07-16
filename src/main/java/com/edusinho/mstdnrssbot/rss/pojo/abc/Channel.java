package com.edusinho.mstdnrssbot.rss.pojo.abc;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "channel")
@XmlType(propOrder = { "title", "link", "atomLink", "description", "lastBuildDate", "language", "copyright", "ttl", "updatePeriod", "updateFrequency", "items" })
public class Channel {
    private String title;
    private String link;
    private AtomLink atomLink;
    private String description;
    private String lastBuildDate;
    private String language;
    private String copyright;
    private String ttl;
    private String updatePeriod;
    private String updateFrequency;
    private Item[] items;

    public Channel() {
    }

    @XmlElement(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement(name = "link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @XmlElement(name = "atom:link", namespace = "http://www.w3.org/2005/Atom")
    public AtomLink getAtomLink() {
        return atomLink;
    }

    public void setAtomLink(AtomLink atomLink) {
        this.atomLink = atomLink;
    }

    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name = "lastBuildDate")
    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    @XmlElement(name = "language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @XmlElement(name = "copyright")
    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @XmlElement(name = "ttl")
    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    @XmlElement(name = "updatePeriod", namespace = "http://purl.org/rss/1.0/modules/syndication/")
    public String getUpdatePeriod() {
        return updatePeriod;
    }

    public void setUpdatePeriod(String updatePeriod) {
        this.updatePeriod = updatePeriod;
    }

    @XmlElement(name = "updateFrequency", namespace = "http://purl.org/rss/1.0/modules/syndication/")
    public String getUpdateFrequency() {
        return updateFrequency;
    }

    public void setUpdateFrequency(String updateFrequency) {
        this.updateFrequency = updateFrequency;
    }

     public Item[] getItems() {
        return items;
    }

    @XmlElement(name = "item")
    public void setItems(Item[] items) {
        this.items = items;
    }
}
