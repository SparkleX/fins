package com.next.fins.web.odata2;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.olingo.odata2.core.servlet.ODataServlet;
import org.springframework.beans.factory.annotation.Autowired;


@WebServlet(urlPatterns="/odata2/*")
public class OData2Servlet extends ODataServlet 
{
	private static final long serialVersionUID = -4563879895896080797L;

	@Autowired
	EntityManagerFactory emf;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException 
	{
		if(!req.getMethod().equalsIgnoreCase("get"))
		{
			throw new RuntimeException("odata2 service is read only");
		}
		ServiceFactoryImpl oDataServiceFactory = new ServiceFactoryImpl(emf);
		req.setAttribute("org.apache.olingo.odata2.service.factory.instance", oDataServiceFactory);
		super.service(req, resp);
	}


}
