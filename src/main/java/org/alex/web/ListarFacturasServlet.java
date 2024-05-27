package org.alex.web;

import repositorio.FacturaRepositorio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/listarFacturas")
public class ListarFacturasServlet extends HttpServlet {
    private FacturaRepositorio repositorio = new FacturaRepositorio();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("facturas", repositorio.listar());
        req.getRequestDispatcher("/listar.jsp").forward(req, resp);
    }
}

