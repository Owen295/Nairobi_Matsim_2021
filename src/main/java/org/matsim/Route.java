package org.matsim;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.Objects;
@XmlRootElement
public class Route {

    String dist;
    String trav_time;
    String routeNumber;

    public Route(){

    }
    public Route( String trav_time, String routeNumber) {

        this.trav_time = trav_time;
        this.routeNumber = routeNumber;
    }

    @XmlAttribute
    public String getTrav_time() {
        return trav_time;
    }

    public void setTrav_time(String trav_time) {
        this.trav_time = trav_time;
    }

    @XmlValue
    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(dist, route.dist) &&
                Objects.equals(trav_time, route.trav_time) &&
                Objects.equals(routeNumber, route.routeNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dist, trav_time, routeNumber);
    }

    @Override
    public String toString() {
        return "Route{" +
                "dist='" + dist + '\'' +
                ", trav_time='" + trav_time + '\'' +
                ", routeNumber='" + routeNumber + '\'' +
                '}';
    }

}
