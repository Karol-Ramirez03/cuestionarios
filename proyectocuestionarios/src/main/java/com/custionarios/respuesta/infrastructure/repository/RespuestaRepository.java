package com.custionarios.respuesta.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import com.custionarios.Database.database;
import com.custionarios.respuesta.domain.entity.Respuesta;
import com.custionarios.respuesta.domain.service.RespuestaService;


public class RespuestaRepository implements RespuestaService{

    @Override
    public void CreateRespuesta(Respuesta respuesta) {
        String sql = "INSERT INTO respuestas (id_respuesta, id_subrespuesta, texto_respuesta) VALUES (?, ?, ?)";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.println(respuesta.getIdRespuesta());
            if (respuesta.getIdRespuesta() == null) {
                ps.setNull(1, java.sql.Types.INTEGER);
                
            } else {
                ps.setInt(1, respuesta.getIdRespuesta());
            }

            if (respuesta.getIdSubrespuesta() == null) {
                ps.setNull(2, java.sql.Types.INTEGER);
            } else {
                ps.setInt(2, respuesta.getIdSubrespuesta());
            }

            ps.setString(3, respuesta.getTextoRespuesta());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "respuestas agregado con exito");

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Respuesta> FindAllRespuesta() {
        String sql = "SELECT id , id_respuesta, id_subrespuesta, texto_respuesta FROM Respuestas";
        List<Respuesta> resp = new ArrayList<>();
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs  = ps.executeQuery()) {
            while (rs.next()) {
                int ID = rs.getInt("id");
                int id_respuesta = rs.getInt("id_respuesta");
                int id_subrespuesta = rs.getInt("id_subrespuesta");
                String texto_respuesta = rs.getString("texto_respuesta");

                Respuesta rsp = new Respuesta(ID, id_respuesta, id_subrespuesta, texto_respuesta);
                resp.add(rsp);

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    @Override
    public Optional<Respuesta> FindByIdRespuesta(int id) {
        String sql = "SELECT id , id_respuesta, id_subrespuesta, texto_respuesta FROM Respuestas WHERE id = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("id");
                int id_respuesta = rs.getInt("id_respuesta");
                int id_subrespuesta = rs.getInt("id_subrespuesta");
                String texto_respuesta = rs.getString("texto_respuesta");

                Respuesta user = new Respuesta(ID, id_respuesta, id_subrespuesta, texto_respuesta);
                return Optional.of(user);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return Optional.empty();
    }

    @Override
    public void deleteRespuesta(int id) {
        String sql = "DELETE FROM Respuestas WHERE id = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Respuesta eliminado con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRespuesta(Respuesta respuesta) {
        String sql = "UPDATE Respuestas SET id_respuesta = ?, id_subrespuesta = ?, texto_respuesta = ? WHERE id = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, respuesta.getIdRespuesta());
            System.out.println(respuesta.getIdRespuesta());
            if (respuesta.getIdRespuesta() == 0 ) {
                ps.setInt(1, java.sql.Types.INTEGER);
            } else {
                ps.setInt(1, respuesta.getIdRespuesta());
            }
            System.out.println(respuesta.getIdSubrespuesta());
            if (respuesta.getIdSubrespuesta() == 0) {
                ps.setNull(2, java.sql.Types.INTEGER);
            } else {
                ps.setInt(2, respuesta.getIdSubrespuesta());
            }
            ps.setString(3, respuesta.getTextoRespuesta());
            ps.setInt(4, respuesta.getId());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Respuesta actualizado con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
