package org.matsim;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Act {

     String type;
     String purpose;
     String link;
     String x;
     String y;
     String start_time;
     String end_time;

    public Act() {
    }

    public Act(String x, String y, String end_time) {
        this.x = x;
        this.y = y;
        this.end_time = end_time;
    }
    public Act(String x, String y,String start_time, String end_time) {
        this.x = x;
        this.y = y;
        this.start_time = start_time;
        this.end_time = end_time;
    }


    @XmlAttribute
    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @XmlAttribute
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @XmlAttribute
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    @XmlAttribute
    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }
    @XmlAttribute
    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
    @XmlAttribute
    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Act act = (Act) o;
        return Objects.equals(type, act.type) &&
                Objects.equals(link, act.link) &&
                Objects.equals(x, act.x) &&
                Objects.equals(y, act.y) &&
                Objects.equals(end_time, act.end_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, link, x, y, end_time);
    }

    @Override
    public String toString() {
        return "Act{" +
                "type='" + type + '\'' +
                ", link='" + link + '\'' +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", end_time='" + end_time + '\'' +
                '}';
    }
}
