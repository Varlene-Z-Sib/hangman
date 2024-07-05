import javax.swing.JOptionPane;
public class Registration_Driver
{
   public static void main(String [] args)
   {
        String firstName = "";
        String lastName = "";
        String userName = "";
        String Password = "";
        
        user_Registeration valid = new user_Registeration();
        do{
        firstName = JOptionPane.showInputDialog("Please enter your name.");
        lastName = JOptionPane.showInputDialog("Please enter your surname.");
        userName = JOptionPane.showInputDialog("Please create a username.");
        Password = JOptionPane.showInputDialog("Please create a password.");
        JOptionPane.showMessageDialog(null, valid.registerUser(firstName, lastName, userName, Password));
    }while(valid.checkUserName(userName) == false || valid.checkPasswordComplexity(Password) == false);
      
    String userName_login = "";
    String Password_login = "";
    
    boolean logged_In = false;
    while(logged_In == false)
    {
        userName_login = JOptionPane.showInputDialog("Please enter your username to login");
        Password_login = JOptionPane.showInputDialog("Please enter your password to login");
        
    if(valid.loginUser(userName_login, Password_login) == false )
    {
        JOptionPane.showMessageDialog(null,"Username or password incorrect, please try again");
    }
    else
    {
        logged_In = true;
    }
    
    
    }
    JOptionPane.showMessageDialog(null, valid.returnLoginStatus(userName, Password));
  }
}
    
    
