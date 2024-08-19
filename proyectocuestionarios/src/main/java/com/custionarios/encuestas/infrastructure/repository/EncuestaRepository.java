package com.custionarios.encuestas.infrastructure.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import com.custionarios.Database.database;
import com.custionarios.encuestas.domain.entity.Encuesta;
import com.custionarios.encuestas.domain.service.EncuestaService;

public class EncuestaRepository implements EncuestaService {

    @Override
    public void CreateEncuesta(Encuesta encuesta) {
        String sql = "INSERT INTO encuestas (creado_en, actualizado_en, descripcion, nombre) VALUES (NOW(),NOW(),?,?)";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, encuesta.getDescripcion());
            ps.setString(2, encuesta.getNombre());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Encuestas agregado con exito");

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public List<Encuesta> FindAllEncuesta() {
        String sql = "SELECT id, creado_en, actualizado_en, descripcion, nombre FROM encuestas";
        List<Encuesta> resp = new ArrayList<>();
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs  = ps.executeQuery()) {
            while (rs.next()) {
                int ID = rs.getInt("id");
                Timestamp creado_en = rs.getTimestamp("creado_en"); 
                Timestamp actualizado_en = rs.getTimestamp("actualizado_en"); 
                String descripcion = rs.getString("descripcion");
                String nombre = rs.getString("nombre");


                Encuesta rsp = new Encuesta(ID, creado_en, actualizado_en, descripcion, nombre);
                resp.add(rsp);

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    @Override
    public Optional<Encuesta> FindByIdEncuesta(int id) {
        String sql = "SELECT id , creado_en, actualizado_en, descripcion, nombre FROM Encuestas WHERE id = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("id");
                Timestamp creado_en = rs.getTimestamp("creado_en"); 
                Timestamp actualizado_en = rs.getTimestamp("actualizado_en"); 
                String descripcion = rs.getString("descripcion");
                String nombre = rs.getString("nombre");


                Encuesta rsp = new Encuesta(ID, creado_en, actualizado_en, descripcion, nombre);
                return Optional.of(rsp);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return Optional.empty();
    }

    @Override
    public void deleteEncuesta(int id) {
        String sql = "DELETE FROM encuestas WHERE id = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Encuesta eliminado con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void updateEncuesta(Encuesta encuesta) {
        String sql = "UPDATE encuestas SET actualizado_en = NOW(), descripcion = ?, nombre = ? WHERE id = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, encuesta.getDescripcion());
            ps.setString(2, encuesta.getNombre());
            ps.setInt(3, encuesta.getId());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Encuesta actualizado con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
