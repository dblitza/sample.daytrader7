package com.ibm.websphere.samples.daytrader.web.prims;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/PingServletCDI")
public class PingServletCDI extends HttpServlet {

	private static final long serialVersionUID = -1803544618879689949L;
	private static String initTime;
	
	@Inject
    PingCDIBean cdiBean;

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter pw = response.getWriter();
        pw.write("<html><head><title>Ping Servlet CDI</title></head>"
                + "<body><HR><BR><FONT size=\"+2\" color=\"#000066\">Ping Servlet CDI<BR></FONT><FONT size=\"+1\" color=\"#000066\">Init time : " + initTime
                + "<BR><BR></FONT>");
        
        
        pw.write("<B>hitCount: " +  cdiBean.hello() + "</B><BR>");
       
        pw.flush();
        pw.close();

    }
    
    /**
     * called when the class is loaded to initialize the servlet
     *
     * @param config
     *            ServletConfig:
     **/
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        initTime = new java.util.Date().toString();
 

    }
}