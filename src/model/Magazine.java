package model;



public class Magazine extends BibliographicProduc {
    private Category category; 
    private String published; 
    private int suscriptions; 


    public Magazine(String unique_id, String name, String publication_date, String url, int pages_read, Category category, String published, int suscriptions, Double price, int soldAmount) {
        super(unique_id, name, publication_date, url, pages_read, price, soldAmount);
       this.category = category; 
       this.published = published;
       this.suscriptions = suscriptions;

    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public String getPublished() {
        return published;
    }
    public void setPublished(String published) {
        this.published = published;
    }
    public int getSuscriptions() {
        return suscriptions;
    }
    public void setSuscriptions(int suscriptions) {
        this.suscriptions = suscriptions;
    }


    
}

