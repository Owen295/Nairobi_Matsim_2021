package org.matsim;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlRootElement
public class Plan {

    Act [] acts = new Act[2];
    Leg [] legs = new Leg[2];

    public Plan() {
    }

    public Plan ( Act [] acts,  Leg [] legs ) {
        this.acts = acts;
        this.legs = legs;
    }
    @XmlElement
    public  Act [] getAct() {
        return acts;
    }

    public void setAct( Act [] act) {
        this.acts = act;
    }

    public Leg [] getLegs() {
        return legs;
    }
    @XmlElement
    public void setLegs( Leg [] legs) {
        this.legs = legs;
    }



    @Override
    public String toString() {
        return "Plan{" +
                "act=" + acts +
                ", legs=" + legs +
                '}';
    }
}
