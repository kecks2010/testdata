package de.mirko_werner.testdata.persistence.models;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum State {
    DE_BB("Brandenburg","DE_BB","BB"),
    DE_BE("Berlin","DE_BE","BE"),
    DE_BW("Baden-Württemberg","DE_BW","BW"),
    DE_BY("Bayern","DE_BY","BY"),
    DE_HB("Bremen","DE_HB","HB"),
    DE_HE("Hessen","DE_HE","HE"),
    DE_HH("Hamburg","DE_HH","HH"),
    DE_MV("Mecklenburg-Vorpommern","DE_MV","MV"),
    DE_NI("Niedersachsen","DE_NI","NI"),
    DE_NW("Nordrhein-Westfalen","DE_NW","NW"),
    DE_RP("Rheinland-Pfalz","DE_RP","RP"),
    DE_SH("Schleswig-Holstein","DE_SH","SH"),
    DE_SL("Saarland","DE_SL","SL"),
    DE_SN("Sachsen","DE_SN","SN"),
    DE_ST("Sachsen-Anhalt","DE_ST","ST"),
    DE_TH("Thüringen","DE_TH","TH");


    private final String name;
    private final String internationalAbbreviation;
    private final String localAbbreviation;

    State(String name, String internationalAbbreviation, String localAbbreviation) {
        this.name = name;
        this.internationalAbbreviation = internationalAbbreviation;
        this.localAbbreviation = localAbbreviation;
    }

    public static State getStateByName(String name) {
        return Arrays.stream(State.values())
                .filter(state -> state.getName().equals(name)).findFirst().orElse(null);
    }
}
