package model;



public class Libro extends BibliographicProduc {
    private String review; 
    private Gender gender; 
    public Libro(String unique_id, String name, String publication_date, String url, int pages_read, Double price, int soldAmount, String review, Gender gender){
        super(unique_id, name, publication_date, url, pages_read, price, soldAmount);
        this.review = review;
        this.gender = gender;
        
    }

    
    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }  
      
}