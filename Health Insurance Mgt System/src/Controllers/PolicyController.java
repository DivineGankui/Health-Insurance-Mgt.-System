package Controllers;

import models.PolicyRepo;

public class PolicyController {

    public boolean addPolicy(PolicyRepo policy) {
        return policy.addPolicy();
    }

    public boolean updatePolicy(PolicyRepo policy) {
        return policy.updatePolicy();
    }

    public boolean deletePolicy(String id) {
        return PolicyRepo.deletePolicy(id);
    }
}
