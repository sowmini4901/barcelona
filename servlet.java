import javax.servlet.http.*;
import java.io.*; 
import java.util.*; 
 
public class CookieServlet extends HttpServlet {

public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException  {

PrintWriter out = response.getWriter(); 
 
  Cookie[] c = request.getCookies(); 
  String user = null; 
  String responseString = null; 
 
  if ( c != null ) 
  { 
  for ( int x = 0; x < c.length; x++ )  
  {     String name = c[x].getName();   
  if ( name.equals("session_id") )    
  { 
  if((c[x].getValue()).equals("561"))   
  {       user = new String("ANUCE");  
  break;    
  }   
  } 
  } 
  } 

   if ( user == null ) 
   {    response.addCookie(new Cookie("session_id", "561")); 
   
   responseString = new String("Welcome to our site,we have created a session for you.");  
   }  
   else 
   {    responseString = new String("Hello : " + user);   } 
   
 
  out.println("<html>"); 
  out.println("<body>");
  out.println(responseString);
  out.println("</body></html>");  } 
 
} 
 
