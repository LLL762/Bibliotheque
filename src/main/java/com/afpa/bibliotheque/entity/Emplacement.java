package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table( name = "emplacement" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public
class Emplacement
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "id_bibli" )
    private Long idBibli;

    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "id_theme" )
    private Long idTheme;

    @Column( name = "libelle" )
    private String libelle;
}
