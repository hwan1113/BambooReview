package common.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionCounterListener implements HttpSessionListener{

	private static int activeSessions;
	
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session  = se.getSession();
		System.out.println("[sid@SessionCounterListener.sessionCreated="+session.getId()+"]");
		//생성된 세션객체수 1증가
		activeSessions++;
		System.out.println("[현재 세션객체수: "+activeSessions+"]");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.out.println("[sid@SessionCounterListener.sesionDestroyed="+session.getId()+"]");
		activeSessions--;
		System.out.println("[현재 세션객체수: "+activeSessions+"]");
		
	}
	
	
}
