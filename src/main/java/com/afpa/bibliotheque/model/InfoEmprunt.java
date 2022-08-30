package com.afpa.bibliotheque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoEmprunt {

    private Integer exemplaireId;
    private Long isbn;
    private String titre;
    private String bibliotheque;
    private LocalDate datePret;
    private LocalDate dateRetour;

}
