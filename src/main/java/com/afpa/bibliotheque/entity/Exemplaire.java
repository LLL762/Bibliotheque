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
    private Integer id;

    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "id_emplac" )
    private Emplacement emplacement;

    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "id_livre" )
    private Livre livre;

    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "id_usure" )
    private Usure usure;

    /*
    @OneToMany( fetch = LAZY )
    @JoinColumn( name = "id_emprunt" )
    private Emprunt emprunt;
    */

    @ToString.Exclude
    @Column( name = "commentaire", length = 500 )
    private String commentaire;
}
