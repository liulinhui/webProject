package com.learn.servletTest.servletCycle;

import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by linkage on 2016-12-13.
 */
public class ServletTest1 extends HttpServlet {

    private static Logger logger = Logger.getLogger(HttpServlet.class);

    public void init(ServletConfig config) {
        logger.info("初始化开始");
        logger.info("ServletContext==========" + config.getServletContext() + "   " +
                "ServletName====" + config.getServletName());
        logger.info("初始化入参name======" + config.getInitParameter("name"));
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("请求方法==" + request.getMethod());
        super.service(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        session.setAttribute("new","测试新增属性");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the POST method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        session.setAttribute("new","测试修改属性");
        session.removeAttribute("new");
        out.close();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("访问方法为GET");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the GET method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    public void destroy(){
        logger.info("销毁当前ServletTest1");
    }
}
