package mg.rova.gamestore.client.request;

import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

import mg.rova.gamestore.server.domain.dao.UserDao;
import mg.rova.gamestore.server.domain.locator.DAOServiceLocator;

@Service(value = UserDao.class, locator = DAOServiceLocator.class)
public interface UserRequestContext extends RequestContext {

}