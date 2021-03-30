package org.matsim;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name="plans")
@XmlSeeAlso(ArrayList.class)
public class Plans {

    private List<Person> personList;

    public Plans(){

    }
    public Plans(List<Person> plan) {
        this.personList = plan;
    }

    @XmlElement(name="person")
    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plans plans = (Plans) o;
        return Objects.equals(personList, plans.personList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personList);
    }

    @Override
    public String toString() {
        return "Plans{" +
                "plan=" + personList +
                '}';
    }
}
