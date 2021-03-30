package org.matsim;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
@XmlRootElement
public class Person {

String id;

String employed;

Plan plan;

    public Person() {
    }

    public Person(String id, String employed, Plan plan) {
        this.id = id;
        this.employed = employed;
        this.plan = plan;
    }

    @XmlAttribute(name="id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlAttribute(name="employed")
    public String getEmployed() {
        return employed;
    }

    public void setEmployed(String employed) {
        this.employed = employed;
    }

    @XmlElement(name="plan")
    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(employed, person.employed) &&
                Objects.equals(plan, person.plan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employed, plan);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", employed='" + employed + '\'' +
                ", plan=" + plan.toString() +
                '}';
    }
}
