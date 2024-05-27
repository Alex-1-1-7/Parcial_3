package org.alex.repositorio;

import org.alex.modelo.Factura;

import java.util.ArrayList;
import java.util.List;

public class FacturaRepositorio {
    private List<Factura> dataSource = new ArrayList<>();

    public List<Factura> listar() {
        return dataSource;
    }

    public void crear(Factura factura) {
        dataSource.add(factura);
    }
}
