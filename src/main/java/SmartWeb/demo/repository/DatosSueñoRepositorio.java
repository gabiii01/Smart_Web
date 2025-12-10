package SmartWeb.demo.repository;

import SmartWeb.demo.model.DatosSueño;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DatosSueñoRepositorio extends JpaRepository<DatosSueño, Long> {

}
