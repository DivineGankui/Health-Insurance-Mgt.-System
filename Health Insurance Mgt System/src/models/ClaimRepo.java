package models;

import db_conn.DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClaimRepo {
    private String claimId;
    private String clientId;
    private String claimType;
    private String claimStatus;
    private String claimDate;
    private double amount;

    private final Connection conn;

    // Constructor
    public ClaimRepo(String claimId, String clientId, String claimType,
                     String claimStatus, String claimDate, double amount) {
        DBAccess db = new DBAccess();
        this.conn = db.getConnection();

        this.claimId = claimId;
        this.clientId = clientId;
        this.claimType = claimType;
        this.claimStatus = claimStatus;
        this.claimDate = claimDate;
        this.amount = amount;
    }

    // Insert Claim
    public boolean insertClaim() {
        try {
            String query = "INSERT INTO claims (claim_id, client_id, claim_type, claim_status, claim_date, amount) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, claimId);
            stmt.setString(2, clientId);
            stmt.setString(3, claimType);
            stmt.setString(4, claimStatus);
            stmt.setString(5, claimDate);
            stmt.setDouble(6, amount);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update Claim
    public boolean updateClaim() {
        try {
            String query = "UPDATE claims SET client_id=?, claim_type=?, claim_status=?, claim_date=?, amount=? WHERE claim_id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, clientId);
            stmt.setString(2, claimType);
            stmt.setString(3, claimStatus);
            stmt.setString(4, claimDate);
            stmt.setDouble(5, amount);
            stmt.setString(6, claimId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Static Delete Claim by ID
    public static boolean deleteClaim(String claimId) {
        try {
            DBAccess db = new DBAccess();
            Connection conn = db.getConnection();
            String query = "DELETE FROM claims WHERE claim_id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, claimId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
