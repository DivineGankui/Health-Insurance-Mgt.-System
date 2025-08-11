package models;

import db_conn.DBAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PolicyRepo {
    private String id;
    private String policyType;
    private double coverageAmount;

    // Constructor
    public PolicyRepo(String id, String policyType, double coverageAmount) {
        this.id = id;
        this.policyType = policyType;
        this.coverageAmount = coverageAmount;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getPolicyType() {
        return policyType;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public void setCoverageAmount(double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }


    // Database Access

    // Add Policy
    public boolean addPolicy() {
        String sql = "INSERT INTO policies (id, policyType, coverageAmount) VALUES (?, ?, ?)";
        try (Connection conn = new DBAccess().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, this.id);
            stmt.setString(2, this.policyType);
            stmt.setDouble(3, this.coverageAmount);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("❌ Error adding policy: " + e.getMessage());
            return false;
        }
    }

    // Update Policy
    public boolean updatePolicy() {
        String sql = "UPDATE policies SET policyType = ?, coverageAmount = ? WHERE id = ?";
        try (Connection conn = new DBAccess().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, this.policyType);
            stmt.setDouble(2, this.coverageAmount);
            stmt.setString(3, this.id);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("❌ Error updating policy: " + e.getMessage());
            return false;
        }
    }

    // Delete Policy
    public static boolean deletePolicy(String id) {
        String sql = "DELETE FROM policies WHERE id = ?";
        try (Connection conn = new DBAccess().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("❌ Error deleting policy: " + e.getMessage());
            return false;
        }
    }
}


