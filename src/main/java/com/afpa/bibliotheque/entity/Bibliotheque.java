package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "bibliotheque")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public
class Bibliotheque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "libelle", length = 50, nullable = false, unique = true)
    private String libelle;

    @Column(name = "adresse", length = 500, nullable = false)
    @Basic(fetch = LAZY)
    @ToString.Exclude
    private String adresse;
}
