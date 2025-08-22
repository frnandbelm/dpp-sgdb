package com.loja.perfumes.repository;

import com.loja.perfumes.model.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfumeRepository extends JpaRepository<Perfume, Long> {
}
