/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package echannelling;

import echannelling.com.serviceimpl.EchannellingWebServiceImplService;
import echannelling.com.serviceimpl.SearchValues;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import org.apache.xml.xml_soap.Map;
import org.apache.xml.xml_soap.MapItem;
import echannelling.com.serviceimpl.*;

/**
 *
 * @author murugaiahb
 */
@WebServlet(name = "SearchDoctors", urlPatterns = {"/SearchDoctors"})
public class SearchDoctorsPage extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/220.247.224.152/EChannellingWebService/services/EchannellingWebServiceImpl.wsdl")
    private EchannellingWebServiceImplService service;
    SearchValues values;
    Map result, resultSession;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        values = new SearchValues();
//        result = new Map();

    }

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
            out.println("<title>Servlet SearchDoctors</title>");
            out.println("</head>");
            out.println("<body>");

            out.println(request.getParameter("doctorName"));
            out.println(request.getParameter("Hospital"));
            out.println(request.getParameter("Speciality"));

            values.setDocLastName("perera");
            values.setAppointmentDate("Any");
            values.setHospitalId("*");
            values.setSpecialityId("*");
//            values.setRemarks("*");

            result = viewDocList(values);

            if (result == null) {
                out.println("null");
            } else {
                out.println("nn");
                out.println(result.getItem().size());

            }
            out.println("<br/>");

            SearchDoctors doc;
            

            for (int i = 0; i < result.getItem().size(); i++) {
                doc = (SearchDoctors) result.getItem().get(i).getValue();
                out.println(doc.getDocName());
                
                out.println(doc.getSpecName());
                out.println(doc.getHosName());
                out.println(doc.getAppDate());
                out.println(doc.getAppDay());

                

                out.println("<br/>");
            }


//            doc = (SearchDoctors) result.getItem().get(0).getValue();
//
//            resultSession=viewSessionDetails(doc);
//
//            SessionDetatials sessionDetails;
//            SessionDetatials sessionDetails2;
//            
//            sessionDetails=(SessionDetatials)resultSession.getItem().get(0).getValue();
//            out.println(sessionDetails.getDocname()+"<br/>"+
//            sessionDetails.getHosname()+"<br/>"+
//            sessionDetails.getSday()+"<br/>"+
//                    sessionDetails.getAppDate()+"<br/>"+
//                    sessionDetails.getNextLink()+"<br/>"+
//                    sessionDetails.getTday()+"<br/>"+
//                    sessionDetails.getTtime());
//            
//                                        out.println("<br/>");
//                            out.println("<br/>");
//
//            sessionDetails=(SessionDetatials)resultSession.getItem().get(0).getValue();
//            out.println(sessionDetails.getAppDate()+"<br/>"+
//                    sessionDetails.getDocname()+"<br/>"+
//                    sessionDetails.getDocno()+"<br/>"+
//                    sessionDetails.getHosSequenceNumber()+"<br/>"+
//                    sessionDetails.getHosid()+"<br/>"+
//                    sessionDetails.getHosloc()+"<br/>"+
//                    sessionDetails.getHosname()+"<br/>"+
//                    sessionDetails.getNextLink()+"<br/>"+
//                    sessionDetails.getReferenceNumber()+"<br/>"+
//                    sessionDetails.getRemark()+"<br/>"+
//                    sessionDetails.getSday()+"<br/>"+
//                    sessionDetails.getShowDate()+"<br/>"+
//                    sessionDetails.getSmonth()+"<br/>"+
//                    sessionDetails.getSpec()+"<br/>"+
//                    sessionDetails.getSpecID()+"<br/>"+
//                    sessionDetails.getSyear()+"<br/>"+
//                    sessionDetails.getTdate()+"<br/>"+
//                    sessionDetails.getTday()+"<br/>"+
//                    sessionDetails.getTtime()+"<br/>"+
//                    sessionDetails.getClass());
//            
//            out.println("<br/>");
//                            out.println("<br/>");
//
//            sessionDetails=(SessionDetatials)resultSession.getItem().get(1).getValue();
//            out.println(sessionDetails.getAppDate()+"<br/>"+
//                    sessionDetails.getDocname()+"<br/>"+
//                    sessionDetails.getDocno()+"<br/>"+
//                    sessionDetails.getHosSequenceNumber()+"<br/>"+
//                    sessionDetails.getHosid()+"<br/>"+
//                    sessionDetails.getHosloc()+"<br/>"+
//                    sessionDetails.getHosname()+"<br/>"+
//                    sessionDetails.getNextLink()+"<br/>"+
//                    sessionDetails.getReferenceNumber()+"<br/>"+
//                    sessionDetails.getRemark()+"<br/>"+
//                    sessionDetails.getSday()+"<br/>"+
//                    sessionDetails.getShowDate()+"<br/>"+
//                    sessionDetails.getSmonth()+"<br/>"+
//                    sessionDetails.getSpec()+"<br/>"+
//                    sessionDetails.getSpecID()+"<br/>"+
//                    sessionDetails.getSyear()+"<br/>"+
//                    sessionDetails.getTdate()+"<br/>"+
//                    sessionDetails.getTday()+"<br/>"+
//                    sessionDetails.getTtime()+"<br/>"+
//                    sessionDetails.getClass());






//            sessionDetails2=getTime();
//            
//                                        out.println("<br/>");
//
//            sessionDetails=(SessionDetatials)resultSession.getItem().get(0).getValue();
//            out.println(sessionDetails.getDocname()+"<br/>"+
//            sessionDetails.getHosname()+"<br/>"+
//            sessionDetails.getSday()+"<br/>"+
//                    sessionDetails.getAppDate()+"<br/>"+
//                    sessionDetails.getNextLink()+"<br/>"+
//                    sessionDetails.getTday()+"<br/>"+
//                    sessionDetails.getTtime());




            out.println(resultSession.getItem().size());



//            sessionDetails=(SessionDetatials)resultSession.getItem().g
//            for (MapItem specialty : result.getItem()) {
//
////                out.println("<option value=" + specialty.getKey() + ">");
////                 out.println(specialty.getKey());
//                out.println(specialty.getValue());
//                out.println(specialty.getValue());
//
//                out.println(specialty.getValue());
//                out.println("<br/>");
////                out.println("</option>");
//            }

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

    private Map viewDocList(echannelling.com.serviceimpl.SearchValues searchValues) {
        echannelling.com.serviceimpl.EchannellingWebServiceImpl port = service.getEchannellingWebServiceImpl();
        return port.viewDocList(searchValues);
    }

    private int viewAppointmentNumber(echannelling.com.serviceimpl.SessionDetatials sessionDetatials) {
        echannelling.com.serviceimpl.EchannellingWebServiceImpl port = service.getEchannellingWebServiceImpl();
        return port.viewAppointmentNumber(sessionDetatials);
    }

    private Map viewSessionDetails(echannelling.com.serviceimpl.SearchDoctors searchDoctors) {
        echannelling.com.serviceimpl.EchannellingWebServiceImpl port = service.getEchannellingWebServiceImpl();
        return port.viewSessionDetails(searchDoctors);
    }

    private AppointmentDetails getTime(echannelling.com.serviceimpl.AppointmentDetails appointmentDetails) {
        echannelling.com.serviceimpl.EchannellingWebServiceImpl port = service.getEchannellingWebServiceImpl();
        return port.getTime(appointmentDetails);
    }
}
