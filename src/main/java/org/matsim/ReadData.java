package org.matsim;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadData {

    ArrayList<Persons> persons = new ArrayList<>();
    public static ArrayList<Persons> readFile() {
        ReadData readData = new ReadData();
        String execlfolder = "H:\\Masters_Transport\\CIV5109Z Dissertation Preparation\\Nairobi Transport Diary_2013\\JICA\\";
        try {
            FileInputStream file = new FileInputStream(new File(execlfolder + "Nairobi_Travel_Diary_2013_Demo_DN.xlsx"));
            // Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            // Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            boolean bool_row_one = true;
            ArrayList<String> headers = new ArrayList<>();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                if(bool_row_one) {
                    //get headers and go to next row instead
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        headers.add(cell.getStringCellValue());
                    }
                    bool_row_one = false;
                    rowIterator.next();
                }
                else {
                    ArrayList<String> row_data = new ArrayList<>();
                    int count = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        DataFormatter dataFormatter = new DataFormatter();
                        String val = dataFormatter.formatCellValue(cell);
                        //Format of the date defined in the input String
                        DateFormat df = new SimpleDateFormat("hh:mm:ss aa");
                        //Desired format: 24 hour format: Change the pattern as per the need
                        DateFormat outputformat = new SimpleDateFormat("HH:mm:ss");
                        Date date = null;
                        String output = null;
                        try{
                            //Converting the input String to Date
                            date= df.parse(val);
                            //Changing the format of date and storing it in String
                            output = outputformat.format(date);
                            //Displaying the date
                           // System.out.println(output);
                            row_data.add(output);
                        }catch(ParseException pe){
                            row_data.add(val);
                           // pe.printStackTrace();
                        }
                    }
                    String lon  = row_data.get( headers.indexOf("x"));
                    String lat = row_data.get( headers.indexOf("y"));
                    String end_time = row_data.get( headers.indexOf("Dept_Time"));
                    String lon1  = row_data.get( headers.indexOf("x_1"));
                    String lat1 = row_data.get( headers.indexOf("y_1"));
                    String end_time1 = row_data.get( headers.indexOf("Dept_Time_1"));
                    Act act = new Act(lon,lat,end_time) ;
                    Route route = new Route(row_data.get( headers.indexOf("Trav_Time")), row_data.get( headers.indexOf("Route_Number")));
                    Route route1 = new Route(row_data.get( headers.indexOf("Trav_Time_1")), row_data.get( headers.indexOf("Route_Number_1")));
                    String mode = row_data.get( headers.indexOf("Mode"));
                    String dep_time = row_data.get( headers.indexOf("Dept_Time"));
                    String trav_time = row_data.get( headers.indexOf("Trav_Time"));
                    String arr_time = row_data.get( headers.indexOf("Arri_Time"));
                    //second leg
                    String dep_time_1 = row_data.get( headers.indexOf("Dept_Time_1"));
                    String trav_time_1 = row_data.get( headers.indexOf("Trav_Time_1"));
                    String arr_time_1 = row_data.get( headers.indexOf("Arri_Time_1"));
                    Leg leg = new Leg(mode, dep_time,trav_time,arr_time,route);
                    Leg leg1 = new Leg(mode, dep_time_1,trav_time_1,arr_time_1,route1);
                    Act act1 = new Act(lon1,lat1,arr_time,dep_time_1) ;
                    Act act2 = new Act(lon,lat,arr_time_1) ;


                    Act [] acts = new Act[3];
                    acts[0] = act;
                    acts[1] = act1;
                    acts[2] = act2;
                    Leg [] legs = new Leg[2];
                    legs[0] = leg;
                    legs[1] = leg1;

                    Plan plan = new Plan(acts,legs);
                    String id = row_data.get( headers.indexOf("Id"));
                    String employed = row_data.get( headers.indexOf("Employed"));
                    Person person = new Person(id,employed,plan);
                    Persons persons1 = new Persons(person,act,plan,leg,route);
                    readData .persons.add(persons1);
                    count+=1;
                }
            }
            file.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        //Now the data in the arraylist , we need to partion it accordingly
        return  readData.persons;
    }

}


