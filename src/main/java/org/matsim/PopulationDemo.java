package org.matsim;


import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PopulationDemo {

    public static void main(String[] args) throws JAXBException {
        ArrayList<Persons> data =ReadData.readFile();
//        for(Persons persons : data){
//            Person p = persons.getPerson();
//            System.out.println(p.id + " "+ p.employed);
//        }
        try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            // root element
            Element root = document.createElement("plans");
            document.appendChild(root);

            for(Persons persons : data){
                Person p = persons.getPerson();
                Plan pl = persons.plan;
                // person element
                Element person = document.createElement("person");
                root.appendChild(person);

                person.setAttribute("id", p.id);
                person.setAttribute("employed", p.employed);

                Element plan = document.createElement("plan");
//                plan.setAttribute("Selected", "yes");
                person.appendChild(plan);

                Element act = document.createElement("act");
                act.setAttribute("type", "h");
                act.setAttribute("x", pl.acts[0].y);
                act.setAttribute("y",pl.acts[0].x);
                act.setAttribute("end_time",pl.acts[0].end_time);
                plan.appendChild(act);



                Element leg = document.createElement("leg");
                leg.setAttribute("mode", pl.legs[0].mode);
//                leg.setAttribute("dept_time", pl.legs[0].dep_time);
//                leg.setAttribute("trav_time", pl.legs[0].trav_time);
//                leg.setAttribute("arri_time", pl.legs[0].arr_time);
                plan.appendChild(leg);

                Element act1 = document.createElement("act");
                act1.setAttribute("type", "w");
                act1.setAttribute("x", pl.acts[1].y);
                act1.setAttribute("y",pl.acts[1].x);
                act1.setAttribute("start_time",pl.acts[1].start_time);
                act1.setAttribute("end_time",pl.acts[1].end_time);
                plan.appendChild(act1);

//                Element route = document.createElement("route");
//                route.setAttribute("route_number", pl.legs[0].route.routeNumber);
//                route.setAttribute("trav_time", pl.legs[0].route.trav_time);
//                leg.appendChild(route);

                Element leg1 = document.createElement("leg");
                leg1.setAttribute("mode", pl.legs[1].mode);
//                leg1.setAttribute("dept_time", pl.legs[1].dep_time);
//                leg1.setAttribute("trav_time", pl.legs[1].trav_time);
//                leg1.setAttribute("arri_time", pl.legs[1].arr_time);
                plan.appendChild(leg1);

//                Element route1 = document.createElement("route");
//                route1.setAttribute("route_number", pl.legs[1].route.routeNumber);
//                route1.setAttribute("trav_time", pl.legs[1].route.trav_time);
//                leg1.appendChild(route1);

                Element act2 = document.createElement("act");
                act2.setAttribute("type", "h");
                act2.setAttribute("x", pl.acts[2].y);
                act2.setAttribute("y",pl.acts[2].x);
                act2.setAttribute("start_time",pl.acts[2].end_time);
                plan.appendChild(act2);

            }

            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("./test.xml"));

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating XML File");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
//    }
//        Plans rootelement = new Plans(new ArrayList<>());
//        for(Map<String,String> map: data){
//
//            Route route = new Route(map.get("distance"),map.get("trav_time"),map.get("routeNumber"));
//            Leg leg = new Leg(map.get("mode"),map.get("Dept_Time"),map.get("Trav_Time"),map.get("Arri_Time"),map.get("routeNumber"));
//            Leg leg1 = new Leg(map.get("mode"),map.get("Dept_time_1"),map.get("Trav_Time_1"),map.get("Arri_Time_1"),map.get("routeNumber_1"));
//            Act act = new Act(map.get("purpose"),map.get("type"),map.get("routeNumber"),map.get("Long"),map.get("Lat"),map.get("Dept_time"));
//            Plan plan = new Plan(Arrays.asList(act),Arrays.asList(leg,leg1));
//            Person person = new Person(map.get("id"),map.get("Occupation"),plan);
//            rootelement.getPersonList().add(person);
//        }
//        JAXBContext context = JAXBContext.newInstance(Plans.class);
//        Marshaller m = context.createMarshaller();
//        // Write to System.out
//        m.marshal(rootelement, System.out);
//        String BOOKSTORE_XML = "./test.xml";
//        // Write to File
//        m.marshal(rootelement, new File(BOOKSTORE_XML));
    }


}