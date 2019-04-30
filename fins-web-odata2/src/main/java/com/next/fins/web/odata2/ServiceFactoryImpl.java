package com.next.fins.web.odata2;

import javax.persistence.EntityManagerFactory;

import org.apache.olingo.odata2.api.ODataCallback;
import org.apache.olingo.odata2.api.processor.ODataErrorCallback;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;

public class ServiceFactoryImpl extends ODataJPAServiceFactory {

	private static final int PAGE_SIZE = 5;

	private EntityManagerFactory emf;

	public ServiceFactoryImpl(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException 
	{
		ODataJPAContext oDataJPAContext = getODataJPAContext();
		oDataJPAContext.setEntityManagerFactory(emf);
		oDataJPAContext.setPersistenceUnitName("default");
		oDataJPAContext.setPageSize(PAGE_SIZE);
		setDetailErrors(true);
		return oDataJPAContext;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends ODataCallback> T getCallback(final Class<T> callbackInterface) {
		{
			if (callbackInterface.isAssignableFrom(ODataErrorCallback.class)) {
				return (T) new CallbackImpl();
			}
		}

		return super.getCallback(callbackInterface);
	}
}
