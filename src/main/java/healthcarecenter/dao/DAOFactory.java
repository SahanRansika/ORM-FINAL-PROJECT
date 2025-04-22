package healthcarecenter.dao;

import healthcarecenter.dao.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return daoFactory == null ? new DAOFactory():daoFactory;
    }
    public enum DAOType{
        PATIENT,PAYMENT,PROGRAM,REGISTRATION,SESSION,THERAPIST
    }
    public SuperDAO getDAO(DAOType daoType){
        switch (daoType){
            case PATIENT -> {
                return new PatientDAOImpl();
            }
            case PAYMENT -> {
                return new PaymentDAOImpl();
            }
            case PROGRAM -> {
                return new ProgramDAOImpl();
            }
            case REGISTRATION -> {
                return new RegistrationDAOImpl();
            }
            case SESSION -> {
                return new SessionsDAOImpl();
            }
            case THERAPIST -> {
                return new TherapistDAOImpl();
            }
            default -> {
                return null;
            }
        }
    }
}
