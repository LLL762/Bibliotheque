package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Role.
 */
@Entity
@Table(name = "role")
@Getter
@Setter
public
class Role {
    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The Libelle.
     */
    @Column(name = "libelle", length = 50, unique = true)
    private String libelle;

    /**
     * The Niv accred.
     */
    @Column(name = "niv_accred")
    private int nivAccred = 0;
}
