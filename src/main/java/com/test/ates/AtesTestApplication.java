package com.test.ates;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.ates.service.FlightService;
import com.test.ates.entity.Baggage;
import com.test.ates.entity.Flight;
import java.util.List;

@SpringBootApplication
public class AtesTestApplication {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SpringApplication.run(AtesTestApplication.class, args);
		
		JSONParser jsonParser = new JSONParser();
        
        try (FileReader reader = new FileReader("src/main/resources/json/generated.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);
             
            //Iterate over employee array
            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
 
    private static void parseEmployeeObject(JSONObject baggageJson) 
    {
        //Get employee object within list
        JSONArray baggageArray = (JSONArray) baggageJson.get("baggage");
         System.out.println();
         Baggage baggage = new Baggage();
        for (int i=0; i<baggageArray.size();i++) {
        	 JSONObject jsonTerm = (JSONObject) baggageArray.get(i);
        	Long id = (Long) jsonTerm.get("id");
        	System.out.println(id);
        	baggage.setId(id);
        	
        }
        //Get employee first name
//        Long id = (Long) baggageObject.get("id");    
//        System.out.println(id);
//         
//        //Get employee last name
//        Integer weight = (Integer) baggageObject.get("weight");  
//        System.out.println(weight);
//         
//        //Get employee website name
//        String weightUnit = (String) baggageObject.get("weightUnit");    
//        System.out.println(weightUnit);
//        
//        Integer pieces = (Integer) baggageObject.get("pieces");    
//        System.out.println(pieces);
//        
    }
}
