package com.java.backengsoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.backengsoft.entities.Investimento;

@Repository
public interface InvestimentoRepository extends JpaRepository<Investimento, Integer>{

}
