package com.atoumi.jaxrs.cxf.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.addListener(new ContextLoaderListener(createWebAppContext()));
		addApacheCxfServlet(servletContext);
	}

	private void addApacheCxfServlet(ServletContext servletContext) {
		CXFServlet cxfServlet = new CXFServlet();

		ServletRegistration.Dynamic appServlet = servletContext.addServlet("CXFServlet", cxfServlet);
		appServlet.setLoadOnStartup(1);

		appServlet.addMapping(AppConfig.API_BASE);
	}

	private WebApplicationContext createWebAppContext() {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(AppConfig.class);
		return appContext;
	}

}