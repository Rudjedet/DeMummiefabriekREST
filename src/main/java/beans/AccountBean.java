/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Account;
import entity.Klant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import session.AccountFacade;
//import session.KlantAdresFacade;
import session.KlantFacade;

/**
 *
 * @author Sonja
 */

@Stateless
@Dependent
@Named
public class AccountBean {
    
    private Account ditAccount;
    private Klant dezeKlant;
    private Integer klantId;
    private List<Account> alleAccounts;
    
    @EJB
    private AccountFacade acFacade;
    @EJB
    private KlantFacade kFacade;
    //@EJB
    //private KlantAdresFacade kaFacade;
    
    
    public AccountBean() {
        ditAccount = new Account();
        dezeKlant = new Klant();
    }
    
    @PostConstruct
    public void init() {
        alleAccounts = new ArrayList<>();
        leesAlleKlantAccounts();
    }
    
    /*
    * CRUD methodes
    */
    public String maakNieuwAccount() {
        //dezeKlant = new Klant();
        klantId = dezeKlant.getKlantId();
        ditAccount.setKlantIdklant(dezeKlant);
        ditAccount.setAanmaakdatum(new Date());
        acFacade.create(ditAccount);
        alleAccounts.add(ditAccount);
        return "login";
    }
    
    public void leesAlleKlantAccounts() {
        setAlleAccounts(acFacade.findAll());
    }
    
    public void leesDitAccount(Klant klant) {
        setDezeKlant(klant);
        setAlleAccounts(acFacade.findByKlantID(dezeKlant.getKlantId()));
    }
    
    public String editDitAccount() { 
        acFacade.edit(ditAccount);   
        ditAccount = new Account();
        return "account";
    }
    
    public String gaNaarEditAccount(Account account) {
        setDitAccount(account);
        return "editaccount";
    }
    
    public void verwijderAccount() {
        acFacade.remove(ditAccount);
        alleAccounts.remove(ditAccount);
    }
    
    /*
    * Getters & Setters
    */
    public Account getDitAccount() {
        return ditAccount;
    }

    public void setDitAccount(Account ditAccount) {
        this.ditAccount = ditAccount;
    }

    public Klant getDezeKlant() {
        return dezeKlant;
    }

    public void setDezeKlant(Klant dezeKlant) {
        this.dezeKlant = dezeKlant;
    }

    public int getKlantId() {
        return klantId;
    }

    public void setKlantId(int klantId) {
        this.klantId = klantId;
    }

    public List<Account> getAlleAccounts() {
        return alleAccounts;
    }

    public void setAlleAccounts(List<Account> alleAccounts) {
        this.alleAccounts = alleAccounts;
    }
}
