package fusioncoders.atl.propiedades.controllers;

import fusioncoders.atl.propiedades.models.Vendedor;
import fusioncoders.atl.propiedades.services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class VendedorController {
    @Autowired
    VendedorService vendedorService;

    //Vendedor vendedor1 = new Vendedor();

    //Agregar un vendedor
    //   /api/vendedor    POST
    /*@PostMapping("/api/vendedor")
    public void agregar(@RequestBody Vendedor vendedor){
        vendedor1.setId(vendedor.getId());
        vendedor1.setNombre(vendedor.getNombre());
        vendedor1.setApellido(vendedor.getApellido());
        vendedor1.setDni(vendedor.getDni());
        vendedor1.setTelefono(vendedor.getTelefono());
        vendedor1.setFechaCreacion(new Date());
        vendedor1.setFechaEliminacion(vendedor.getFechaBaja());
    }*/

    @PostMapping("/api/vendedor")
    public void agregar(@RequestBody Vendedor vendedor){
        vendedorService.agregar(vendedor);
    }

    //Modificar un Vendedor
    //   /api/vendedor/{id}    PUT
    @PutMapping("/api/vendedor/{id}")
    public String modificar(@RequestBody Vendedor vendedor,@PathVariable Long id){
        if(vendedorService.modificar(id,vendedor)){
            return "El id: " + id + " se modificó correctamente";
        }
        return "El id: " + id + " no existe. Ingrese un \"id\" válido.";
    }


    //Eliminar un Vendedor
    //   /api/vendedor/{id}    DELETE
    @DeleteMapping( "/api/vendedor/{id}")
    public String eliminar(@PathVariable Long id){
        if(vendedorService.eliminar(id)){
            return "El vendedor con ID: " + id + " se eliminó correctamente.";
        }
        return "El vendedor con ID: " + id + " NO se pudo eliminar. Verifique que el ID exista.";

    }

    //Buscar un vendedor
    //   /api/vendedor/{id}    GET
    @GetMapping("/api/vendedor/{id}")
    public Vendedor buscarPorId(@PathVariable Long id){
        return vendedorService.buscarPorId(id);
    }

    //Mostrar todos los vendedores
    //   /api/vendedor    GET
    @GetMapping("/api/vendedor")
    public List<Vendedor> lista(){
        return vendedorService.lista();
    }


}
