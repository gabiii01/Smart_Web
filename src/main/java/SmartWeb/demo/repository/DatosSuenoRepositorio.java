package SmartWeb.demo.repository;

import SmartWeb.demo.model.DatosSueno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DatosSuenoRepositorio extends JpaRepository<DatosSueno, Long> {

}
