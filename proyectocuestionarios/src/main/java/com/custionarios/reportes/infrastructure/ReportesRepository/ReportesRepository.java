package com.custionarios.reportes.infrastructure.ReportesRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

}
