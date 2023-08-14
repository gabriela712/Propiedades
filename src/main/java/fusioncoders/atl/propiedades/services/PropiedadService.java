package fusioncoders.atl.propiedades.services;

import fusioncoders.atl.propiedades.models.Propiedad;
import fusioncoders.atl.propiedades.repositories.PropiedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PropiedadService implements PropiedadInterface {

    @Autowired
    private PropiedadRepository propiedadRepository;
    @Override
    @Transactional
    public void agregar(Propiedad propiedad) {
        propiedadRepository.add(propiedad);
    }

    @Override
    @Transactional
    public void modificar(Long id, Propiedad propiedad) {
        propiedadRepository.update(id, propiedad);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        propiedadRepository.delete(id);
    }

    @Override
    @Transactional
    public Propiedad buscarPorId(Long id) {
        return propiedadRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Propiedad> lista() {
        return propiedadRepository.findAll();
    }
}