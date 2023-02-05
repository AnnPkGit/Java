package itstep.learning.oop;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Newspaper extends Literature{
    private Date date ;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat( "dd.MM.yy" ) ;

    public Newspaper(String date, String title ) throws ParseException {
            this.date = dateFormat.parse( date ) ;
            super.setTitle( title ) ;
    }

    public Date getDate() {
            return date ;
    }

    public void setDate( String date ) throws ParseException {
        this.date = dateFormat.parse( date ) ;
    }

    @Override
        public String toString() {
                return dateFormat.format( this.date ) + ": " + super.toString() ;
        }
}
