/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package echannelling;

import echannelling.com.serviceimpl.ArrayOfXsdAnyType;
import echannelling.com.serviceimpl.EchannellingWebServiceImplService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author murugaiahb
 */
@WebServlet(name = "MedicalCheckUp", urlPatterns = {"/MedicalCheckUp"})
public class MedicalCheckUp extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/220.247.224.152/EChannellingWebService/services/EchannellingWebServiceImpl.wsdl")
    private EchannellingWebServiceImplService service;
    ArrayOfXsdAnyType array;

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MedicalCheckUp</title>");
            out.println("</head>");
            out.println("<body>");

            array = checkupHospitals();
            out.println(array.getItem().size());



            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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

    private ArrayOfXsdAnyType checkupHospitals() {
        echannelling.com.serviceimpl.EchannellingWebServiceImpl port = service.getEchannellingWebServiceImpl();
        return port.checkupHospitals();
    }
}
