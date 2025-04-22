package healthcarecenter.bo.impl;

import healthcarecenter.bo.LoginBO;
import healthcarecenter.dao.DAOFactory;
import healthcarecenter.dao.LoginDAO;
import healthcarecenter.dao.impl.LoginDAOImpl;

public class LoginBOImpl implements LoginBO {
    LoginDAOImpl loginDAO =(LoginDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.LOGIN);
}
