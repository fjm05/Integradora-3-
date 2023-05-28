package model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Date;

public class Controlador{

    private static ArrayList<BibliographicProduc> listOfBibliographicProducs; 
    private ArrayList<User> listOfUsers; 

    public Controlador(){
        listOfBibliographicProducs = new ArrayList<>(); 
        listOfUsers = new ArrayList<>();
        bibliographicTestCase(); 
        userTestCase();
    }

   

  
    public void bibliographicTestCase(){
        listOfBibliographicProducs.add(1, new Magazine("A2E", "Semana", "12/09/2022", "Game.net", 450, Category.VARIETIES, "Weekly", 19, 150.0, 50000));
        listOfBibliographicProducs.add(0, new Libro("Q21", "principito", "12/09/2014", "Principito.com", 45, 49.45, 55555, "good book", Gender.FANTASY_HISTOR));
    
    }

    public void userTestCase(){
        listOfUsers.add(0, new PremiumUser("Francisco", "A00399875", Calendar.getInstance()));
        listOfUsers.add(1, new StandardUser("Jose", "A00389535", Calendar.getInstance())); 

    }

    public static boolean magazineRegister(String unique_id, String name, String  publication_date, String url, int pages_read, double price, int suscriptions, String publised, Category category, int soldAmount){
        Category category_type = Category.DESIGN;
        switch(category){
            case DESIGN:
            category_type = Category.DESIGN;
            break;
            case VARIETIES:
            category_type = Category.VARIETIES;
            break;
            case SCIENTIFIC:
            category_type = Category.SCIENTIFIC;
            break;
            
        }
        Date dateMagazine = null; 

        try{
            dateMagazine = new SimpleDateFormat("dd/mm/yyyy").parse(publication_date);
            
        } catch (ParseException b){
            b.printStackTrace();
        }
        Magazine newMagazine = new Magazine(unique_id, name, publication_date, url, pages_read, category_type, publised, suscriptions, price, soldAmount);
        return listOfBibliographicProducs.add(newMagazine);
    }
    public boolean magazineSell(int userId, int idMagazine){
        Ticket tick = new Ticket(Calendar.getInstance(), listOfBibliographicProducs.get(idMagazine-1).getPrice());
        if(listOfBibliographicProducs.get(idMagazine-1) instanceof Magazine){
            listOfUsers.get(userId-1).keepTicket(tick);
            return listOfUsers.get(userId-1).purchaseBook(listOfBibliographicProducs.get(idMagazine-1));
        }
        return false;

    }
    public boolean magazineModify(int option, String newUnique_id, String newName, String newPublication_date, String newUrl, int newPages_read,
    Category newCategory, String newPublished, int newSuscriptions, Double newPrice, int newSoldAmount){
        Category category_magazine = Category.DESIGN; 
        switch(newCategory){
            case DESIGN:    
            category_magazine = Category.DESIGN;
            break;
            case VARIETIES:
            category_magazine = Category.VARIETIES;
            break;
            case SCIENTIFIC:
            category_magazine = Category.SCIENTIFIC;
            break;


        }
        Date dateMagazine = null;
        try{
            dateMagazine = new SimpleDateFormat("dd/mm/yyyy").parse(newPublication_date);
            } catch (ParseException b){
                b.printStackTrace();
            }
            BibliographicProduc magazine = listOfBibliographicProducs.get(option); 
            magazine.setUnique_id(newUnique_id);
            magazine.setName(newName);
            magazine.setPublication_date(newPublication_date);
            magazine.setUrl(newUrl);
            magazine.setPages_read(newPages_read);
            ((Magazine) magazine).setCategory(category_magazine);
            ((Magazine) magazine).setPublished(newPublished);   
            ((Magazine) magazine).setSuscriptions(newSuscriptions);
            magazine.setPrice(newPrice);
            magazine.setSoldAmount(newSoldAmount);
        return true;

    } 
    public boolean deleteMagazine(int positionMagazine){
        if(positionMagazine>listOfBibliographicProducs.size()){
            return false;
        }
        listOfBibliographicProducs.remove(positionMagazine);
        return true;
    }
    public String showMagazineList(){
        String magazineList = "";
        for(int i = 0; i<listOfBibliographicProducs.size(); i++){
            if (listOfBibliographicProducs.get(i) instanceof Magazine){
                magazineList += (i+1) + "Magazine : " + listOfBibliographicProducs.get(i).getName() + "\n";
            }
        }
        return magazineList;
    }
    public String showMagazineListOfUser(int userId){
        return listOfUsers.get(userId).showMagazineList();
    }
    public boolean subCancel(int magazineId, int userId){
        if( listOfUsers.get(userId).subCancel(magazineId)){
            return true;
        }
        return false;
    }

