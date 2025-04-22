package healthcarecenter.bo.impl;

import healthcarecenter.bo.SignBO;
import healthcarecenter.dao.DAOFactory;
import healthcarecenter.dao.impl.SignDAOImpl;

public class SignBOImpl implements SignBO {
    SignDAOImpl signDAO = (SignDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.SIGN);
}
