package com.richelieuxavenue.api_simple.repository;

import com.richelieuxavenue.api_simple.entity.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateurs, Long> {
}
