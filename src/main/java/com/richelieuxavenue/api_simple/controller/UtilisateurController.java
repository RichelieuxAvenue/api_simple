package com.richelieuxavenue.api_simple.controller;

import com.richelieuxavenue.api_simple.entity.Utilisateurs;
import com.richelieuxavenue.api_simple.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    //obtenir tous les utilisateur
    @GetMapping
    public List<Utilisateurs> getAllUtilisateurs() {
        return utilisateurService.getUtilisateurs();
    }

    //obtenir l'utilisateur par son id directement dans l'url
    @GetMapping("/{id}")
    public Optional<Utilisateurs> getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.getUtilisateurById(id);
    }

    //ajouter un nouvel utilisateur avec une méthode post
    @PostMapping
    public Utilisateurs ajouterUtilisateur(@RequestBody Utilisateurs utilisateur) {
        return utilisateurService.ajouterUtilisateur(utilisateur);
    }

    //supprimer un utilisateur
    @DeleteMapping("/{id}")
    public void supprimerUtilisateurById(@PathVariable Long id) {
        utilisateurService.supprimerUtilisateur(id);
    }
}