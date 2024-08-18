package com.custionarios.roles.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.custionarios.funciones.Validaciones;
import com.custionarios.roles.application.CreateRolesUseCase;
import com.custionarios.roles.application.DeleteRolesUseCase;
import com.custionarios.roles.application.FindAllRolesUseCase;
import com.custionarios.roles.application.FindByIdRolesUseCase;
import com.custionarios.roles.application.UpdateRolesUseCase;
import com.custionarios.roles.domain.entity.Roles;
import com.custionarios.roles.domain.service.RolesService;
import com.custionarios.roles.infrastructure.repository.RolesRepository;

public class ConsoleAdapterRoles {

    private RolesService rolesService;
    private CreateRolesUseCase createRoles;
    private DeleteRolesUseCase delRoles;
    private FindAllRolesUseCase allRoles;
    private FindByIdRolesUseCase idRoles;
    private UpdateRolesUseCase updRoles;

    public ConsoleAdapterRoles() {
        this.rolesService = new RolesRepository();
        this.createRoles = new CreateRolesUseCase(rolesService);
        this.delRoles = new DeleteRolesUseCase(rolesService);
        this.allRoles = new FindAllRolesUseCase(rolesService);
        this.idRoles = new FindByIdRolesUseCase(rolesService);
        this.updRoles = new UpdateRolesUseCase(rolesService);
    }
    public void Start(){
    String menu = """
                        1. agregar rol
                        2. eliminar rol
                        3. listar todos los roles
                        4. buscar rol por id
                        5. actualizar rol
                        6. salir
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

                String nombre = JOptionPane.showInputDialog(null, "Escriba el nombre del rol: ");
                Roles rol = new Roles(nombre);
                createRoles.execute(rol);
                Start();

                break;
            case 2:
                try {
                    String iddel = JOptionPane.showInputDialog(null, "Escriba el id del rol para eliminar: ");
                    int iddelete = Integer.parseInt(iddel);
                    delRoles.execute(iddelete);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }
                
                break;
            case 3:
                StringBuilder mensaje = new StringBuilder("Lista de usuarios:\n");
                List<Roles> Roles = allRoles.execute();
                for (Roles roles : Roles) {
                    int id = roles.getId();
                    String name = roles.getNombre();;

                    mensaje.append("\n").append("ID: ").append(id).append("    ")
                    .append("Nombre: ").append(name).append("\n");
                }
                JTextArea textArea = new JTextArea(mensaje.toString());
                textArea.setEditable(false); 
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300)); 

                JOptionPane.showMessageDialog(null, scrollPane, "Roles", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String iduser = JOptionPane.showInputDialog(null, "Escriba el id del Roles para buscar: ");
                    int iduserbu = Integer.parseInt(iduser);
                    Optional<Roles> dato = idRoles.execute(iduserbu);
                    StringBuilder mensajeid = new StringBuilder("Roles:\n");

                    if (dato.isPresent()) {
                        Roles datopre = dato.get();
                        int id = datopre.getId();
                        String name = datopre.getNombre();
                        
                        mensajeid.append("ID: ").append(id).append("\n")
                            .append("Nombre: ").append(name).append("\n");     
                    } 
                    JOptionPane.showMessageDialog(null, mensajeid);
                    Start();
    
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }
               
                break;
            case 5:
                try {
                    String idbyuser = JOptionPane.showInputDialog(null, "Escriba el id del Rol para actualizar: ");
                    int iduserupd = Integer.parseInt(idbyuser);
                    Optional<Roles> dato = idRoles.execute(iduserupd);
                    Roles Rolesupd = dato.get();
                    Rolesupd.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nuevo Nombre"));
                    updRoles.execute(Rolesupd);
                    Start();
                    break;
                            
                } catch (Exception e) {
                    e.printStackTrace();
                    Start();
                }
                break;
            case 6:
                break;
            default:
                break;
        }
    }

}
