package com.custionarios.subopcionRespuesta.infrastruture.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import com.custionarios.Database.database;
import com.custionarios.subopcionRespuesta.domain.entity.SubopcionesRespuesta;
import com.custionarios.subopcionRespuesta.domain.service.SubOpcionesRespuestaService;

public class SubOpcionesRespuestaRepository implements SubOpcionesRespuestaService{

    @Override
    public void CreateSubOpcionesRespuesta(SubopcionesRespuesta subOpcionesRespuesta) {
        String sql = "CALL validarvalorsubopciones(?,?,?)";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, subOpcionesRespuesta.getIdOpcionRespuesta());
            ps.setString(2, subOpcionesRespuesta.getComponenteHtml());
            ps.setString(3, subOpcionesRespuesta.getTextoSubopcion());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "sub opcion agregado con exito");
  
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public List<SubopcionesRespuesta> FindAllSubOpcionesRespuesta() {
        String sql = "SELECT  id, numero_Subopcion, creado_en,  actualizado_en, id_opcion_respuesta, componente_html, texto_Subopcion FROM subopciones_respuesta";
        List<SubopcionesRespuesta> Sub = new ArrayList<>();
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs  = ps.executeQuery()) {
            while (rs.next()) {
                int ID = rs.getInt("id");
                int numeroSubopcion = rs.getInt("numero_Subopcion");
                Timestamp creadoEn = rs.getTimestamp("creado_en");
                Timestamp actualizadoEn = rs.getTimestamp("actualizado_en");
                int idOpcionRespuesta = rs.getInt("id_opcion_respuesta");
                String componenteHtml = rs.getString("componente_html");
                String textoSubopcion = rs.getString("texto_Subopcion");

                SubopcionesRespuesta opc = new SubopcionesRespuesta(ID, numeroSubopcion, creadoEn, actualizadoEn, idOpcionRespuesta, componenteHtml, textoSubopcion);
                Sub.add(opc);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Sub;
    }

    @Override
    public Optional<SubopcionesRespuesta> FindByIdSubOpcionesRespuesta(int id) {
        String sql = "SELECT  id, numero_Subopcion, creado_en,  actualizado_en, id_opcion_respuesta, componente_html, texto_Subopcion FROM subopciones_respuesta WHERE id = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("id");
                int numeroSubopcion = rs.getInt("numero_Subopcion");
                Timestamp creadoEn = rs.getTimestamp("creado_en");
                Timestamp actualizadoEn = rs.getTimestamp("actualizado_en");
                int idOpcionRespuesta = rs.getInt("id_opcion_respuesta");
                String componenteHtml = rs.getString("componente_html");
                String textoSubopcion = rs.getString("texto_Subopcion");

                SubopcionesRespuesta opc = new SubopcionesRespuesta(ID, numeroSubopcion, creadoEn, actualizadoEn, idOpcionRespuesta, componenteHtml, textoSubopcion);
                return Optional.of(opc);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteSubOpcionesRespuesta(int id) {
        String sql = "DELETE FROM subopciones_respuesta WHERE id = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "sub opcion eliminado con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSubOpcionesRespuesta(SubopcionesRespuesta subOpcionesRespuesta) {
        String sql = "CALL actualizarSubopciones(?,?,?,?)";
        try (Connection con = database.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, subOpcionesRespuesta.getId());
                ps.setInt(2, subOpcionesRespuesta.getIdOpcionRespuesta());
                ps.setString(3, subOpcionesRespuesta.getComponenteHtml());
                ps.setString(4, subOpcionesRespuesta.getTextoSubopcion());

                ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "sub opcion actualizado con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
