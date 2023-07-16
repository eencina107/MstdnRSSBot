package com.edusinho.mstdnrssbot.rss.pojo.abc;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "atom:link")
public class AtomLink {
    private String href;
    private String rel;
    private String type;

    public AtomLink() {
    }

    @XmlAttribute(name = "href")
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @XmlAttribute(name = "rel")
    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    @XmlAttribute(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
