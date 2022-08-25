package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table( name = "exemplaire" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public
class Exemplaire
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "id_bibli" )
    private Bibliotheque idBibli;

    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "id_emplac" )
    private Emplacement idEmplac;

    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "id_livre" )
    private Livre idLivre;

    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "id_usure" )
    private Usure idUsure;

/*
    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "id_emprunt" )
    private Long idEmprunt;
*/

    @ToString.Exclude
    @Column( name = "commentaire", length = 500 )
    private String commentaire;
}
