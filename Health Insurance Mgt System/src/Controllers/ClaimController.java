package Controllers;

import models.ClaimRepo;

public class ClaimController {

    public boolean addClaim(ClaimRepo claim) {
        return claim.insertClaim();
    }

    public boolean updateClaim(ClaimRepo claim) {
        return claim.updateClaim();
    }

    public boolean deleteClaim(String claimId) {
        // Call static method from ClaimRepo
        return ClaimRepo.deleteClaim(claimId);
    }
}
