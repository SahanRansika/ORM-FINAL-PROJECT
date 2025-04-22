package healthcarecenter.dao;

import healthcarecenter.dao.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}

    public static DAOFactory getInstance(){return (daoFactory == null) ? daoFactory = new DAOFactory():daoFactory;}
    public enum DAOType{
        LOGIN,PATIENT,PAYMENT,PROGRAM,REGISTRATION,SESSION,SIGN,THERAPIST
    }
    public SuperDAO getDAO(DAOType daoType){
        switch (daoType){
            case LOGIN:
                return new LoginDAOImpl();
            case PATIENT:
                return new PatientDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            case PROGRAM:
                return new ProgramDAOImpl();
            case REGISTRATION:
                return new RegistrationDAOImpl();
            case SESSION:
                return new SessionDAOImpl();
            case SIGN:
                return new SignDAOImpl();
            case THERAPIST:
                return new TherapistDAOImpl();
            default:
                return null;
        }
    }
}
