package fusioncoders.atl.propiedades.controllers;

import fusioncoders.atl.propiedades.models.Propiedad;
import fusioncoders.atl.propiedades.models.Vendedor;
import fusioncoders.atl.propiedades.services.PropiedadService;
import fusioncoders.atl.propiedades.services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropiedadController {
    @Autowired
    PropiedadService propiedadService;
    @Autowired
    VendedorService vendedorService;

    //Agregar una propiedad
    @PostMapping("/api/propiedad")
    public void agregar(@RequestBody Propiedad propiedad){
        Vendedor vendedor = vendedorService.buscarPorId(propiedad.getVendedor().getId());

        if(vendedor != null){
            propiedad.setVendedor(vendedor);
            propiedadService.agregar(propiedad);
        }
    }
    //   /api/propiedad    POST

    //Modificar una propiedad
    //   /api/propiedad/{id}    PUT
    @PutMapping("/api/propiedad/{id}")
    public void modificar(@PathVariable Long id, @RequestBody Propiedad propiedad){
        propiedadService.modificar(id, propiedad);
    }

    //Eliminar una propiedad
    //   /api/propiedad/{id}    DELETE
    @DeleteMapping("/api/propiedad/{id}")
    public void eliminar(@PathVariable Long id){
        propiedadService.eliminar(id);
    }

    //Buscar una propiedad
    //   /api/propiedad/{id}    GET
    @GetMapping("/api/propiedad/{id}")
    public Propiedad listarPorId(@PathVariable Long id){
        return propiedadService.buscarPorId(id);
    }

    //Mostrar todas las propiedad
    //   /api/propiedad    GET
    @GetMapping("/api/propiedad")
    public List<Propiedad> listar(){
        return propiedadService.lista();
    }

}