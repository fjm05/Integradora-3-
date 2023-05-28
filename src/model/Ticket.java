package model;
import java.util.Calendar;

public class Ticket {
    private Calendar dates; 
    private Double value; 

    public Ticket(Calendar dates, Double value){
        this.dates = dates;
        this.value = value;

    }
    public Calendar getDates() {
        return dates;
    }
    public void setDates(Calendar dates){
        this.dates = dates;
    }
    public Double getValue() {
        return value;
    }
    public void setValue(Double value){
        this.value = value;
    }
}
