package fusioncoders.atl.propiedades.repositories;

import fusioncoders.atl.propiedades.models.Propiedad;
import fusioncoders.atl.propiedades.services.PropiedadInterface;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PropiedadRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void add(Propiedad propiedad) {
        String sql = "INSERT INTO propiedades (titulo, descripcion, m2, anios, banios, habitaciones, zipcode, direccion,latitud,longitud,estado,disponible, id_galeria, id_vendedor,fecha_alta,fecha_baja)" +
                "VALUES (:titulo, :descripcion, :m2, :anios, :banios, :habitaciones, :zipcode, :direccion," +
                " :latitud, :longitud, :estado, :disponible, :id_galeria, :id_vendedor, :fecha_alta, :fecha_baja)";
        entityManager.createNativeQuery(sql, Propiedad.class)
                .setParameter("titulo", propiedad.getTitulo())
                .setParameter("descripcion", propiedad.getDescripcion())
                .setParameter("m2", propiedad.getM2())
                .setParameter("anios", propiedad.getAno())
                .setParameter("banios", propiedad.getBanos())
                .setParameter("habitaciones", propiedad.getHabitaciones())
                .setParameter("zipcode", propiedad.getZipcode())
                .setParameter("direccion", propiedad.getDireccion())
                .setParameter("latitud", propiedad.getLatitud())
                .setParameter("longitud", propiedad.getLongitud())
                .setParameter("estado", propiedad.getEstado())
                .setParameter("disponible", propiedad.getDisponible())
                .setParameter("id_galeria", propiedad.getGaleria())
                .setParameter("id_vendedor", propiedad.getVendedor().getId())
                .setParameter("fecha_alta", propiedad.getFechaCreacion())
                .setParameter("fecha_baja", propiedad.getFechaEliminacion())
                .executeUpdate();

    }

    public Propiedad findById(Long id) {
        String sql = "SELECT * FROM (propiedades) WHERE id= :id";
        return (Propiedad) entityManager.createNativeQuery(sql, Propiedad.class)
                .setParameter("id", id)
                .getSingleResult();
    }


    public void update(Long id, Propiedad propiedad) {

        String sql = "UPDATE propiedades SET titulo= :titulo, descripcion= :descripcion, m2= :m2, anios= :anios, banios= :banios, habitaciones= :habitaciones, zipcode= :zipcode, direccion= :direccion,latitud= :latitud,longitud= :longitud,estado= :estado,disponible= :disponible, id_galeria= :id_galeria, id_vendedor= :id_vendedor,fecha_alta= :fecha_alta,fecha_baja= :fecha_baja WHERE id= :id";

        entityManager.createNativeQuery(sql, Propiedad.class)
                .setParameter("titulo", propiedad.getTitulo())
                .setParameter("descripcion", propiedad.getDescripcion())
                .setParameter("m2", propiedad.getM2())
                .setParameter("anios", propiedad.getAno())
                .setParameter("banios", propiedad.getBanos())
                .setParameter("habitaciones", propiedad.getHabitaciones())
                .setParameter("zipcode", propiedad.getZipcode())
                .setParameter("direccion", propiedad.getDireccion())
                .setParameter("latitud", propiedad.getLatitud())
                .setParameter("longitud", propiedad.getLongitud())
                .setParameter("estado", propiedad.getEstado())
                .setParameter("disponible", propiedad.getDisponible())
                .setParameter("id_galeria", propiedad.getGaleria())
                .setParameter("id_vendedor", propiedad.getVendedor().getId())
                .setParameter("fecha_alta", propiedad.getFechaCreacion())
                .setParameter("fecha_baja", propiedad.getFechaEliminacion())
                .setParameter("id", id)
                .executeUpdate();
    }

    public List<Propiedad> findAll() {
        String sql = "SELECT * FROM propiedades";
        return entityManager.createNativeQuery(sql, Propiedad.class)
                .getResultList();
    }

    public void delete(Long id) {
        String sql = "DELETE FROM propiedades WHERE id= :id";
        entityManager.createNativeQuery(sql, Propiedad.class)
                .setParameter("id", id)
                .executeUpdate();
    }
}