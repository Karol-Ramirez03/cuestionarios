package com.custionarios.preguntas.infrastructure.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import com.custionarios.Database.database;
import com.custionarios.preguntas.domain.entity.Pregunta;
import com.custionarios.preguntas.domain.service.PreguntaService;


public class PreguntaRepository implements PreguntaService{

    @Override
    public void CreatePregunta(Pregunta pregunta) {
        String sql = "INSERT INTO preguntas (id_capitulo, creado_en, actualizado_en, numero_pregunta, tipo_respuesta, comentario_pregunta, texto_pregunta) VALUES (?, NOW(), NOW(),?,?,?,?)";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, pregunta.getIdCapitulo());
            ps.setString(2, pregunta.getNumeroPregunta());
            ps.setString(3, pregunta.getTipoRespuesta());
            ps.setString(4, pregunta.getComentarioPregunta());
            ps.setString(5, pregunta.getTextoPregunta());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Preguntas agregado con exito");

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public List<Pregunta> FindAllPregunta() {
        String sql = "SELECT id, id_capitulo, creado_en, actualizado_en, numero_pregunta, tipo_respuesta, comentario_pregunta, texto_pregunta FROM  preguntas";
        List<Pregunta> resp = new ArrayList<>();
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs  = ps.executeQuery()) {
            while (rs.next()) {
                int ID = rs.getInt("id");
                int id_capitulo = rs.getInt("id_capitulo");
                Timestamp creado_en = rs.getTimestamp("creado_en");
                Timestamp actualizado_en = rs.getTimestamp("actualizado_en");
                String numero_pregunta = rs.getString("numero_pregunta");
                String tipo_Pregunta = rs.getString("tipo_respuesta");
                String comentario_pregunta = rs.getString("comentario_pregunta");
                String texto_pregunta = rs.getString("texto_pregunta");


                Pregunta rsp = new Pregunta(ID, id_capitulo, creado_en, actualizado_en,numero_pregunta, tipo_Pregunta, comentario_pregunta, texto_pregunta);
                resp.add(rsp);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    @Override
    public Optional<Pregunta> FindByIdPregunta(int id) {
        String sql = "SELECT id ,id_capitulo, creado_en, actualizado_en, numero_pregunta, tipo_respuesta, comentario_pregunta, texto_pregunta FROM preguntas WHERE id = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("id");
                int id_capitulo = rs.getInt("id_capitulo");
                Timestamp creado_en = rs.getTimestamp("creado_en");
                Timestamp actualizado_en = rs.getTimestamp("actualizado_en");
                String numero_pregunta = rs.getString("numero_pregunta");
                String tipo_Pregunta = rs.getString("tipo_respuesta");
                String comentario_pregunta = rs.getString("comentario_pregunta");
                String texto_pregunta = rs.getString("texto_pregunta");


                Pregunta rsp = new Pregunta(ID, id_capitulo, creado_en, actualizado_en,numero_pregunta, tipo_Pregunta, comentario_pregunta, texto_pregunta);
                return Optional.of(rsp);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return Optional.empty();
    }

    @Override
    public void deletePregunta(int id) {
        String sql = "DELETE FROM Preguntas WHERE id = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Pregunta eliminado con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void updatePregunta(Pregunta pregunta) {
        String sql = "UPDATE Preguntas SET id_capitulo = ?, actualizado_en = NOW(), numero_pregunta = ?, tipo_respuesta = ?, comentario_pregunta = ?, texto_pregunta = ? WHERE id = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1,  pregunta.getIdCapitulo());
            ps.setString(2, pregunta.getNumeroPregunta());
            ps.setString(3, pregunta.getTipoRespuesta());
            ps.setString(4, pregunta.getComentarioPregunta());
            ps.setString(5, pregunta.getTextoPregunta());
            ps.setInt(6, pregunta.getId());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Pregunta actualizado con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
