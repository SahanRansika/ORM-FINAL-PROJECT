package healthcarecenter.bo;

import healthcarecenter.bo.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){}
    public static BOFactory getInstance(){
        return boFactory == null ? new BOFactory():boFactory;
    }
    public enum BOType{
        Patient,Payment,Program,Registration,Sessions,Therapist
    }
    public SuperBO getBO(BOType boType){
        switch (boType){
            case Patient -> {
                return new PatientBOImpl();
            }
            case Payment -> {
                return new PaymentBOImpl();
            }
            case Program -> {
                return new ProgramBOImpl();
            }
            case Registration -> {
                return new RegistrationBOImpl();
            }
            case Sessions -> {
                return new SessionsBOImpl();
            }
            case Therapist -> {
                return new TherapistBOImpl();
            }
            default -> {
                return null;
            }
        }
    }
}
