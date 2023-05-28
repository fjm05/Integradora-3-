package model;

import java.util.ArrayList;
import java.util.Calendar;



public class StandardUser extends User{


    public StandardUser(String name_user, String id_user, Calendar binding_date) {
        super(name_user, id_user, binding_date);
        this.listOfTickets = new ArrayList<>(); 
        StandardMagazines = new Magazine[2];  
        StandardLibros = new Libro[5]; 

       
    }
    private ArrayList <Ticket> listOfTickets;
    private Libro[] StandardLibros = new Libro[5]; 
    private Magazine[] StandardMagazines = new Magazine[2]; 


    public BibliographicProduc[] getStandardMagazine(){
        return StandardMagazines;
    }
    public BibliographicProduc[] getStandardLibros(){
        return StandardLibros;
    }
    public ArrayList<Ticket> getListOgTickets(){
        return listOfTickets;
    }

    public void setListOfTickets(ArrayList <Ticket> listOfTickets){
        this.listOfTickets = listOfTickets;
    }  
    public void setStandardMagazines(BibliographicProduc[] standardMagazines){
        StandardMagazines = (Magazine[]) standardMagazines; 

    }
    public void setStandardLibros(BibliographicProduc[] standardLibros){
        StandardLibros  = (Libro[]) standardLibros;
    }

    public Boolean checkMagazine(){
        int magazineCounter = 0; 
        for (int i = 0; i < StandardMagazines.length; i++){
            if (magazineCounter< 2){
                return true; 
            }
        }
        return false;
    }

    public Boolean checkBook(){
        int bookCounter = 0; 
        for (int i = 0; i < StandardLibros.length; i++){
            if (bookCounter< 5){
                return true; 
            }
        }
        return false;
    }
    public boolean purchaseBook(BibliographicProduc blibio){
        if (checkBook()){
            for (int i = 0; i < StandardLibros.length; i++){
                if (StandardLibros[i] == null){
                    Libro copyBook = ((Libro)blibio);
                    StandardLibros[i] = (copyBook);
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public boolean purchaseMagazine(BibliographicProduc bliblio) {
      if (checkMagazine()){
        for (int i = 0; i < StandardMagazines.length; i++){
            if (StandardMagazines[i] == null){
                Magazine copy = ((Magazine)bliblio);
                StandardMagazines[i] = (copy);

            }
        }
      }
      return false;
    }
    public int subs() {
        int counter = 0;
        for (int i = 0; i < StandardMagazines.length; i++) {
            if (StandardMagazines[i] != null) {
                counter++;
            }
        }
        return counter;
    }

    
    public boolean keepTicket(Ticket tick) {
       
        return listOfTickets.add(tick); 
    }
    @Override
    public boolean subCancel(int magazineId) {
       StandardMagazines[magazineId-1] = null;
       return true;
    }
    @Override
    public String showBooksList() {
       String BookList = "";
       for (int i = 0; i < StandardLibros.length; i++) {
        BookList += (i +1)+ "."+ StandardLibros[i].getName() + "\n";
       }
       return BookList;
    }
    public String showMagazineList() {
        String MagazineList = ""; 
        for (int i = 0; i < StandardMagazines.length; i++) {
            MagazineList += (i +1)+ "."+ StandardMagazines[i].getName() + "\n";
        }
        return MagazineList;
       
    }
   
    



}