package com.sotckSystem.Stock.repository;

import com.sotckSystem.Stock.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<List<Stock>>findByDate(LocalDate today);

    Optional<List<Stock>> findByName(String name);

    List<Stock> findByDono(String cpf);

    @Query("SELECT sum(s.price) FROM Stock s WHERE dono='?1'")
    BigDecimal sumTotalInvestido(String dono);
}
