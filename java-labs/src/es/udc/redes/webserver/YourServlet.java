package es.udc.redes.webserver;
import java.util.Map;

/**
 * This class must be filled to complete servlets option (.do requests).
 */
public class YourServlet implements MiniServlet {
	

	public YourServlet(){
		
	}

        @Override
	public String doGet (Map<String, String> parameters){
		

		return "";
	}	

	private String printHeader() {
		return "";
	}


	private String printBody(String message) {
		return "";
	}

	private String printEnd() {
		return "";
	}
}
