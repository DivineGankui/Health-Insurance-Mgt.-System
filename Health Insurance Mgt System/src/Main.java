import Controllers.ClaimController;
import Controllers.ClientController;
import Controllers.PolicyController;
import db_conn.DBAccess;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        // Initialize database connection
        DBAccess db = new DBAccess();
        Connection conn = db.getConnection();

        if (conn != null) {
            System.out.println("✅ Connected to database successfully.");


        //Initialize controllers
            new ClientController();
            new PolicyController();
            ClaimController ClaimController = new ClaimController();

        } else {
            System.out.println("❌ Could not connect to the database.");
        }
    }
}
