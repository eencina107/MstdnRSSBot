package com.edusinho.mstdnrssbot.rss.pojo.abc;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class Item {
    private String title;
    private String link;
    private String guid;
    private String creator;
    private String description;
    private String pubDate;
    private String contentEncoded;
    private String mediaContentUrl;
    private String mediaDescription;
    private String mediaCredit;

    public Item() {
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

    @XmlElement(name = "guid")
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @XmlElement(name = "creator", namespace = "http://purl.org/dc/elements/1.1/")
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name = "pubDate")
    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    @XmlElement(name = "encoded", namespace = "http://purl.org/rss/1.0/modules/content/")
    public String getContentEncoded() {
        return contentEncoded;
    }

    public void setContentEncoded(String contentEncoded) {
        this.contentEncoded = contentEncoded;
    }

    @XmlElement(name = "content", namespace = "http://search.yahoo.com/mrss/")
    public String getMediaContentUrl() {
        return mediaContentUrl;
    }

    public void setMediaContentUrl(String mediaContentUrl) {
        this.mediaContentUrl = mediaContentUrl;
    }

    @XmlElement(name = "description", namespace = "http://search.yahoo.com/mrss/")
    public String getMediaDescription() {
        return mediaDescription;
    }

    public void setMediaDescription(String mediaDescription) {
        this.mediaDescription = mediaDescription;
    }

    @XmlElement(name = "credit", namespace = "http://search.yahoo.com/mrss/")
    public String getMediaCredit() {
        return mediaCredit;
    }

    public void setMediaCredit(String mediaCredit) {
        this.mediaCredit = mediaCredit;
    }
}
