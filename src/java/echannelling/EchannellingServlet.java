/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echannelling;

import echannelling.com.serviceimpl.EchannellingWebServiceImplService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import org.apache.xml.xml_soap.Map;
import org.apache.xml.xml_soap.MapItem;

/**
 *
 * @author Zahmi
 */
@WebServlet(name = "EchannellingServlet", urlPatterns = {"/EchannellingServlet"})
public class EchannellingServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/220.247.224.152/EChannellingWebService/services/EchannellingWebServiceImpl.wsdl")
    private EchannellingWebServiceImplService service;
    private Map hospitals;
    private Map specialties;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EchannellingServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EchannellingServlet at " + request.getContextPath() + "</h1>");

            hospitals = viewHosptals();
            specialties = viewSpecialtyList();
            out.println("<form action=\"SearchDoctors\" method=\"GET\">");
            out.println(" Doctor name: <input type=\"text\" name=\"doctorName\"><br>");
            out.println("<br>");

            out.println("<select id=\"hodName\" name=\"Hospital\">");
            out.println("<option value='*'>any");
            for (MapItem hospital : hospitals.getItem()) {
                out.println("<option value=" + hospital.getKey() + ">");
                out.println(hospital.getValue());
                out.println("</option>");
            }
            out.println("</option>");
            out.println("</select>");
            out.println("<br/>");
            out.println("<br/>");


            out.println("<select id=\"specialityName\" name=\"Speciality\">");
            out.println("<option value='*'>any");
            for (MapItem specialty : specialties.getItem()) {

                out.println("<option value=" + specialty.getKey() + ">");
                out.println(specialty.getValue());
                out.println("</option>");
            }
            out.println("</option>");
            out.println("</select><br/><br/>");
            out.println("Date:<input type=\"date\" name=\"date\">");

            out.println("<br><br><input type=\"submit\" value=\"Submit\">");
            out.println("</form>");

            out.println("<form action=\"Test\" method=\"GET\">");
            out.println("<br><br><input type=\"submit\" value=\"Submit\">");
            out.println("</form>");

            out.println("<form action=\"MedicalCheckUp\" method=\"GET\">");
            out.println("<br><br><input type=\"submit\" value=\"Submit\">");
            out.println("</form>");

            //request.setAttribute("hospitals", hospitals);
            //request.getRequestDispatcher("/index.jsp").forward(request, response);
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Map viewHosptals() {

        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        echannelling.com.serviceimpl.EchannellingWebServiceImpl port = service.getEchannellingWebServiceImpl();
        return port.viewHosptals();
    }

    private Map viewSpecialtyList() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        echannelling.com.serviceimpl.EchannellingWebServiceImpl port = service.getEchannellingWebServiceImpl();
        return port.viewSpecialtyList();
    }
}
