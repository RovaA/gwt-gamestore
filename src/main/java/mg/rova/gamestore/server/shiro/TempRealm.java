package mg.rova.gamestore.server.shiro;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;

import mg.rova.gamestore.server.domain.User;

public class TempRealm {

	public static boolean isLoggedIn(HttpSession session) {
		// return session != null &&
		// "YES".equals(session.getAttribute("LoggedIn"));
		return SecurityUtils.getSubject().isAuthenticated();
	}

	public static boolean login(String username, String password, HttpSession session) {
		if (session == null)
			return false;
		/*final User user = authenticate(username, password);

		if (user == null)
			return false;

		session.setAttribute("identifiant", user.getId());
		session.setAttribute("LoggedIn", "YES");
		if (user.getIsAdmin() == null || !user.getIsAdmin()) {
			session.setAttribute("isAdmin", "notAdmin");
		} else {
			session.setAttribute("isAdmin", "isAdmin");
		}
		try {
			final UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			final Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			return true;
		} catch (UnknownAccountException uae) {
			return false;
		} catch (IncorrectCredentialsException ice) {
			return false;
		} catch (LockedAccountException lae) {
			return false;
		} catch (AuthenticationException ae) {
			return false;
		}*/
		return false;
	}

	protected static User authenticate(String username, String password) {
		/*return GuiceFactory.getInstance(UserDao.class).authenticate(username, password);*/
		return null;
	}

	public static boolean logout(HttpSession session) {
		if (session == null)
			return false;
		session.removeAttribute("LoggedIn");
		SecurityUtils.getSubject().logout();
		return true;
	}
}
