import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
import com.usc.web.JSONObject;
import com.usc.web.XML;
public class HelloWorldExample extends HttpServlet {
 public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException
    {  
	try
	{
      	String stock_symbol=request.getParameter("stock_symbol");
      	String urlString="http://Default-Environment-i5fmgggdt5.elasticbeanstalk.com/?stock_symbol="+stock_symbol;
	URL url = new URL(urlString); 
        URLConnection urlConnection = url.openConnection();
        urlConnection.setAllowUserInteraction(false); 
        InputStream urlStream = url.openStream(); 
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String xml_string;
        StringBuffer s=new StringBuffer();
        while ((xml_string = in.readLine()) != null) {
         
		  s.append(xml_string);
        }	
        in.close();
        JSONObject xmlJSONObj = XML.toJSONObject(s.toString());
       	response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(xmlJSONObj);
        out.flush();
       }
	   catch (IOException e) {
    System.err.println("Caught IOException: " + e.getMessage());}
	catch (ServletException e) {
    System.err.println("Caught ServletException: " + e.getMessage());}
		}
		}


