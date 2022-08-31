package com.afpa.bibliotheque.service;

import com.afpa.bibliotheque.entity.Emprunt;
import com.afpa.bibliotheque.entity.Utilisateur;

import java.util.Optional;

public interface AdherentService {

    Optional<Utilisateur> findAdherentById(Integer id);

    Optional<Utilisateur> getInfoAdherent(Integer id);

    boolean canEmprunter(Integer adherentId);

    void addEmprunt(Utilisateur adherent, Emprunt emprunt);


}
