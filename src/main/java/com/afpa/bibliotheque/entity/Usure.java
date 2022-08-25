package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table( name = "usure" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public
class Usure
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    /* @TODO : Nom de l'état du livre à définir dans une énum ? */
    @Column( name = "nom", length = 50 )
    private String nom;

    @ToString.Exclude
    @Column( name = "description", length = 500 )
    private String description;
}
