package calculator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Rent;

/**
 *
 * @author nadab
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("utilities/SquareX_data.txt");
        
        //calculate by date
      try {
            Rent[] rents = objectMapper.readValue(file, Rent[].class);

            List<Rent> rentList = new ArrayList<>(Arrays.asList(rents));

            Map<Date, Integer> totalAmountByDate = Rent.calculateTotalAmountByDate(rentList);

            // Print the total amount for each date
            for (Map.Entry<Date, Integer> entry : totalAmountByDate.entrySet()) {
                System.out.println("Date: " + entry.getKey() + ", Total Amount: " + entry.getValue());
            }
        } 
       
        //calculate by month
      /*  try {
            Rent[] rents = objectMapper.readValue(file, Rent[].class);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
            Date targetMonth;

            try {
                targetMonth = dateFormat.parse("2023-07"); // Change to the desired month
            } catch (ParseException e) {
                System.out.println("Invalid date format");
                return;
            }

            // Calculate the total amount for the chosen month using the function in Rent class
            int totalAmount = Rent.calculateTotalAmountForMonth(rents, targetMonth);

            System.out.println("Total Amount for " + dateFormat.format(targetMonth) + ": " + totalAmount);
            */
      
            //calculate by year
           /* try {
            Rent[] rents = objectMapper.readValue(file, Rent[].class);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
            Date targetYear;

            try {
                targetYear = dateFormat.parse("2023"); // Change to the desired year
            } catch (ParseException e) {
                System.out.println("Invalid date format");
                return;
            }

            // Calculate the total amount for the chosen year using the function in Rent class
            int totalAmount = Rent.calculateTotalAmountByYear(rents, targetYear);

            System.out.println("Total Amount for " + dateFormat.format(targetYear) + ": " + totalAmount);

             
        } */catch (IOException e) {
            e.printStackTrace();
        }
    }
}
