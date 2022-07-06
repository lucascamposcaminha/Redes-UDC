package es.udc.redes.webserver;

import es.udc.redes.webserver.MiniServlet;

import java.util.Map;


public class MyServlet implements MiniServlet {
	
	/* For the correct operation, a public constructor without parameters 
	 * is necessary */
	public MyServlet(){
		
	}
	
	public String doGet (Map<String, String> parameters){
		String name = parameters.get("name");
		String firstSurname = parameters.get("firstSurname");
		String secondSurname = parameters.get("secondSurname");
		String fullName = name + " " + firstSurname + " " + secondSurname;
		
		return printHeader() + printBody(fullName) + printEnd();
	}	

	private String printHeader() {
		return "<html><head> <title>Greetings</title> </head> ";
	}

	private String printBody(String fullName) {
		return "<body> <h1> Hola " + fullName + "</h1></body>";
	}

	private String printEnd() {
		return "</html>";
	}
}
