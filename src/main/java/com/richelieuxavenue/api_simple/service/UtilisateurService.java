package com.richelieuxavenue.api_simple.service;

import com.richelieuxavenue.api_simple.entity.Utilisateurs;
import com.richelieuxavenue.api_simple.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    //ajouter un nouvel utilisateur
    public Utilisateurs ajouterUtilisateur(Utilisateurs utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    //obtenir tout les utilisateurs
    public List<Utilisateurs> getUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    //trouver un utilisateur via son id
    public Optional<Utilisateurs> getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id);
    }

    //supprimer un utilisateur
    public void supprimerUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
