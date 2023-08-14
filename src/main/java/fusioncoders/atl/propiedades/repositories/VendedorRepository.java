package fusioncoders.atl.propiedades.repositories;

import fusioncoders.atl.propiedades.models.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VendedorRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void add(Vendedor vendedor) {
        String sql = "INSERT INTO vendedores (nombre, apellido, dni, telefono, fecha_alta, fecha_baja)" +
                "VALUES (:nombre, :apellido, :dni, :telefono, :fechaAlta, :fechaBaja)";
        entityManager.createNativeQuery(sql, Vendedor.class)
                .setParameter("nombre", vendedor.getNombre())
                .setParameter("apellido", vendedor.getApellido())
                .setParameter("dni", vendedor.getDni())
                .setParameter("telefono", vendedor.getTelefono())
                .setParameter("fechaAlta", vendedor.getFechaCreacion())
                .setParameter("fechaBaja", vendedor.getFechaEliminacion())
                .executeUpdate();

    }

    public Vendedor findById(Long id) {
        String sql = "SELECT * FROM (vendedores) WHERE id= :id";
        return (Vendedor) entityManager.createNativeQuery(sql, Vendedor.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public Boolean update(Long id, Vendedor vendedor) {
        try {
            String sql = "UPDATE vendedores SET nombre= :nombre, apellido= :apellido, " +
                    "dni= :dni, telefono= :telefono  WHERE id= :id";
            if(this.findById(id) != null) {

                entityManager.createNativeQuery(sql, Vendedor.class)
                        .setParameter("nombre", vendedor.getNombre())
                        .setParameter("apellido", vendedor.getApellido())
                        .setParameter("dni", vendedor.getDni())
                        .setParameter("telefono", vendedor.getTelefono())
                        .setParameter("id", id)
                        .executeUpdate();
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }

    public List<Vendedor> findAll(){
        String sql = "SELECT * FROM vendedores";
        return  entityManager.createNativeQuery(sql, Vendedor.class)
                .getResultList();
    }

    public Boolean delete(Long id){
        try {
            if(this.findById(id) != null) {
                String sql = "DELETE FROM vendedores WHERE id= :id";
                entityManager.createNativeQuery(sql, Vendedor.class)
                        .setParameter("id", id)
                        .executeUpdate();
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }
}
