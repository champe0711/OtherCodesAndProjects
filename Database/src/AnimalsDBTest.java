
import java.sql.SQLException;
import java.sql.ResultSet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eeuc1c
 */
public class AnimalsDBTest {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException, Database.NotConnectedException{
        //creteDB
        Database db = new Database("sa", "", "AnimalsDB");
        //createTable with field
        db.update("CREATE TABLE animals (type VARCHAR(30))");
        
        //insider values
        db.update("INSERT INTO animals VALUES('dog')");
        db.update("INSERT INTO animals VALUES('cat')");
        db.update("INSERT INTO animals VALUES('fish')");
        db.update("INSERT INTO animals VALUES('bird')");
        
        //select
        ResultSet rs = db.query("SELECT * FROM animals;");
        
        //query
        while(rs.next()){
            String animalType = rs.getString(1);
            
            System.out.println(animalType);
        }
        try{
            
        }
        finally
        {
            //choose one that is required db.deleteDatabase testing purpose, db.close() will save updates
            
            
            //deleteDatabase will delete all exisiting databases within the schema i.e. all created testDatabase such as animals DB if more databases are created within this run they will also be deleted
            db.deleteDatabases();
            //db.close will commit whatever have been done to database, next run will then create error due to existing database AnimalsDB must then delete DB file manually
            //db.close();
        }
        
       
    }
    
}
