package itstep.learning.oop;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hologram extends Literature implements Presentable{
    private Date dateOfRecord ;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat( "dd.MM.yy" ) ;

    public Hologram(String dateOfRecord, String title ) throws ParseException {
        this.dateOfRecord = dateFormat.parse( dateOfRecord ) ;
        super.setTitle( title ) ;
    }

    public Date getAuthor() {
        return dateOfRecord ;
    }

    public void Date  ( String dateOfRecord) throws ParseException {
        this.dateOfRecord = dateFormat.parse( dateOfRecord ) ;
    }

    @Override
    public String toString() {
        return this.dateOfRecord + ": " + super.toString() ;
    }
}
