package net.mybluemix.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.Language;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/bluemix")
public class BluemixServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().print(translateToSpanish("This is a test"));
	}

	private String translateToSpanish(String text) {

		LanguageTranslation service = new LanguageTranslation();
		System.out.println("bluemix.endpoint="+service.getEndPoint());
		service.setEndPoint("https://gateway.watsonplatform.net/language-translator/api");
		service.setUsernameAndPassword("9420c40d-955a-4521-ba66-cfc5e8e03165", "G5rX2HgR2XgH");
		TranslationResult translationResult = service.translate(text, Language.ENGLISH, Language.SPANISH).execute();
		String result = translationResult.getFirstTranslation();
		System.out.println("bluemix.result="+result);
		return result;
	}

}
