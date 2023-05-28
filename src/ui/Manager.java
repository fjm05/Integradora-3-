package ui;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;

import model.Category;
import model.Controlador;
import model.Gender;
import model.User;
 


public class Manager {
    

        private static Scanner reader;
        private Controlador controlador;
        
    
        public Manager() {
            reader = new Scanner(System.in); 
            controlador = new Controlador();
    
          
        }
    
        public static void main (String[] args) {
    
            Manager man = new Manager();
            man.menu();
    
        }
    
        public void menu() {
    
            System.out.println("Welcome to the program");
    
            boolean flag = false;
    
            while (!flag) {
                
                System.out.println("What do you want to do?");
                System.out.println("\n1.register user");
                System.out.println("2. Register bibliographic product");
                System.out.println("3. Modify bibliographic product");
                System.out.println("4. Delete bibliographic product");
                System.out.println("5. Buy a bibliographic product");
                System.out.println("6. Library");
                System.out.println("7. Reading session");
                System.out.println("8. Cancel suscrption");
                System.out.println("0. Exit");
            
                int option = reader.nextInt();
    
                switch (option) {
    
                case 1:
                    registerUser();
                   
                   
                    break;
    
                case 2:
                    registerProduct();
                    
                    
                    break;
    
                case 3:
                    productModify();
                    
                   
                    break;
    
                case 4:
                    productDelete();
                    
                    
                    break;

                case 5 :
                    sellProduct();
                   
                
                    break;

                case 6:
                    library();
                                   
                    break;
                case 7:
                    session();
                    break; 
                case 8: 
                    break; 


                case 0: 
                System.out.println("Exiting the program");
                flag = true;
                
                    break; 
    
                }


    
            }
        }
        public void registerUser(){

            System.out.println("Type ahead the information for a new User");
    
            //Limpieza de Buffer
            reader.nextLine();
    
            System.out.println("What kind of User is going to register? \n1.Premium \n2.Standard");
            int userType = Integer.valueOf(reader.nextLine());
            //Limpieza de Buffer
            reader.nextLine();
    
            System.out.println("Write the id");
            String id_user = reader.nextLine();
    
            System.out.println("Write the name");
            String name_user = reader.nextLine();
    
    
            if(controlador.userRegister(id_user, name_user,userType)){
    
                System.out.println("------------------------------");
                System.out.println("User Successfully registered");
                System.out.println("----------------------------------");
            }else{
    
                System.out.println("There was an error registering the User");
    
            }
        }
        public void registerProduct(){

            System.out.println("Select what kind of product you want to Register ");
            System.out.println("1.Book \n2.Magazine"); 
            
            
            int biblioGraphicProductoption = Integer.valueOf(reader.nextLine());
    
            switch(biblioGraphicProductoption){
    
                case 1:
                
                    bookRegister();
                    break;
        
                case 2:
                    magazineRegister();
                break;
            }
    
        }
       
