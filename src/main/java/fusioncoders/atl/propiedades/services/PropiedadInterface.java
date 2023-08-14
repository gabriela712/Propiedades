package fusioncoders.atl.propiedades.services;

import fusioncoders.atl.propiedades.models.Propiedad;
import fusioncoders.atl.propiedades.models.Vendedor;

import java.text.ParseException;
import java.util.List;

public interface PropiedadInterface{
    void agregar(Propiedad propiedad);

    void modificar(Long id, Propiedad propiedad);

    void eliminar(Long id);

    Propiedad buscarPorId(Long id);

    List<Propiedad> lista();

}


