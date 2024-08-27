package com.custionarios.reportes.infrastructure.ReportesRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.custionarios.Database.database;
import com.custionarios.reportes.domain.entity.Reportes;
import com.custionarios.reportes.domain.service.ReportesService;

public class ReportesRepository implements ReportesService{

    @Override
    public List<Reportes> listarEncuestaRespondidas() {
        String sql = """
            SELECT  e.id AS idenc, e.nombre AS nombre
            FROM encuestas e
            JOIN capitulos c ON e.id = c.id_encuesta
            JOIN preguntas p ON p.id_capitulo = c.id
            JOIN opciones_respuesta or1 ON or1.id_pregunta = p.id
            JOIN respuestas r ON r.id_respuesta = or1.id
            GROUP BY  e.id;
        """;
        List<Reportes> encuestas = new ArrayList<>();
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int id = rs.getInt("idenc");

                Reportes reporte = new Reportes(id,nombre);
                encuestas.add(reporte);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encuestas;
    }

    @Override
    public Optional<List<Reportes>> listarOpcionesysubopciones(int id) {
        String sql = """

            SELECT 
                p.texto_pregunta AS Pregunta,
                o.texto_opcion AS Opcion,
                COUNT(r.id) AS Cantidad_Opcion,
                so.texto_subopcion AS Subopcion,
                COUNT(sr.id) AS Cantidad_Subopcion,
                sr.texto_respuesta AS textoresp
            FROM encuestas e
            JOIN capitulos c ON c.id_encuesta = e.id
            JOIN preguntas p ON p.id_capitulo = c.id
            JOIN opciones_respuesta o ON o.id_pregunta = p.id
            LEFT JOIN respuestas r ON r.id_respuesta = o.id
            LEFT JOIN subopciones_respuesta so ON so.id_opcion_respuesta = o.id
            LEFT JOIN respuestas sr ON sr.id_subrespuesta = so.id
            WHERE e.id = ?
            GROUP BY  p.texto_pregunta, o.texto_opcion, so.texto_subopcion,sr.texto_respuesta
            ORDER BY p.texto_pregunta, o.texto_opcion, so.texto_subopcion
            
            
        """;
        List<Reportes> respuestas = new ArrayList<>();
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String pregunta = rs.getString("pregunta");
                String textoOpcion = rs.getString("Opcion");
                int cantidad_opcion = rs.getInt("Cantidad_Opcion");
                String subopcion = rs.getString("Subopcion");
                int cantidad_subopcion = rs.getInt("Cantidad_Subopcion");
                String texto = rs.getString("textoresp");
                System.out.println(subopcion);
                Reportes preguntas = new Reportes(pregunta, textoOpcion, cantidad_opcion, subopcion, cantidad_subopcion, texto);
                respuestas.add(preguntas);
            }
            if (respuestas.isEmpty()) {
                return Optional.empty();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.of(respuestas);
    }

}
