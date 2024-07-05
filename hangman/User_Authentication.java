import javax.swing.JOptionPane;

public class User_Authentication {
    String name;
    String surname;
    String username;
    String password;

    //Validate Username
    public boolean checkUserName(String useR_n) {
        boolean vld = false;
        boolean unSc = false;
        int c = 0;
        for (int i = 0; i < useR_n.length(); i++) {
            if (useR_n.charAt(i) == '_') {
                unSc = true;
            }
            c++;
        }
        if(unSc && c <= 5){
            vld = true;
        }
        return vld;
    }

    //Password Validation
    public boolean checkPasswordComplexity(String pW_or) {

        boolean Len = false;
        boolean speChar = false;
        boolean nuM = false;
        boolean cAp = false;
        boolean vLd = false;

        if(pW_or.length() > 7){
            Len = true;
        }

        for(int i = 0; i < pW_or.length()-1; i++){
            if(pW_or.charAt(i) == '@' || pW_or.charAt(i) == '#' ||
                    pW_or.charAt(i) == '&' || pW_or.charAt(i) == '%' ||
                    pW_or.charAt(i) == '$' || pW_or.charAt(i) == '*' ||
                    pW_or.charAt(i) == '!' || pW_or.charAt(i) == '+'){
                speChar = true;
            }
        }

        for(int i = 0; i < pW_or.length()-1; i++){
            if(Character.isDigit(pW_or.charAt(i))){
                nuM = true;
            }
        }

        for(int i = 0; i < pW_or.length(); i++){
            if(Character.isUpperCase(pW_or.charAt(i))){
                cAp = true;
            }
        }

        if(Len && speChar && nuM && cAp){
            vLd = true;
        }
        return vLd;
    }

    //User registeration
    public String registerUser(String n_Ame, String snaMe, String u_nAme, String pwoRd) {
        String mSg = "";
        int vLd = 0;

        if (checkUserName(u_nAme)) {
            JOptionPane.showMessageDialog(null,"correct username");
            vLd++;
        }
        else{
            JOptionPane.showMessageDialog
                    (null,"incorrect username");
        }

        if (checkPasswordComplexity(pwoRd)) {
            JOptionPane.showMessageDialog(null,"correct password");
            vLd++;
        }
        else{
            JOptionPane.showMessageDialog
                    (null,"incorrect password");
        }

        if (vLd == 2) {
            mSg = "register succes";
            name = n_Ame;
            surname = snaMe;
            username = u_nAme;
            password = pwoRd;
        }
        else {
            mSg = "register unsucces";
        }
        return mSg;

    }

    //User login
    public boolean loginUser(String n_Ame, String snaMe, String u_nAme, String pwoRd){
        boolean valid = false;
        if (name== n_Ame && surname == snaMe && username == u_nAme && password == pwoRd){
            valid = true;
        }
        return valid;
    }

    //Return login status
    public String returnLoginStatus(String n_Ame, String snaMe, String u_nAme, String pwoRd){
        String mSg = null;
        if (loginUser(n_Ame, snaMe, u_nAme, pwoRd)){
            mSg = "login successful!";
        }
        else{
            mSg = "login unsuccessful";
        }
        return mSg;
    }
}