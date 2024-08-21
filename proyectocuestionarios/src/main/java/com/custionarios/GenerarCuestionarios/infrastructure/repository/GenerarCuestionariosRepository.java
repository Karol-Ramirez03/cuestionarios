package com.custionarios.GenerarCuestionarios.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.custionarios.Database.database;
import com.custionarios.GenerarCuestionarios.domain.entity.GenerarCuestionarios;
import com.custionarios.GenerarCuestionarios.domain.service.GenerarCuestionariosService;

public class GenerarCuestionariosRepository implements GenerarCuestionariosService{

    @Override
    public List<GenerarCuestionarios> mostrar_encuestas() {
        String sql = "SELECT id, descripcion, nombre FROM encuestas";
        List<GenerarCuestionarios> encuestas = new ArrayList<>();
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                GenerarCuestionarios cuestionario = new GenerarCuestionarios(id, nombre);
                encuestas.add(cuestionario); 
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!, vuelve a intenntarlo ");
            e.printStackTrace();
        }
        return encuestas;
    }

    @Override
    public List<GenerarCuestionarios> mostrar_capitulos(int encuestaid) {
        String sql = "SELECT numero_capitulo, titulo_capitulo FROM capitulos WHERE id_encuesta = ?";
        List<GenerarCuestionarios> capitulos = new ArrayList<>();
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, encuestaid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int numero_capitulo = rs.getInt("numero_capitulo");
                String tituloCapitulo = rs.getString("titulo_capitulo");
                 
                GenerarCuestionarios capitulo = new GenerarCuestionarios(numero_capitulo, tituloCapitulo);
                capitulos.add(capitulo);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!, vuelve a intenntarlo ");
            e.printStackTrace();
        }
        return capitulos;
    }
    
    
}
