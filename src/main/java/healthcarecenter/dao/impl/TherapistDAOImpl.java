package healthcarecenter.dao.impl;

import healthcarecenter.dao.CrudDAO;
import healthcarecenter.entity.Therapist;

public class TherapistDAOImpl implements CrudDAO<Therapist> {
    @Override
    public boolean save(Therapist entity) {
        return false;
    }

    @Override
    public boolean update(Therapist entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public String generateNewId() {
        return "";
    }
}
