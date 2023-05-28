package model;
import java.util.ArrayList;
import java.util.Calendar;

public class PremiumUser extends User{
    private ArrayList<Libro> listOfLibro; 
    private ArrayList<Ticket> listOfTickets; 
    private ArrayList<Magazine> listOfMagazine; 
    
   
    public PremiumUser(String name_user, String id_user, Calendar binding_date) {
        super(name_user, id_user, binding_date);
        this.listOfLibro = new ArrayList<Libro>();
        this.listOfTickets = new ArrayList<>();
        this.listOfMagazine = new ArrayList<Magazine>();   
    }
    
    
    public ArrayList<Libro> getListOfLibro() {
        return listOfLibro;
    }


    public void setListOfLibro(ArrayList<Libro> listOfLibro) {
        this.listOfLibro = listOfLibro;
    }


    public ArrayList<Ticket> getListOfTickets() {
        return listOfTickets;
    }


    public void setListOfTickets(ArrayList<Ticket> listOfTickets) {
        this.listOfTickets = listOfTickets;
    }


    public ArrayList<Magazine> getListOfMagazine() {
        return listOfMagazine;
    }


    public void setListOfMagazine(ArrayList<Magazine> listOfMagazine) {
        this.listOfMagazine = listOfMagazine;
    }


    
    public boolean purchaseBook(BibliographicProduc bliblio) {
        Libro copyBook = ((Libro)bliblio); 
        return listOfLibro.add(copyBook);
    }
    
    public boolean purchaseMagazine(BibliographicProduc bliblio) {
        Magazine copy = ((Magazine)bliblio);
        return listOfMagazine.add(copy); 

    }
    
    public boolean keepTicket(Ticket tick) {
        return listOfTickets.add(tick);
    }
   
    public boolean subCancel(int magazineId) {
        listOfMagazine.remove(magazineId-1);
        return true;
    }

    
   public String showLibroList(){
    String libroList = "";
    for(int i = 0; i< listOfLibro.size(); i++){
        if (listOfLibro.get(i) instanceof Libro) {
            libroList+= (i +1)+ ". " + listOfLibro.get(i).getName() + "\n";

        }
    }
    return libroList;
}
        
        
        
         
        
    
   


   
    
    public String showMagazineList() {
        String magazineList = "";
        for (int i = 0; i < listOfMagazine.size(); i++) {
            if (listOfMagazine.get(i) instanceof Magazine){
                magazineList += (i + 1) + "Magazine : " + listOfMagazine.get(i).getName() + "\n";

            }
        }
        return magazineList;
    }


    @Override
    public String showBooksList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showBooksList'");
    }

}
