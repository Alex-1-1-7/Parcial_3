package org.alex.web;

import modelo.Cliente;
import modelo.Factura;
import modelo.ItemFactura;
import modelo.Producto;
import repositorio.FacturaRepositorio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/guardarFactura")
public class GuardarFacturaServlet extends HttpServlet {
    private FacturaRepositorio repositorio = new FacturaRepositorio();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombreCliente = req.getParameter("nombreCliente");
        String nrcCliente = req.getParameter("nrcCliente");
        String descripcion = req.getParameter("descripcion");

        Cliente cliente = new Cliente();
        cliente.setNombre(nombreCliente);
        cliente.setNrc(nrcCliente);

        Factura factura = new Factura(descripcion, cliente);

        for (int i = 1; i <= 1; i++) {  // Para simplicidad, solo un producto aquí
            String nombreProducto = req.getParameter("producto" + i);
            float precioProducto = Float.parseFloat(req.getParameter("precio" + i));
            int cantidadProducto = Integer.parseInt(req.getParameter("cantidad" + i));

            Producto producto = new Producto();
            producto.setNombre(nombreProducto);
            producto.setPrecio(precioProducto);

            ItemFactura item = new ItemFactura(cantidadProducto, producto);
            factura.addItemFactura(item);
        }

        repositorio.crear(factura);
        resp.sendRedirect("listarFacturas");
    }

}
