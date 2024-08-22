package com.custionarios.GenerarCuestionarios.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            JOptionPane.showMessageDialog(null, "¡Error!, vuelve a intenntarlo 1 ");
            e.printStackTrace();
        }
        return capitulos;
    }

    @Override
    public Optional<List<GenerarCuestionarios>> mostrar_preguntas(int numcapitulo, int idencuesta) {
        String sql = "SELECT P.id, p.numero_pregunta, p.texto_pregunta FROM preguntas p JOIN capitulos c ON p.id_capitulo = c.id WHERE c.id_encuesta = ? AND  c.numero_capitulo = ?";
        List<GenerarCuestionarios> capitulos = new ArrayList<>();
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(2, numcapitulo);
            ps.setInt(1, idencuesta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int numero_pregunta = rs.getInt("numero_pregunta");
                String texto_pregunta = rs.getString("texto_pregunta");
                int idpregunta = rs.getInt("id");
                 
                GenerarCuestionarios capitulo = new GenerarCuestionarios(idpregunta, numero_pregunta, texto_pregunta);
                capitulos.add(capitulo);
            }
            return Optional.of(capitulos);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!, vuelve a intenntarlo 0");
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<GenerarCuestionarios>> mostrar_opciones(int numpregunta,int numCap, int idEncuesta) {
        String sql = """
                    SELECT valor_opcion, texto_opcion
                    FROM opciones_respuesta
                    WHERE id_pregunta = (
                        SELECT p.id
                        FROM preguntas p 
                        JOIN capitulos c ON c.id = p.id_capitulo
                        WHERE p.numero_pregunta = ? AND  c.numero_capitulo = ? AND c.id_encuesta = ?
                    )
                
                """;
        List<GenerarCuestionarios> capitulos = new ArrayList<>();
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, numpregunta);
            ps.setInt(2, numCap);
            ps.setInt(3, idEncuesta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int numero_pregunta = rs.getInt("valor_opcion");
                String texto_pregunta = rs.getString("texto_opcion");
                 
                GenerarCuestionarios capitulo = new GenerarCuestionarios(numero_pregunta, texto_pregunta);
                capitulos.add(capitulo);
            }
            if (capitulos.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(capitulos);       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!, vuelve a intenntarlo 2");
            e.printStackTrace();
        }
        
        return Optional.empty();
    }

    @Override
    public Optional<List<GenerarCuestionarios>> mostrar_subopciones(int opc) {
        String sql = "SELECT numero_subopcion, texto_subopcion FROM subopciones_respuesta WHERE id_opcion_respuesta = ?";
        List<GenerarCuestionarios> capitulos = new ArrayList<>();
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, opc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int numero_subopcion = rs.getInt("numero_subopcion");
                String texto_subopcion = rs.getString("texto_subopcion");
                 
                GenerarCuestionarios capitulo = new GenerarCuestionarios(numero_subopcion, texto_subopcion);
                capitulos.add(capitulo);
            }
            if (capitulos.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(capitulos);       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!, vuelve a intentarlo 33");
            e.printStackTrace();
        }
        
        return Optional.empty();
    }

    @Override
    public Optional<Integer>  mostraopciondelosidpadres(int numpregunta,int numCap, int idEncuesta) {
        String sql = """
                SELECT or1.id_pregunta AS numpreguntapadre
                FROM opciones_respuesta or2 
                JOIN opciones_respuesta or1 ON or2.id_opcion_padre = or1.id
                WHERE or1.id = (
                    SELECT p.id
                    FROM preguntas p 
                    JOIN capitulos c ON c.id = p.id_capitulo
                    WHERE p.numero_pregunta = ? AND  c.numero_capitulo = ? AND c.id_encuesta = ?);

                """;
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, numpregunta);
            ps.setInt(2, numCap);
            ps.setInt(3, idEncuesta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("numpreguntapadre");
                return Optional.of(id);      
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!, vuelve a intentarlo ");
            e.printStackTrace();
        }
        
        return Optional.empty();
    }

    public  Optional<List<GenerarCuestionarios>> mostrarpreguntaporId(int id){
        String sql = "SELECT numero_pregunta,texto_pregunta FROM preguntas  WHERE id = ? ";
        List<GenerarCuestionarios> preguntas = new ArrayList<>();
        try (Connection connection = database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int numero_pregunta = rs.getInt("numero_pregunta");
                String texto = rs.getString("texto_pregunta");
                GenerarCuestionarios pregunta = new GenerarCuestionarios(numero_pregunta, texto);
                preguntas.add(pregunta);
                return Optional.of(preguntas);      
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!, vuelve a intentarlo ");
            e.printStackTrace();
        }
        return Optional.empty();
    }


    @Override
    public void guardar_respuesta() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardar_respuesta'");
    }

    
    
    
}
