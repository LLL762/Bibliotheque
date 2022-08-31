package com.afpa.bibliotheque.validation;

import com.afpa.bibliotheque.container.AppGlobalConst;
import com.afpa.bibliotheque.entity.Utilisateur;

import java.time.LocalDate;
import java.util.Map;

public class InfoAdherentValidator {
    public static final String OK_MSG = "";
    public static final int MAX_LENGTH = 8;

    public static final String MAX_LENGTH_MSG = String.format("%x characters max !", MAX_LENGTH);
    public static final String BLANK_MSG = "Veuillez entrez une valeur";
    public static final String NOT_AN_UN_INT_MSG = "Please enter a valid unsigned integer";


    public String validateSearchInput(final String searchInput) {

        final Map<String, String> errors = ValidatorString.notNullNotBlank(BLANK_MSG).apply(searchInput);

        if (!errors.isEmpty()) {
            return BLANK_MSG;
        }

        errors.putAll(ValidatorString.isUnsignedInteger(NOT_AN_UN_INT_MSG).
                and(ValidatorString.maxLength(MAX_LENGTH, MAX_LENGTH_MSG)).
                apply(searchInput));

        return errors.isEmpty() ? OK_MSG : generateErrMsg(errors);
    }

    public boolean canEmprunter(final Utilisateur adherent, final int countEmprunt) {

        return adherent != null &&
                countEmprunt <= AppGlobalConst.MAX_EMPRUNT &&
                adherent.getDateFinAdhesion().isAfter(LocalDate.now().plusDays(AppGlobalConst.DUREE_EMPRUNT_IN_DAYS));
    }


    private String generateErrMsg(final Map<String, String> errors) {

        return String.join(", ", errors.values());
    }


}



