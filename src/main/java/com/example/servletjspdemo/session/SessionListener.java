package com.example.servletjspdemo.session;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;

@WebListener
public class SessionListener implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
			System.out.println("[SESSION] CREATED: " + new Date());
		
		HttpSession session = httpSessionEvent.getSession();
		session.setAttribute("counter", new Counter());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
			System.out.println("[SESSION] DESTROYED: " + new Date());
	}
}