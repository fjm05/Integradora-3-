package model;

import java.util.Calendar;

public abstract class User {
    private String name_user;
    private String id_user;
    private Calendar binding_date; 
    
    public User(String name_user, String id_user, Calendar binding_date){
        this.name_user = name_user;
        this.id_user = id_user;
        this.binding_date = binding_date;
    }
    public String getName_user() {
        return name_user;
    }
    public String geId_user() {
        return id_user;
    }
    public Calendar getBindingdate() {
        return binding_date;
    }
    public void setName_user(String name_user) {
        this.name_user = name_user;
    }
    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
    public void setBinding_date(Calendar binding_date) {
        this.binding_date = binding_date;
    }

    public abstract boolean purchaseBook(BibliographicProduc bliblio); 
    public abstract boolean purchaseMagazine(BibliographicProduc bliblio);
    public abstract boolean keepTicket(Ticket tick);
    public abstract boolean subCancel(int magazineId); 
    public abstract String showBooksList(); 
    public abstract String showMagazineList();


    public String toStringPremiumUser(){
        String msg = ""; 
        msg += "Name: " +name_user+ "the id: " +id_user+ "con su vinculacion en: " +binding_date;
        return msg;
    }
    public String toStringStandardUser(){
        String msg = "";
        msg += "Name: " +name_user+ "the id: " +id_user+ "con su vinculacion en:" +binding_date;
        return msg;
    }
    public String showLibroList() {
        return null;
    }




    



    
}
