package com.custionarios.categoriasCatalogo.infrastructure.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.custionarios.categoriasCatalogo.application.CreateCategoriasCatalogoUseCase;
import com.custionarios.categoriasCatalogo.application.DeleteCategoriasCatalogoUseCase;
import com.custionarios.categoriasCatalogo.application.FindAllCategoriasCatalogoUseCase;
import com.custionarios.categoriasCatalogo.application.FindByIdCategoriasCatalogoUseCase;
import com.custionarios.categoriasCatalogo.application.UpdateCategoriasCatalogoUseCase;
import com.custionarios.categoriasCatalogo.domain.entity.CategoriasCatalogo;
import com.custionarios.categoriasCatalogo.domain.service.CategoriasCatalogoService;
import com.custionarios.categoriasCatalogo.infrastructure.repository.CategoriasCatalogoRepository;
import com.custionarios.funciones.Validaciones;

public class ConsoleAdapterCategoriasCatalogo {
    private CategoriasCatalogoService categoriasCatalogoService;
    private CreateCategoriasCatalogoUseCase createCategorias;
    private DeleteCategoriasCatalogoUseCase delCategorias;
    private FindAllCategoriasCatalogoUseCase allCategorias;
    private FindByIdCategoriasCatalogoUseCase idCategorias;
    private UpdateCategoriasCatalogoUseCase updCategorias;

    
    public ConsoleAdapterCategoriasCatalogo() {
        this.categoriasCatalogoService = new CategoriasCatalogoRepository();
        this.createCategorias = new CreateCategoriasCatalogoUseCase(categoriasCatalogoService);
        this.delCategorias = new DeleteCategoriasCatalogoUseCase(categoriasCatalogoService);
        this.allCategorias = new FindAllCategoriasCatalogoUseCase(categoriasCatalogoService);
        this.idCategorias = new FindByIdCategoriasCatalogoUseCase(categoriasCatalogoService);
        this.updCategorias = new UpdateCategoriasCatalogoUseCase(categoriasCatalogoService);
    }

    public void Start(){
    String menu = """
                        1. agregar Categorias Catalogo
                        2. eliminar Categorias Catalogo
                        3. listar todos las Categorias Catalogos
                        4. buscar Categorias Catalogo por id
                        5. actualizar Categorias Catalogo
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
                String nombre = JOptionPane.showInputDialog(null, "Escriba el nombre de la Categoria del Catalogo: ");

                CategoriasCatalogo CategoriasCatalogo = new CategoriasCatalogo(nombre);
                createCategorias.execute(CategoriasCatalogo);
                Start();


                break;
            case 2:
                try {
                    String iddel = JOptionPane.showInputDialog(null, "Escriba el id de la Categoria-Catalogo para eliminar: ");
                    int iddelete = Integer.parseInt(iddel);
                    delCategorias.execute(iddelete);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }
                
                break;
            case 3:

                StringBuilder mensaje = new StringBuilder("Lista de CategoriasCatalogos:\n");
                List<CategoriasCatalogo> CategoriasCatalogos = allCategorias.execute();
                for (CategoriasCatalogo categoriasCatalogo : CategoriasCatalogos) {

                    int id = categoriasCatalogo.getId();
                    Timestamp creadoEn = categoriasCatalogo.getCreadoEn();
                    Timestamp actualizadoEn = categoriasCatalogo.getActualizadoEn();
                    String nombreall =  categoriasCatalogo.getNombre();


                    mensaje.append("ID: ").append(id).append("\n")
                    .append("creado en: ").append(creadoEn).append("\n")
                    .append("actualizado en: ").append(actualizadoEn).append("\n")
                    .append("nombre: ").append(nombreall).append("\n\n");
     
                }
                JTextArea textArea = new JTextArea(mensaje.toString());
                textArea.setEditable(false); 
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));

                JOptionPane.showMessageDialog(null, scrollPane, "CategoriasCatalogos", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String iduser = JOptionPane.showInputDialog(null, "Escriba el id del CategoriasCatalogo para buscar: ");
                    int iduserbu = Integer.parseInt(iduser);
                    Optional<CategoriasCatalogo> dato = idCategorias.execute(iduserbu);
                    StringBuilder mensajeid = new StringBuilder("CategoriasCatalogos:\n");
                    if (dato.isPresent()) {
                        CategoriasCatalogo datopre = dato.get();
                        int id = datopre.getId();
                        Timestamp creadoEn = datopre.getCreadoEn();
                        Timestamp actualizadoEn = datopre.getActualizadoEn();
                        String nombreid =  datopre.getNombre();
    
                        mensajeid.append("ID: ").append(id).append("\n")
                        .append("creado en: ").append(creadoEn).append("\n")
                        .append("actualizado en: ").append(actualizadoEn).append("\n")
                        .append("nombre: ").append(nombreid).append("\n\n");
         
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
                String idbyuser = JOptionPane.showInputDialog(null, "Escriba el id del CategoriasCatalogo para buscar: ");
                int iduserupd = Integer.parseInt(idbyuser);
                Optional<CategoriasCatalogo> dato = idCategorias.execute(iduserupd);
                CategoriasCatalogo CategoriasCatalogoUpd = dato.get();
                CategoriasCatalogoUpd.setNombre(JOptionPane.showInputDialog(null," ingrese el nuevo nombre: "));
                updCategorias.execute(CategoriasCatalogoUpd);     
                Start();
                
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
