package com.example.parking.Servlet;

import com.example.parking.Ticket;
import com.example.parking.TicketService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name ="sortieServlet", value = "/sortie")
public class SortieServlet extends HttpServlet {
    @EJB
    private TicketService ticketService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        Long id = (Long) session.getAttribute("ticketId");
        Ticket ticket = ticketService.getTicket(id);

        ticket.setDateSortie();
        ticketService.updateTicket(ticket);

        session.removeAttribute("ticketId");

        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        Long id = (Long) session.getAttribute("ticketId");
        Ticket ticket = ticketService.getTicket(id);

        request.setAttribute("canExit", ticket.canExit());

        try {
            request.getRequestDispatcher("/sortie.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
