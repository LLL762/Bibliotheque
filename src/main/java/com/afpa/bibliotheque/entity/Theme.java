package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "theme")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public
class Theme {
    /* @TODO : Considèrer la possibilité d'avoir un thème temporaire */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "libelle", length = 50, unique = true, nullable = false)
    private String libelle;

    @ToString.Exclude
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "description", length = 500)
    private String description;
}
