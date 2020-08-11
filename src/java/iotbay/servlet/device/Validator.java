package iotbay.servlet.device;


   import java.util.regex.Matcher;
   import java.util.regex.Pattern;


   public class Validator { 

 
         
   private String datePattern = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";       
              
   public Validator(){    }       


   public boolean validate(String pattern, String input){       
      Pattern regEx = Pattern.compile(pattern);       
      Matcher match = regEx.matcher(input);       

      return match.matches(); 

   }       

   public boolean checkDate(String date, String password){       

      return  date.isEmpty() || date.isEmpty();   

   }

   
   public boolean validateDate(String date){                       

      return validate(datePattern,date);   

   }
   }
