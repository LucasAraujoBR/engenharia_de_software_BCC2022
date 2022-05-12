package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.backengsoft.model.Investimento;

@Repository
public interface InvestimentoRepository extends JpaRepository<Investimento, Integer>{

}
