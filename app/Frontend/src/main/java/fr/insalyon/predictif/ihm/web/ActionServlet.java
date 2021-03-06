/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.predictif.ihm.web;

import fr.insalyon.dasi.dao.JpaUtil;
import fr.insalyon.predictif.ihm.web.action.*;
import fr.insalyon.predictif.ihm.web.serialisation.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zakaria
 */
@WebServlet(name = "ActionServlet", urlPatterns = {"/ActionServlet"})
public class ActionServlet extends HttpServlet {
    
     @Override
    public void init() throws ServletException {
        super.init();
        JpaUtil.init();
    }

    @Override
    public void destroy() {
        JpaUtil.destroy();
        super.destroy();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        request.setCharacterEncoding("UTF-8");

        String todo = request.getParameter("todo");

        Action action = null;
        Serialisation serialisation = null;

        if (todo != null) {
            switch (todo) {
                case "connecter":
                    action = new AuthentifierUserAction();
                    serialisation = new ProfilUserSerialisation();
                    break;
                case "showMediums":
                    action = new AfficherMediumsAction();
                    serialisation = new MediumSerialisation();
                    break;
                case "Deconnecter":
                    action = new Deconnexion();
                    serialisation = new DeconnexionSerialisation();
                    break;
                case "signup":
                    action = new InscrireClientAction();
                    serialisation = new InscrireClientSerialisation();
                    break;
                case "showProfile":
                    action = new DisplayProfileAction();
                    serialisation = new DisplayProfileSerialisation();
                    break;
                case "showConsultations":
                    action = new AfficherConsultations();
                    serialisation = new ConsultationsSerialisation();
                    break;
                case "requestConsultation":
                    action = new DemanderConsultationsAction();
                    serialisation = new DemanderConsultationsSerialisation();
                    break;
                case "confirmConsultation":
                    action = new ConfirmerConsultationAction();
                    serialisation = new ConfirmConsultationSerialisation();
                    break;
                case "makePredictions":
                    action = new GeneratePredictions();
                    serialisation = new PredictionsSerialisation();
                    break;
                case "endConsultation":
                    action = new TerminerConsultationAction();
                    serialisation = new TerminerConsultationSerialisation();
                    break;
                case "addComment":
                    action = new AddCommentAction();
                    serialisation = new AddCommentSerialisation();
                    break;
                case "showStats":
                    action = new DisplayStatsAction();
                    serialisation = new DisplayStatsSerialisation();
                    break;
                case "checkClient":
                    action = new CheckClientAction();
                    serialisation = new CheckAuthSerialisation();
                    break;
                case "checkStaff":
                    action = new CheckStaffAction();
                    serialisation = new CheckAuthSerialisation();
                    break;
                case "checkAny":
                    action = new CheckAnyAction();
                    serialisation = new CheckAuthSerialisation();
                    break;
                case "checkStarted":
                    action = new CheckStartedAction();
                    serialisation = new CheckStartedSerialisation();
                    break;
                    
            }
        }
        
        if (action != null) {
            action.executer(request);
            serialisation.serialiser(request, response);
        }
        else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erreur dans les paramètres de la requête");
        }

    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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

}
