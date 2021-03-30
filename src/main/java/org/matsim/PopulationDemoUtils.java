package org.matsim;

import com.google.inject.internal.cglib.core.$KeyFactory;
import org.apache.poi.ss.usermodel.*;
import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.population.Activity;
import org.matsim.api.core.v01.population.Population;
import org.matsim.api.core.v01.population.PopulationFactory;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.scenario.ScenarioUtils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class PopulationDemoUtils {


    public static List<Map<String,String>> getData(){
        List<Map<String,String>> data =  new ArrayList<>();
        int rowCount=0;

        String execlfolder = "H:\\Masters_Transport\\CIV5109Z Dissertation Preparation\\Nairobi Transport Diary_2013\\JICA\\";
        try (InputStream inp = new FileInputStream(execlfolder + "Nairobi_Travel_Diary_2013_Demo.xlsx")) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            System.out.println("header: " +sheet.getSheetName());

            Iterator<Row> rowIterator = sheet.iterator();
            boolean isFirst = true;
            List<String> keyList = new ArrayList<>();
;;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
rowCount++;
                if(isFirst){
                    row.forEach(cell -> {
                    if( keyList.contains(getCellValue(cell)))
                    {
                        keyList.add("trav_"+getCellValue(cell));
                    }

                else{
                        keyList.add(getCellValue(cell).replace(")","").replace(" ","_").replace("/","").replace("(","").toLowerCase());
                    }
                    });
                    System.out.println(keyList);

                    isFirst=false;
                    continue;
                }
                //  System.out.println("header keys: "+keyList);
                int cellIndex =0;
                Iterator<Cell> cellIterator = row.iterator();
                Map<String,String> headerToCellValue = new HashMap<>();
                while(cellIterator.hasNext()){

                    headerToCellValue.put(keyList.get(cellIndex),getCellValue(cellIterator.next()));
                    cellIndex++;
                }
                data.add(headerToCellValue);

            }

        } catch(Exception ioException ){
            ioException.printStackTrace();
        }
        System.out.println("size is: "+rowCount);
        for(Map<String,String> x: getData()){
            System.out.println(x);
        }

        return data;
    }



    static String getCellValue(Cell cell){
        return cell.getCellType()== Cell.CELL_TYPE_NUMERIC?cell.getNumericCellValue()+"":cell.getStringCellValue()+"";

//        Population pop = sc.getPopulation();
//        PopulationFactory factory = pop.getFactory();

    }
}
