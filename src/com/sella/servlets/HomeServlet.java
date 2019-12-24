package com.sella.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {

  /**
   * 
  */
  private static final long serialVersionUID = 1L;

  private static final String HTML_START = "<html><body>";
  private static final String HTML_END = "</html></body>";

  @Override
  public void init() throws ServletException {
    System.out.println("servlet init method called");
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {   
    System.out.println("servlet doGet method called req:"+req+" resp :"+resp);
    int visitingCount = 1;
    Cookie[] cookies = req.getCookies();
    for(Cookie cookie : cookies) {
      System.out.println("Name :"+cookie.getName()+", value :"+cookie.getValue());
      if("visitingCount".equalsIgnoreCase(cookie.getName())) {
        visitingCount = Integer.parseInt(cookie.getValue()) + 1;
      }
    }
    Cookie userCookie = new Cookie("visitingCount", String.valueOf(visitingCount));
    userCookie.setMaxAge(60 * 60);
    resp.addCookie(userCookie);
    if(visitingCount > 2) {
      // If you want to transfer the call to another web application which is deployed in the same server we can use the below call.
      // This below call has to work we have to add context.xml file in META-INF folder with the below code then we can call the other web application from one to another
      // <Context crossContext="true" />
      getServletConfig().getServletContext().getContext("/SingleThreadModelEx").getRequestDispatcher("/home/homeServlet").forward(req, resp);
    } else {
      PrintWriter writer = resp.getWriter();
      LocalDate now = LocalDate.now();
      writer.append(HTML_START);
      writer.append("<h3>Hi, Sample servlet application</h3>");
      writer.append("<p>").append(now.toString()).append("</p>");
      writer.append(HTML_END);
      writer.close();
    }
  }

  @Override
  public void destroy() {
    System.out.println("servlet destroy method called :");
  }
}
