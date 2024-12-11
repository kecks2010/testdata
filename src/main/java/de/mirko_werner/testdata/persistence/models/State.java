package de.mirko_werner.testdata.persistence.models;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum State {
    DE_BB("Brandenburg","DE-BB","BB"),
    DE_BE("Berlin","DE-BE","BE"),
    DE_BW("Baden-Württemberg","DE-BW","BW"),
    DE_BY("Bavaria","DE-BY","BY"),
    DE_HB("Bremen","DE-HB","HB"),
    DE_HE("Hesse","DE-HE","HE"),
    DE_HH("Hamburg","DE-HH","HH"),
    DE_MV("Mecklenburg-Vorpommern","DE-MV","MV"),
    DE_NI("Lower Saxony","DE-NI","NI"),
    DE_NW("North Rhine-Westphalia","DE-NW","NW"),
    DE_RP("Rhineland-Palatinate","DE-RP","RP"),
    DE_SH("Schleswig-Holstein","DE-SH","SH"),
    DE_SL("Saarland","DE-SL","SL"),
    DE_SN("Saxony","DE-SN","SN"),
    DE_ST("Saxony-Anhalt","DE-ST","ST"),
    DE_TH("Thuringia","DE-TH","TH");


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
