

package connecttosqldatabase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    public static void main(String[] args) {
        // JDBC kapcsolódási információk
        String url = "jdbc:sqlserver://172.17.65.133:1433;databaseName=SzemelyesAdatok;encrypt=false;trustServerCertificate=true";
        String username = "ujfelhasznalo";
        String password = "Start123";

        // JDBC kapcsolat létrehozása
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Kapcsolódás sikeres!");

            // Lekérdezés végrehajtása
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM SzemelyesAdatok.dbo.Adatok");

            // Eredmények megjelenítése
            while (resultSet.next()) {
                System.out.println("Név: " + resultSet.getString("Nev"));
                System.out.println("Születési Helye: " + resultSet.getString("Szuletesihely"));
                System.out.println("Anyja Neve: " + resultSet.getString("Anyjaneve"));
            }
        } catch (SQLException e) {
            System.out.println("Kapcsolódási hiba:");
             System.out.println("Connection Error: " + e.getMessage());
        }
    }
}
