package com.learn.servletTest.servletCycle;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Created by linkage on 2016-12-15.
 */
@MultipartConfig
@WebServlet("/ServletTest2.do")
public class ServletTest2 extends HttpServlet{

}
