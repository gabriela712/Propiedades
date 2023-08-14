package fusioncoders.atl.propiedades.services;

import fusioncoders.atl.propiedades.models.Vendedor;
import fusioncoders.atl.propiedades.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VendedorService implements VendedorInterface {
    @Autowired
    VendedorRepository vendedorRepository;

    @Transactional
    @Override
    public void agregar(Vendedor vendedor) {

        Vendedor ven = new Vendedor();

        ven.setNombre(vendedor.getNombre());
        ven.setApellido(vendedor.getApellido());
        ven.setDni(vendedor.getDni());
        ven.setTelefono(vendedor.getTelefono());
        ven.setFechaCreacion(vendedor.getFechaCreacion());
        ven.setFechaEliminacion(vendedor.getFechaEliminacion());

        vendedorRepository.add(ven);
    }
    @Transactional
    @Override
    public Boolean modificar(Long id, Vendedor vendedor) {
        Vendedor ven = new Vendedor();

        ven.setNombre(vendedor.getNombre());
        ven.setApellido(vendedor.getApellido());
        ven.setDni(vendedor.getDni());
        ven.setTelefono(vendedor.getTelefono());

        return vendedorRepository.update(id, ven);
    }

    @Transactional
    @Override
    public Boolean eliminar(Long id) {
        return vendedorRepository.delete(id);
    }

    @Transactional
    @Override
    public Vendedor buscarPorId(Long id) {
        return vendedorRepository.findById(id);
    }

    @Transactional
    @Override
    public List<Vendedor> lista() {
        return vendedorRepository.findAll();
    }
}
