package com.sara.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
@WebInitParam(name="name", value="value")

public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String first_name,last_name,language,town;
		
	    if(request.getParameter("first_name") != null){
	    	first_name = request.getParameter("first_name");
	    }	
	    else 
	    {
	    	first_name = "Unknown";
	    }
	    
	    if(request.getParameter("last_name") != null){
			last_name = request.getParameter("last_name");
	    }
	    else 
	    {
	    	last_name = "Unknown";
	    }
	    
	    if(request.getParameter("language") != null){
			language = request.getParameter("language");
	    }
	    else 
	    {
	    	language = "Unknown";
	    }
	    
	    if(request.getParameter("town") != null){
			town  = request.getParameter("town");
	    }
	    else 
	    {
	    	town = "Unknown";
	    }
	    
		
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("Welcome " + first_name +" "+last_name+"<br>"+"your favorite langugae is "+language+"<br>"+"your town is "+town);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
