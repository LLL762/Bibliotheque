package com.afpa.bibliotheque.repository;


import jakarta.persistence.EntityGraph;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QueryDetail<T> {

    private boolean readOnly = false;
    private boolean caseSensitive = true;
    private int limitSize = 20;
    private EntityGraph<T> entityGraph;


}
