package com.afpa.bibliotheque.service;

import com.afpa.bibliotheque.model.InfoEmprunt;

import java.util.List;

public interface EmpruntService {

    List<InfoEmprunt> getInfoEmprunt(List<Long> ids);

}
