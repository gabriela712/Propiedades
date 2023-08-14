package fusioncoders.atl.propiedades.services;

import fusioncoders.atl.propiedades.models.Vendedor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.util.List;

public interface VendedorInterface {
    void agregar(Vendedor vendedor) throws ParseException;

    Boolean modificar(Long id, Vendedor vendedor);

    Boolean eliminar(Long id);

    Vendedor buscarPorId(Long id);

    List<Vendedor> lista();


}
