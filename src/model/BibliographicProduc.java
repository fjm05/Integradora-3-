package model;

public abstract class BibliographicProduc {
    private String unique_id;
    private String name;
    private String publication_date;
    private String url;
    private int pages_read;
    protected Double price; 
    private int soldAmount; 
    private int [] [] library_w = new int [5] [5];
    
  


    

public BibliographicProduc(String unique_id, String name, String publication_date, String url, int pages_read, Double price , int soldAmount){
    this.unique_id = unique_id;
    this.name = name;
    this.publication_date = publication_date;
    this.url = url;
    this.pages_read = pages_read;
    this.price = price;
    this.soldAmount = soldAmount; 
    

    
}



public String getUnique_id() {
    return unique_id;
}

public void setUnique_id(String unique_id) {
    this.unique_id = unique_id;
}
public String getName(){
    return name;
}

public void setName(String name) {
    this.name = name;
}
public String getPublication_date(){
    return publication_date; 
}

public void setPublication_date(String publication_date) {
    this.publication_date = publication_date; 
}
public String getUrl(){
    return url;
}

public void setUrl(String url) {
    this.url = url;
}

public int getPages_read(){
    return pages_read;
}
public void setPages_read(int pages_read) {
    this.pages_read = pages_read;
}
public Double getPrice() {
    return price;
}
public void setPrice(Double price) {
    this.price = price;
}
public int getSoldAmount() {
    return soldAmount;
}
public void setSoldAmount(int soldAmount) {
    this.soldAmount = soldAmount;
}
public int[][] getLibrary_w() {
    return library_w;
}
public void setLibrary_w(int[][] library_w) {
    this.library_w = library_w;
}



}
