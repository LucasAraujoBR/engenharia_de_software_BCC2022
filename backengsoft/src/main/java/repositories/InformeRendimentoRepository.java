package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.backengsoft.model.InformeRendimento;

@Repository
public interface InformeRendimentoRepository extends JpaRepository<InformeRendimento, Integer>{

}
