package com.afpa.bibliotheque.service;

import com.afpa.bibliotheque.model.InfoExemplaire;

import java.util.Optional;

/**
 * 30/08/2022.
 *
 * @author Laurent Lamiral
 */
public interface ExemplaireService {

    public Optional<InfoExemplaire> getExemplaireInfo(final Integer exemplaireId);


}
