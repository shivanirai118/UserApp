

	

import java.io.*;

import java.sql.*;

import javax.servlet.ServletException;

import javax.servlet.http.*;

public class Search extends HttpServlet {

       public void doGet(HttpServletRequest request, HttpServletResponse response)

                     throws ServletException, IOException {

              response.setContentType("text/html");

              PrintWriter out = response.getWriter();        

              String EMAILID=request.getParameter("EMAILID");                          

              try{

                     Class.forName("oracle.jdbc.driver.OracleDriver");

                     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");               

                     PreparedStatement ps=con.prepareStatement("select * from USERLOGIN where EMAILID=?");

                     ps.setString(1,EMAILID);                   

                     out.print("<table width=25% border=1>");

                     out.print("<center><h1>Result:</h1></center>");

                     ResultSet rs=ps.executeQuery();                

                     /* Printing column names */

                     ResultSetMetaData rsmd=rs.getMetaData();

                     while(rs.next())

                        {

                     out.print("<tr>");

                     out.print("<td>"+rsmd.getColumnName(1)+"</td>");

                        out.print("<td>"+rs.getString(1)+"</td></tr>");

                        out.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");

                        out.print("<td>"+rs.getString(2)+"</td></tr>");

                        out.print("<tr><td>"+rsmd.getColumnName(3)+"</td>");

                        out.print("<td>"+rs.getString(3)+"</td></tr>");

                        out.print("<tr><td>"+rsmd.getColumnName(4)+"</td>");

                        out.print("<td>"+rs.getString(4)+"</td></tr>"); 
                        
                        out.print("<tr><td>"+rsmd.getColumnName(5)+"</td>");

                        out.print("<td>"+rs.getString(5)+"</td></tr>");    
                        
                        out.print("<tr><td>"+rsmd.getColumnName(6)+"</td>");

                        out.print("<td>"+rs.getString(6)+"</td></tr>"); 
                        
                        out.print("<tr><td>"+rsmd.getColumnName(7)+"</td>");

                        out.print("<td>"+rs.getString(7)+"</td></tr>");    
                        
                        out.print("<tr><td>"+rsmd.getColumnName(8)+"</td>");

                        out.print("<td>"+rs.getString(8)+"</td></tr>");      

                     }

                     out.print("</table>");

 

              }catch (Exception e2)

                {

                    e2.printStackTrace();

                }

 

              finally{out.close();

                }

       }

 

} 
	
	

