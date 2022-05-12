package com.java.backengsoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.backengsoft.entities.InformeRendimento;

@Repository
public interface InformeRendimentoRepository extends JpaRepository<InformeRendimento, Integer>{

}
