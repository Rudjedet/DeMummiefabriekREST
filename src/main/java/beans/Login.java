/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
//import javax.faces.bean.ManagedBean;
//import javax.faces.context.SessionScoped;
import javax.enterprise.context.SessionScoped;
//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import util.DataConnect;

/**
 *
 * @author Sonja
 */

//@ManagedBean
@Named
@SessionScoped
public class Login implements Serializable {
    
    private static final long serialVersionUID = 1094801825228386363L;
    
    private String pwd;
    private String msg;
    private String user;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public String validateUsernamePassword() {
        boolean valid = Login.validate(user, pwd); 
        if (valid) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            return "inlogGelukt.xhtml?faces-redirect=true";
        }
        else {
//            FacesContext.getCurrentInstance().addMessage
//                (null, new FacesMessage //(FacesMessage.SEVERITY_WARN, 
//                    ("De gebruikersnaam en/of het wachtwoord dat u heeft "
//                            + "ingevoerd is onbekend. Probeer opnieuw."));
            return "loginError.xhtml?faces-redirect=true";
        }
    }
    
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        
        return "login.xhtml?faces-redirect=true"; //later vervangen met index
    }
    
    public static boolean validate(String user, String password) {
        
        try (Connection connection = (Connection) DataConnect.getConnection();) {
            String query = "SELECT username, wachtwoord FROM account WHERE username = ? and wachtwoord = ?";
            PreparedStatement pS = (PreparedStatement) connection.prepareStatement(query);
            
            pS.setString(1, user);
            pS.setString(2, password);
            
            ResultSet rS = pS.executeQuery();
            
            if (rS.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error:" + ex.getMessage());
            
            return false;
        }
        return false;
    }
}