    public static boolean bookRegister(String unique_id, String name, String publication_date, String url, int pages_read, Double price, int soldAmount, String review, Gender gender){
        Gender gender_type = Gender.FANTASY_HISTOR; 
        switch (gender){
            case FANTASY_HISTOR:
            gender_type = Gender.FANTASY_HISTOR;
            break;
            case  SCIENCE_FICTION:
            gender_type = Gender.SCIENCE_FICTION;
            break;
            case  NOVEL:
            gender_type = Gender.NOVEL;
            break;
            
        }
        Date dateBook = null;
        try{
            dateBook = new SimpleDateFormat("dd/mm/yyyy").parse(publication_date);
        }catch (ParseException c){
            c.printStackTrace();
        }
        Libro newLibro = new Libro(unique_id,  name,  publication_date, url,  pages_read, price, soldAmount,  review, gender_type); 
        return listOfBibliographicProducs.add(newLibro);
    }

    public boolean bookSell(int userId, int libroId){
        Ticket tick = new Ticket(Calendar.getInstance(), listOfBibliographicProducs.get(libroId-1).getPrice()); 
        if(listOfBibliographicProducs.get(libroId-1) instanceof Libro){
            listOfUsers.get(userId-1).keepTicket(tick); 
            return listOfUsers.get(userId-1).purchaseBook(listOfBibliographicProducs.get(libroId-1));
        }
        return false; 
    }

    public boolean libroModify(int option_2, String newLibroUnique_id, String newLibroName, String newLibroPublication_date, String newLibroUrl, int newLibroPages_read, Double newLibroPrice, int newLibroSoldAmount, String newLibroReview, Gender newLibroGender){
        Gender gender_tp = Gender.FANTASY_HISTOR; 
        switch (newLibroGender){
            case FANTASY_HISTOR:
            gender_tp = Gender.FANTASY_HISTOR;
            break; 
            case  SCIENCE_FICTION:
            gender_tp = Gender.SCIENCE_FICTION;
            break;
            case  NOVEL:
            gender_tp = Gender.NOVEL;
            break;
        }
        Date dateBook = null;
        try{
            dateBook = new SimpleDateFormat("dd/mm/yyyy").parse(newLibroPublication_date);
        } catch (ParseException d){
            d.printStackTrace();
        }
        BibliographicProduc libro = listOfBibliographicProducs.get(option_2); 


        libro.setUnique_id(newLibroUnique_id);
        libro.setName(newLibroName);
        libro.setPublication_date(newLibroPublication_date);    
        libro.setUrl(newLibroUrl);
        libro.setPages_read(newLibroPages_read);
        libro.setPrice(newLibroPrice);
        libro.setSoldAmount(newLibroSoldAmount);
        ((Libro) libro).setReview(newLibroReview);
        ((Libro) libro).setGender(gender_tp);
        return false;

    }

    public boolean deleteLibro(int libroPosition){
        if(libroPosition>listOfBibliographicProducs.size()){
            return false;
        }
        listOfBibliographicProducs.remove(libroPosition);
        return true;
    }

    public String showLibroList(){
        String libroList = "";
        for(int i = 0; i < listOfBibliographicProducs.size(); i++){
            if(listOfBibliographicProducs.get(i) instanceof Libro){
                libroList += (i+1)+ "Book"+listOfBibliographicProducs.get(i).getName()+ "\n";
            }
        }
        return libroList;
    }
    public String showLibroListOfUser(int userId){
        return listOfUsers.get(userId).showLibroList();
    }


    public String userSelect(int userPosition){
        String msg = "";
        if(listOfUsers.get(userPosition) instanceof PremiumUser){
            msg += "The user is premium"; 
        }else if(listOfUsers.get(userPosition)instanceof StandardUser){
            msg += "The user is standard"; 
        }
        return msg;
    }   

    public boolean userRegister(String name_user, String id_user, int userType){
        User newUser = null; 
        Calendar dateCreation = Calendar.getInstance(); 
        if(userType == 1){
           newUser = new PremiumUser(name_user, id_user, dateCreation);
        }else if (userType == 2){
            newUser = new StandardUser(name_user, id_user, dateCreation);
        }
        return listOfUsers.add(newUser); 
    }

    public String showUserList(){
        String userList = "";
        for(int i = 0; i < listOfUsers.size(); i++){
            userList += (i+1)+ "User"+listOfUsers.get(i).getName_user()+ "\n";
        }
        return userList;
    }
    public ArrayList<User> getUsers(){
        return listOfUsers;
    }



    public String session(int userId, int libroId){
        String msg = "";


        return msg;
    }




    public boolean libroDelete(int i) {
        return false;
    }
}
    