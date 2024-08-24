package com.custionarios.usuario_roles.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import com.custionarios.funciones.Validaciones;
import com.custionarios.usuario_roles.application.CreateUsuarioRolUseCase;
import com.custionarios.usuario_roles.application.DeleteUsuarioRolUseCase;
import com.custionarios.usuario_roles.application.FindAllUsuarioRolUseCase;
import com.custionarios.usuario_roles.application.FindByIdUsuarioRolUseCase;
import com.custionarios.usuario_roles.application.UpdateUsuarioRolUseCase;
import com.custionarios.usuario_roles.domain.entity.UsuarioRol;
import com.custionarios.usuario_roles.domain.service.UsuarioRolService;
import com.custionarios.usuario_roles.infrastructure.repository.UsuarioRolRepository;


public class ConsoleAdapterUsuarioRol {
    private UsuarioRolService usuarioRolService;
    private CreateUsuarioRolUseCase createUR;
    private DeleteUsuarioRolUseCase delUR;
    private UpdateUsuarioRolUseCase updUR;
    private FindByIdUsuarioRolUseCase idUR;
    private FindAllUsuarioRolUseCase allUR;


    public ConsoleAdapterUsuarioRol() {

        this.usuarioRolService = new UsuarioRolRepository();
        this.createUR = new CreateUsuarioRolUseCase(usuarioRolService);
        this.delUR = new DeleteUsuarioRolUseCase(usuarioRolService);
        this.updUR = new UpdateUsuarioRolUseCase(usuarioRolService);
        this.idUR = new FindByIdUsuarioRolUseCase(usuarioRolService);
        this.allUR = new FindAllUsuarioRolUseCase(usuarioRolService);
    }


    public void Start(){
        String menu = """
                            1. agregar usuario rol
                            2. eliminar usuario rol
                            3. listar todos los usuarios y el rol
                            4. Actualizar rol del usuario
                            5. salir
                            """;
        Optional<Integer> opcion = Validaciones.mostrarOpciones(menu,1,6);
    
        if (opcion.isPresent()) {
            int numero = opcion.get();
            ejecutarOpcion(numero);
        } 
    
      
        }
        public void ejecutarOpcion(int opcion) {
            switch (opcion) {
                case 1:
                    try {
                        String idrol = JOptionPane.showInputDialog(null, "Escriba el id del rol: ");
                        int idroles = Integer.parseInt(idrol);
                        String iduser = JOptionPane.showInputDialog(null, "Escriba el id del usuario: ");
                        int idusers = Integer.parseInt(iduser);
                        UsuarioRol ur = new UsuarioRol(idroles, idusers);
                        createUR.execute(ur);
                        
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                        Start();
                    }
                    
                    Start();
    
                    break;
                case 2:
                    try {
                        String idrol = JOptionPane.showInputDialog(null, "Escriba el id del rol: ");
                        int idroles = Integer.parseInt(idrol);
                        String iduser = JOptionPane.showInputDialog(null, "Escriba el id del usuario: ");
                        int idusers = Integer.parseInt(iduser);
                        delUR.execute(idroles, idusers);
                        Start();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                        Start();
                    }
                    break;
                case 3:
                    StringBuilder mensaje = new StringBuilder("Lista de usuarios:\n");
                    List<UsuarioRol> usuarios = allUR.execute();
                    for (UsuarioRol usuario : usuarios) {
                        int idr = usuario.getId_rol();
                        int idu = usuario.getId_usuario();

                        mensaje.append("ID rol: ").append(idr).append(" ")
                        .append("ID usuario: ").append(idu).append("\n");
                    }

                    JOptionPane.showMessageDialog(null, mensaje);
                    Start();
                    break;
                case 4:
                    try {
                        String idbyuser = JOptionPane.showInputDialog(null, "Escriba el id del usuario para buscar: ");
                        int iduserupd = Integer.parseInt(idbyuser);
                        Optional<UsuarioRol> ur = idUR.execute(iduserupd);
                        UsuarioRol usr = ur.get();
                        String idrol = JOptionPane.showInputDialog(null, "Escriba el id del nuevo rol para el usuario ");
                        int idroles = Integer.parseInt(idrol);
                        usr.setId_rol(idroles);
                        updUR.execute(usr);
                        Start();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                        Start();
                    }
                    
                    break;
                case 5:
                    break;
                default:
                    break;
             
            }
        }
}


