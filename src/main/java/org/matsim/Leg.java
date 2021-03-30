package org.matsim;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Leg {
    String mode;
    String dep_time;
    String trav_time;
    String arr_time;
    Route route;

    public Leg() {
    }

    public Leg(String mode, String dep_time, String trav_time, String arr_time, Route route) {
        this.mode = mode;
        this.dep_time = dep_time;
        this.trav_time = trav_time;
        this.arr_time = arr_time;
        this.route = route;
    }

    @XmlElement
    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @XmlAttribute
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @XmlAttribute
    public String getDep_time() {
        return dep_time;
    }

    public void setDep_time(String dep_time) {
        this.dep_time = dep_time;
    }

    @XmlAttribute
    public String getTrav_time() {
        return trav_time;
    }

    public void setTrav_time(String trav_time) {
        this.trav_time = trav_time;
    }

    @XmlAttribute
    public String getArr_time() {
        return arr_time;
    }

    public void setArr_time(String arr_time) {
        this.arr_time = arr_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leg leg = (Leg) o;
        return Objects.equals(mode, leg.mode) &&
                Objects.equals(dep_time, leg.dep_time) &&
                Objects.equals(trav_time, leg.trav_time) &&
                Objects.equals(arr_time, leg.arr_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mode, dep_time, trav_time, arr_time);
    }

    @Override
    public String toString() {
        return "Leg{" +
                "mode='" + mode + '\'' +
                ", dep_time='" + dep_time + '\'' +
                ", trav_time='" + trav_time + '\'' +
                ", arr_time='" + arr_time + '\'' +
                '}';
    }
}
