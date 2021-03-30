package org.matsim;

public class Persons {

    Person person;
    Act act ;
    Plan plan;
    Leg leg;
    Route route;

    public Persons(Person person, Act act, Plan plan, Leg leg, Route route) {
        this.person = person;
        this.act = act;
        this.plan = plan;
        this.leg = leg;
        this.route = route;
    }

    public Person getPerson() {
        return person;
    }

    public Act getAct() {
        return act;
    }

    public Plan getPlan() {
        return plan;
    }

    public Leg getLeg() {
        return leg;
    }

    public Route getRoute() {
        return route;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setAct(Act act) {
        this.act = act;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "person=" + person.toString() +
                ", act=" + act.toString() +
                ", plan=" + plan.toString() +
                ", leg=" + leg.toString() +
                ", route=" + route.toString() +
                '}';
    }

    //    String location , id, date, trav_time, dept_time, arri_time , time,
//            type_of_vehicle, get_on_get_off,sex, age, occupation, monthly_income, longi, lat , route_number , stop_id , long_1 , lat_1, route_number_1, stop_id_1, trav_time_1, dept_time_1, arri_time_1 ;
}