        public void magazineRegister(){
        
            System.out.println("Type the id of the Magazine");
            String unique_id = reader.nextLine();
    
            
            System.out.println("Type the name of the Magazine");
            String name = reader.nextLine();
    
            System.out.println("Write the number of pages in the Magazine");
            int  pages_read = Integer.valueOf(reader.nextLine());
    
           System.out.println("Type the date of Publication as the next Format : dd/MM/yyyy");
           String publication_date = reader.nextLine();
    
            System.out.println("Select a Category for the Magazine \n1.Varieties \n2.Design \n3.Scientific");
            Category category = Category.valueOf(reader.nextLine());
    
            
            System.out.println("Type the URL for the Magazine");
            String url = reader.nextLine();
    
            System.out.println("Write the value of the Magazine");
            Double price = Double.valueOf(reader.nextLine());
    
           
            System.out.println("Type the periodicity of the Magazine (Words)");
            String publised = reader.nextLine();
            System.out.println("Type the suscriptions of the Magazine");
            int suscriptions = Integer.valueOf(reader.nextLine());
            System.out.println("Type the sold amountn of the Magazine");
            int soldAmount = Integer.valueOf(reader.nextLine());

    
            if(Controlador.magazineRegister(unique_id, name,  publication_date, url, pages_read, price, suscriptions, publised, category, soldAmount)){
               
                System.out.println("Magazine registered succesfully");
            }else{
    
                System.out.println("Error, there was a problem registering the book");
            }
    
    
    
        }
        public void bookRegister(){
            System.out.println("Type the id of the Book");
            String unique_id = reader.nextLine();
            System.out.println("Type the name of the Book");
            String name = reader.nextLine();
            System.out.println("Write the number of pages in the Book");
            int  pages_read = Integer.valueOf(reader.nextLine());
            System.out.println("Type the date of Publication as the next Format : dd/MM/yyyy");
            String publication_date = reader.nextLine();
            System.out.println("Type the URL for the Book");
            String url = reader.nextLine();
            System.out.println("Write the value of the Book");
            Double price = Double.valueOf(reader.nextLine());
            System.out.println("Type the sold amount of the Book");
            int soldAmount = Integer.valueOf(reader.nextLine());
            System.out.println("Type the Review of the Book");
            String review = reader.nextLine();
            System.out.println("Type the Gender of the Book");
            Gender gender = Gender.valueOf(reader.nextLine());

            if(Controlador.bookRegister(unique_id, name, publication_date, url, pages_read, price, soldAmount, review, gender)){
                System.out.println("Book registered succesfully");
            }else {
                System.out.println("Error, there was a problem registering the book");
            }


        }
        public void productModify(){
            System.out.println("type if you want to modify a magazine or a Book \n1.Magazine \n2.Book");
            int option1 = Integer.valueOf(reader.nextLine());
            if(option1 == 1){
                String consult = controlador.showMagazineList();
                System.out.println("select the magazine to change");
                System.out.println(consult);

                int option = Integer.valueOf(reader.nextLine()); 
                System.out.println("Type the id of the Magazine");
            String newUnique_id = reader.nextLine();
    
            
            System.out.println("Type the name of the Magazine");
            String newName = reader.nextLine();
    
            System.out.println("Write the number of pages in the Magazine");
            int  newPages_read = Integer.valueOf(reader.nextLine());
    
           System.out.println("Type the date of Publication as the next Format : dd/MM/yyyy");
           String newPublication_date = reader.nextLine();
    
            System.out.println("Select a Category for the Magazine \n1.Varieties \n2.Design \n3.Scientific");
            Category newCategory = Category.valueOf(reader.nextLine());
    
            
            System.out.println("Type the URL for the Magazine");
            String newUrl = reader.nextLine();
    
            System.out.println("Write the value of the Magazine");
            Double newPrice = Double.valueOf(reader.nextLine());
    
           
            System.out.println("Type the periodicity of the Magazine (Words)");
            String newPublised = reader.nextLine();
            System.out.println("Type the suscriptions of the Magazine");
            int newSuscriptions = Integer.valueOf(reader.nextLine());
            System.out.println("Type the sold amountn of the Magazine");
            int newSoldAmount = Integer.valueOf(reader.nextLine());

            if(controlador.magazineModify(option, newUnique_id, newName, newPublication_date, newUrl, newPages_read, newCategory, newPublised, newSuscriptions, newPrice, newSoldAmount)){
                System.out.println("Magazine Modified succesfully");
            }else{
                System.out.println("Error, there was a problem modifying the magazine");
            }


            }else if(option1 == 2 ){
                String consult = controlador.showLibroList();
                System.out.println("select the book to change");
                System.out.println(consult);

                int option_2 = Integer.valueOf(reader.nextLine()); 
                System.out.println("Type the id of the Book");
                String newLibroUnique_id = reader.nextLine();
                System.out.println("Type the name of the Book");
                String newLibroName = reader.nextLine();
                System.out.println("Write the number of pages in the Book");
                int  newLibroPages_read = Integer.valueOf(reader.nextLine());
                System.out.println("Type the date of Publication as the next Format : dd/MM/yyyy");
                String newLibroPublication_date = reader.nextLine();
                System.out.println("Type the URL for the Book");
                String newLibroUrl = reader.nextLine();
                System.out.println("Write the value of the Book");
                Double newLibroPrice = Double.valueOf(reader.nextLine());
                System.out.println("Type the sold amount of the Book");
                int newLibroSoldAmount = Integer.valueOf(reader.nextLine());
                System.out.println("Type the Review of the Book");
                String newLibroReview = reader.nextLine();
                System.out.println("Type the Gender of the Book");
                Gender newLibroGender = Gender.valueOf(reader.nextLine());

                if(controlador.libroModify(option_2, newLibroUnique_id, newLibroName, newLibroPublication_date, newLibroUrl, newLibroPages_read, newLibroPrice, newLibroSoldAmount, newLibroReview, newLibroGender)){
                    System.out.println("Book Modified succesfully");
                }else{
                    System.out.println("Error, there was a problem modifying the book");
                }
            }

        }
        public void productDelete(){
            System.out.println("what kind of product you want to delete \n1.Book \n2.Magazine");
        int typeDelete = Integer.valueOf(reader.nextLine());
        String consult = controlador.showLibroList();
        String consult_2 = controlador.showMagazineList();

            switch(typeDelete){
                case 1:
                System.out.println("books in the system");
                System.out.println(consult);
                System.out.println("Type the option of the object to delete");
                int option_2 = Integer.valueOf(reader.nextLine()); 
                if(controlador.libroDelete(option_2-1)){
                    System.out.println("Book Deleted succesfully");
                }else{
                    System.out.println("Error, there was a problem deleting the book");
                }
                break; 
                case 2:
                System.out.println("magazines in the system");
                System.out.println(consult_2);
                System.out.println("Type the option of the object to delete");
                int option = Integer.valueOf(reader.nextLine());
                if(controlador.deleteMagazine(option-1)){
                    System.out.println("Magazine Deleted succesfully"); 
                }else{
                    System.out.println("Error, there was a problem deleting the magazine");
                }
                break;

            }

        }
        public void sellProduct(){
            System.out.println("Please select the user that is going to buy");
            System.out.println(controlador.showUserList());
            int userId = Integer.valueOf(reader.nextLine());
            int bibliographicProductIndex =  -1;

            System.out.println("Please select if you want to buy a book or a Magazine \n1.Book \n2.Magazine");
            String option_1 = reader.nextLine();

            switch(option_1){
                case "1":
                System.out.println(controlador.showLibroList());
                bibliographicProductIndex = Integer.valueOf(reader.nextLine()); 
                if(controlador.bookSell(userId, bibliographicProductIndex)){
                    System.out.println("Book sold succesfully");
                }else{
                    System.out.println("Error, there was a problem selling the book");
                }
                break;
                case "2":
                System.out.println(controlador.showMagazineList());
                bibliographicProductIndex = Integer.valueOf(reader.nextLine());
                if(controlador.magazineSell(userId, bibliographicProductIndex)){
                    System.out.println("Magazine sold succesfully");
                }else{
                    System.out.println("Error, there was a problem selling the magazine");
                }
                break;
                default: 
                System.out.println("Invalid option");
                break;
            }



        }
        public void library(){

        }
        public void session(){
            System.out.println("Which type of bibliographic Product you want to read \n1.Magazine \n2.Book");
            int optionToRead = Integer.valueOf(reader.nextLine());

            switch(optionToRead){
                case 1: 
                int optionUserRd = 0; 
                System.out.println("Select the user");

                String consult = controlador.showLibroListOfUser(optionUserRd);
                System.out.println(consult);
                optionUserRd = Integer.valueOf(reader.nextLine()); 
                break; 


                case 2: 
                int optionUserRd_2 = 0; 
                System.out.println("Select the user");
                String consult_2 = controlador.showMagazineListOfUser(optionUserRd_2); 
                System.out.println(consult_2);
                optionUserRd_2 = Integer.valueOf(reader.nextLine()); 
                break; 

            }

        }
        public void subCancel(){
            int magazineId = 0; 
            int userPosition = 0; 
            String consult = controlador.showUserList(); 
            String consult_2 = controlador.showMagazineListOfUser(userPosition); 
            System.out.println("Select the User that Is Going to Cancel the Subscription");
            System.out.println(consult);
             userPosition = Integer.valueOf(reader.nextLine());
           System.out.println(consult_2);
           int magazineDelete = Integer.valueOf(reader.nextLine());
           if(controlador.subCancel(magazineDelete, userPosition-1)){
            System.out.println("Magazine suscription cancelled succesfully");

           }else{
            System.out.println("Error, there was a problem cancelled the suscription of the magazine");
           }
           
        }

   

}

