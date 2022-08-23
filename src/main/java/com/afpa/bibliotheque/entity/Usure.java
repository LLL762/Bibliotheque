package com.afpa.bibliotheque.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Usure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
