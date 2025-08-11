package models;

import db_conn.DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientRepo {
    private String clientId;
    private String name;
    private String address;
    private String phone;
    private String email;

    // Constructor
    public ClientRepo(String clientId, String name, String address, String phone, String email) {
        this.clientId = clientId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    // Getters
    public String getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }


    //Setters
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // INSERT
    public boolean insertClient() {
        String sql = "INSERT INTO clients (client_id, name, address, phone, email) VALUES ('C002', 'Jane Doe', 'Tema', '0551234567', 'jane@example.com')";

        try (Connection conn = new DBAccess().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, clientId);
            stmt.setString(2, name);
            stmt.setString(3, address);
            stmt.setString(4, phone);
            stmt.setString(5, email);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("❌ Insert error: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public static boolean deleteClient(String clientId) {
        String sql = "DELETE FROM clients WHERE client_id = 'C002'";
        try (Connection conn = new DBAccess().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, clientId);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("❌ Delete error: " + e.getMessage());
            return false;
        }
    }
}

