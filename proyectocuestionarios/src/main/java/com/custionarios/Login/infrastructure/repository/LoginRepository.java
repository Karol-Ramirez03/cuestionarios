package com.custionarios.Login.infrastructure.repository;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

import javax.swing.JOptionPane;

import com.custionarios.Database.database;
import com.custionarios.Login.domain.entity.Login;
import com.custionarios.Login.domain.service.LoginService;

public class LoginRepository implements LoginService{


    @Override
    public void guardarusuario(Login usuario) {
        String sql = "INSERT INTO usuarios(habilitado, nombre_usuario, contraseña) VALUES (true,?,?)";
        String sql2 = "INSERT INTO usuarios_roles(id_rol, id_usuario) VALUES(?,?)";
        try (Connection con = database.getConnection()) {
            con.setAutoCommit(false);
            // esto es para permitir una inicializacion para obtener el id
            try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                //es una api de jdbc que permite obtener la clave id
                ps.setString(1, usuario.getUser());
                ps.setString(2, usuario.getPassword());
                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                //aqui guardamos lo encontrado las llave en una variable
                //y lo recorremos lo encontrado
                if (rs.next()) {
                    int idusuario = rs.getInt(1);
                    //del resultado  recuperamos el id generado
                    try (PreparedStatement prepared = con.prepareStatement(sql2)) {
                        prepared.setInt(1, 2);
                        prepared.setInt(2, idusuario);
                        prepared.executeUpdate();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    
                }
                con.commit();
                JOptionPane.showMessageDialog(null,  "Usuario agregado con exito");
                
            } catch (Exception e) {
                con.rollback(); 
                e.printStackTrace();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @Override 
    public Optional<Login> validarusuario(String user, String contraseña) {
        String sql = "SELECT id, habilitado FROM usuarios WHERE nombre_usuario = ? AND contraseña = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, user);
            ps.setString(2, contraseña);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idusuario = rs.getInt("id");
                boolean idusuarioh = rs.getBoolean("habilitado");
                Login usuariohabilitado = new Login(idusuario, idusuarioh);
                return Optional.of(usuariohabilitado);
                
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    return Optional.empty();
    }
    @Override

    public Optional<Integer> roles(int id) {
        String sql = "SELECT  id_rol, id_usuario FROM usuarios_roles WHERE id_usuario = ?";
        try (Connection con = database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idusuario = rs.getInt("id_rol");
                return Optional.of(idusuario);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
