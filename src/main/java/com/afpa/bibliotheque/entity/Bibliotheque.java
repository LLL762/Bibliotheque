package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table( name = "biblioteque" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public
class Bibliotheque
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( name = "libelle", length = 50 )
    private String libelle;

    @Column( name = "adresse", length = 500 )
    private String adresse;
}
