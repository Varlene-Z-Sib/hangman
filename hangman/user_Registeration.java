import javax.swing.JOptionPane;//importing joption pane 
public class user_Registeration
{
   String firstName;//delaring variables
   String lastName;
   String userName;
   String Password;
   
   public boolean checkUserName(String username) //check user name method will check if the username is valid 
   {
      //  boolean length = false;
      //  boolean underscore = false;
        boolean valid = false;
        
      //  length = username.length() <= 5;//boolean variable valid is set as true when userName.length <= 5
        for(int i = 0; i < username.length();i++) 
        {
            if(username.charAt(i) == '_' && username.length() <= 5 )//for loop iterates looking for the '_'
            {
                //underscore = true;//is '_' is found valid is set to true and set to false if not found
               // continue;// loop is continued 
                valid =true;
            }
            

        }
        return valid;
   } 
   
      
   public boolean checkPasswordComplexity(String password) 
   {
        boolean length = false;
        boolean specialCharacter = false;
        boolean number = false;
        boolean capitalLetter = false;
        boolean valid = false;
        
        /*These variables are all set as false until the conditiong are met for them to be true.
        password length will be true if greater than or equal to 8*/

        if (password.length() >= 8)
        {
            length = true;
        }

       for (int i = 0; i < password.length(); i++)
       {
          char c = password.charAt(i);
        
          if (Character.isDigit(c)) //iterates through each character to find a digit 
          {
             number = true;//if found it sets number variable to true
          } 
       }
    
       for (int i = 0; i < password.length(); i++)
       {
            char c = password.charAt(i);
          if (Character.isUpperCase(c)) //iterates through each character to find a capital letter
          {
             capitalLetter = true;// if found it sets this variable to true
          }
       }
    
       for (int i = 0; i < password.length(); i++)
       {
           char c = password.charAt(i);
          if (!Character.isLetterOrDigit(c)) //iterates through each character to find a value that is not a letter or a digit thud making it a special character
          {
            specialCharacter = true;// if a special character is found it sets this variable to true
          }
       }

    
       if (length && specialCharacter && number && capitalLetter)//this the checks if all conditions are met at the same time and if so sets valid as true
       {
            valid= true;
       }

      return valid;
    
   }
    
   public String registerUser(String firstname, String lastname, String username, String password) 
   {
       String message = "";
      int valid = 0;
        
        

         if (checkUserName(username)) 
         {
            JOptionPane.showMessageDialog(null,"Username successfully captured.");
            valid++;
         }
        
         else
         {
            JOptionPane.showMessageDialog(null,"Username is not correctly formatted, please ensure \n"+
                                           "that your username contains an underscore and is no more, \n"+
                                           "than 5 characters in length.");
         }
         
          if (checkPasswordComplexity(password)) 
        {
            JOptionPane.showMessageDialog(null,"Password successfully captured.");
            valid++;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Password is not correctly formatted, please ensure \n"+
                                          "that your password contains at least 8 characters, a capital \n"+
                                           "letter, a number and a special character.");
        }

        if (valid == 2) 
        {
            firstName = firstname;
            lastName = lastname;
            userName = username;
            Password = password;
            
            message = "Your registeration was succesfull!";
        }
        
        else 
        {
            message = "Your registeration was unsuccesfull.";
        }

        return message;
    }
   
   public boolean loginUser(String username, String password) 
   {
    
    boolean loggedIn = false;
   
    
         if(userName.equals(username) && Password.equals(password)) 
        {
           loggedIn =true ;
        } 
        
    return loggedIn;

   }
      
     public String returnLoginStatus(String username, String password) 
    {
       String message = "" ;
        if(loginUser(username, password))
         
        {
            message = "Welcome " + firstName +" "+ lastName + ", it is great to see you again!";
            
        }
         else
        {
            message = "Username or password incorrect, please try again";
        }
       
    return message;
   }
}

        
        
        
    
