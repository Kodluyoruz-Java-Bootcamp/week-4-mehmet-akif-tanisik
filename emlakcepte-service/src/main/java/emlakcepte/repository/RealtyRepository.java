package emlakcepte.repository;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import emlakcepte.model.Realty;
import emlakcepte.model.enums.RealtyType;
import org.springframework.stereotype.Repository;

@Repository
public interface RealtyRepository extends JpaRepository<Realty, Integer> {

	List<Realty> findAllByUserId(int id);

	List<Realty> findAllByStatus(RealtyType active);

}
