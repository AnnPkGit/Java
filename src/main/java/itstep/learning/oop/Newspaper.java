package itstep.learning.oop;
import java.time.LocalDate;
import java.util.Date;

public class Newspaper extends Literature{
    private LocalDate date ;

    public Newspaper(LocalDate date, String title ) {
            this.date = date ;
            super.setTitle( title ) ;
    }

    public LocalDate getDate() {
            return date ;
    }

    public void setDate( LocalDate date ) {
            this.date = date ;
    }

    @Override
        public String toString() {
                return this.date + ": " + super.toString() ;
        }
}
