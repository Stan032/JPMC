package jPMC;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class BankServlet extends HttpServlet {

	/**
	 * I dont have experience with REST API so this is the best i cloud come up
	 * with.
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String requestUrl = request.getRequestURI();
		String link = requestUrl.substring("/sources/".length());

		Bank bank = Request.getInstance().getBank(link);

		if (bank != null) {

			String json = "{\n";
			json += "\"Account Number\": " + bank.getAccountNumber() + "\n";
			json += "\"source1\": " + JSONObject.quote(bank.getSource1()) + ",\n";
			json += "\"Source2\": " + JSONObject.quote(bank.getSource2()) + ",\n";
			json += "}";

		} else {
			// That person wasn't found, so return an empty JSON object. We could also
			// return an error.
			response.getOutputStream().println("No Source Found");
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int accountNumber = Integer.parseInt(request.getParameter("Account Number"));
		String source1 = request.getParameter("Source1");
		String source2 = request.getParameter("Source2");

		Request.getInstance().putBank(new Bank(source1, source2, accountNumber));
	}
}

//		