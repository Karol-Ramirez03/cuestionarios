package com.custionarios.categoriasCatalogo.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import com.custionarios.Database.database;
import com.custionarios.categoriasCatalogo.domain.entity.CategoriasCatalogo;
import com.custionarios.categoriasCatalogo.domain.service.CategoriasCatalogoService;


public class CategoriasCatalogoRepository implements CategoriasCatalogoService {

    @Override
    public void CreateCategoriasCatalogo(CategoriasCatalogo categoriasCatalogo) {
        String sql = "INSERT INTO categorias_catalogo (creado_en, actualizado_en, nombre) VALUES (NOW(),NOW(),?)";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, categoriasCatalogo.getNombre());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "CategoriasCatalogo agregado con exito");

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CategoriasCatalogo> FindAllCategoriasCatalogo() {
        String sql = "SELECT id, creado_en, actualizado_en, nombre FROM categorias_catalogo";
        List<CategoriasCatalogo> resp = new ArrayList<>();
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs  = ps.executeQuery()) {
            while (rs.next()) {
                int ID = rs.getInt("id");
                Timestamp creado_en = rs.getTimestamp("creado_en"); 
                Timestamp actualizado_en = rs.getTimestamp("actualizado_en"); 
                String nombre = rs.getString("nombre");


                CategoriasCatalogo rsp = new CategoriasCatalogo(ID, creado_en, actualizado_en, nombre);
                resp.add(rsp);

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    @Override
    public Optional<CategoriasCatalogo> FindByIdCategoriasCatalogo(int id) {
        String sql = "SELECT id , creado_en, actualizado_en,  nombre FROM categorias_catalogo WHERE id = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("id");
                Timestamp creado_en = rs.getTimestamp("creado_en"); 
                Timestamp actualizado_en = rs.getTimestamp("actualizado_en"); 
                String nombre = rs.getString("nombre");


                CategoriasCatalogo rsp = new CategoriasCatalogo(ID, creado_en, actualizado_en, nombre);
                return Optional.of(rsp);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return Optional.empty();
    }

    @Override
    public void deleteCategoriasCatalogo(int id) {
        String sql = "DELETE FROM categorias_catalogo WHERE id = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "CategoriasCatalogo eliminado con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCategoriasCatalogo(CategoriasCatalogo categoriasCatalogo) {
        String sql = "UPDATE categorias_catalogo SET actualizado_en = NOW(),  nombre = ? WHERE id = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, categoriasCatalogo.getNombre());
            ps.setInt(2, categoriasCatalogo.getId());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "CategoriasCatalogo actualizado con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
