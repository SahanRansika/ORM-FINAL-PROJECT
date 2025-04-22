package healthcarecenter.bo;

import healthcarecenter.bo.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){}
    public static BOFactory getInstance(){return (boFactory == null ? boFactory = new BOFactory():boFactory);}
    public enum BOType{
        Login,Patient,Payment,Program,Registration,Session,Sign,Therapist
    }
    public SuperBO getBO(BOType boType){
        switch (boType){
            case Login:
                return new LoginBOImpl();
            case Patient:
                return new PatientBOImpl();
            case Payment:
                return new PaymentBOImpl();
            case Program:
                return new ProgramBOImpl();
            case Registration:
                return new RegistrationBOImpl();
            case Session:
                return new SessionBOImpl();
            case Sign:
                return new SignBOImpl();
            case Therapist:
                return new TherapistBOImpl();
            default:
                return null;
        }
    }
}
