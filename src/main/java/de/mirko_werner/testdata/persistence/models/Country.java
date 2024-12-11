package de.mirko_werner.testdata.persistence.models;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Country {
    AFGHANISTAN("Afghanistan","Afghanistan","AF","AFG"),
    ALBANIA("Albania","Albanien","AL","ALB"),
    ALGERIA("Algeria","Algerien","DZ","DZA"),
    ANDORRA("Andorra","Andorra","AD","AND"),
    ANGOLA("Angola","Angola","AO","AGO"),
    ANTIQUA_AND_BARBUDA("Antigua and Barbuda","Antigua und Barbuda","AG","ATG"),
    ARGENTINA("Argentina","Argentinien","AR","ARG"),
    ARMENIA("Armenia","Armenien","AM","ARM"),
    AUSTRALIA("Australia","Australien","AU","AUS"),
    AUSTRIA("Austria","Österreich","AT","AUT"),
    AZERBAIJAN("Azerbaijan","Aserbaidschan","AZ","AZE"),
    BAHAMAS("Bahamas","Bahamas","BS","BHS"),
    BAHRAIN("Bahrain","Bahrain","BH","BHR"),
    BANGLADESH("Bangladesh","Bangladesch","BD","BGD"),
    BARBADOS("Barbados","Barbados","BB","BRB"),
    BELARUS("Belarus","Belarus","BY","BLR"),
    BELGIUM("Belgium","Belgien","BE","BEL"),
    BELIZE("Belize","Belize","BZ","BLZ"),
    BENIN("Benin","Benin","BJ","BEN"),
    BHUTAN("Bhutan","Bhutan","BT","BTN"),
    BOLIVIA("Bolivia","Bolivien","BO","BOL"),
    BOSNIA_AND_HERZEGOVINA("Bosnia and Herzegovina","Bosnien und Herzegowina","BA","BIH"),
    BOTSWANA("Botswana","Botswana","BW","BWA"),
    BRAZIL("Brazil","Brasilien","BR","BRA"),
    BRUNEI("Brunei Darussalam","Brunei","BN","BRN"),
    BULGARIA("Bulgaria","Bulgarien","BG","BGR"),
    BURKINA("Burkina Faso","Burkina Faso","BF","BFA"),
    BURUNDI("Burundi","Burundi","BI","BDI"),
    CAMBODIA("Cambodia","Kambodscha","KH","KHM"),
    CAMEROON("Cameroon","Kamerun","CM","CMR"),
    CANADA("Canada","Kanada","CA","CAN"),
    CAPE_VERDE("Cape Verde","Kap Verde","CV","CPV"),
    CENTRAL_AFRICAN("Central African Republic","Zentralafrikanische Republik","CF","CAF"),
    CHAD("Chad","Tschad","TD","TCD"),
    CHILE("Chile","Chile","CL","CHL"),
    CHINA("China","China, Volksrepublik","CN","CHN"),
    COLOMBIA("Colombia","Kolumbien","CO","COL"),
    COMOROS("Comoros","Komoren","KM","COM"),
    CONGO_KINSHASA("Congo, Democratic Republic of the (Kinshasa)","Kongo, Demokratische Republik","CD","COD"),
    CONGO_BRAZZAVILLE("Congo, Republic of (Brazzaville)","Kongo, Republik","CG","COG"),
    COOK_ISLANDS("Cook Islands","Cookinseln","CK","COK"),
    COSTA_RICA("Costa Rica","Costa Rica","CR","CRI"),
    CROATIA("Croatia","Kroatien","HR","HRV"),
    CUBA("Cuba","Kuba","CU","CUB"),
    CYPRUS("Cyprus","Zypern","CY","CYP"),
    CZECHIA("Czechia","Tschechien","CZ","CZE"),
    DENMARK("Denmark","Dänemark","DK","DNK"),
    DJIBOUTI("Djibouti","Dschibuti","DJ","DJI"),
    DOMINICA("Dominica","Dominica","DM","DMA"),
    DOMINICAN_REPUBLIC("Dominican Republic","Dominikanische Republik","DO","DOM"),
    EAST_TIMOR("East Timor","Osttimor","TL","TLS"),
    ECUADOR("Ecuador","Ecuador","EC","ECU"),
    EGYPT("Egypt","Ägypten","EG","EGY"),
    EL_SALVADOR("El Salvador","El Salvador","SV","SLV"),
    EQUATORIAL_GUNIEA("Equatorial Guinea","Äquatorialguinea","GQ","GNQ"),
    ERITREA("Eritrea","Eritrea","ER","ERI"),
    ESTONIA("Estonia","Estland","EE","EST"),
    ESWATINI("Eswatini","Eswatini","SZ","SWZ"),
    ETHIOPIA("Ethiopia","Äthiopien","ET","ETH"),
    FIJI("Fiji","Fidschi","FJ","FJI"),
    FINLAND("Finland","Finnland","FI","FIN"),
    FRANCE("France","Frankreich","FR","FRA"),
    GABON("Gabon","Gabun","GA","GAB"),
    GAMBIA("Gambia, the","Gambia","GM","GMB"),
    GEORGIA("Georgia","Georgien","GE","GEO"),
    GERMANY("Germany","Deutschland","DE","DEU"),
    GHANA("Ghana","Ghana","GH","GHA"),
    GREECE("Greece","Griechenland","GR","GRC"),
    GRENADA("Grenada","Grenada","GD","GRD"),
    GUATEMALA("Guatemala","Guatemala","GT","GTM"),
    GUINEA("Guinea","Guinea","GN","GIN"),
    GUINEA_BISSAU("Guinea-Bissau","Guinea-Bissau","GW","GNB"),
    GUYANA("Guyana","Guyana","GY","GUY"),
    HAITI("Haiti","Haiti","HT","HTI"),
    HONDURAS("Honduras","Honduras","HN","HND"),
    HUNGARY("Hungary","Ungarn","HU","HUN"),
    ICELAND("Iceland","Island","IS","ISL"),
    INDIA("India","Indien","IN","IND"),
    INDONESIA("Indonesia","Indonesien","ID","IDN"),
    IRAN("Iran","Iran","IR","IRN"),
    IRAQ("Iraq","Irak","IQ","IRQ"),
    IRELAND("Ireland","Irland","IE","IRL"),
    ISRAEL("Israel","Israel","IL","ISR"),
    ITALY("Italy","Italien","IT","ITA"),
    IVORY_COAST("Ivory Coast","Elfenbeinküste","CI","CIV"),
    JAMAICA("Jamaica","Jamaika","JM","JAM"),
    JAPAN("Japan","Japan","JP","JPN"),
    JORDAN("Jordan","Jordanien","JO","JOR"),
    KAZAKHSTAN("Kazakhstan","Kasachstan","KZ","KAZ"),
    KENYA("Kenya","Kenia","KE","KEN"),
    KIRIBATI("Kiribati","Kiribati","KI","KIR"),
    KOREA_NORTH("Korea, Democratic People's Republic of (North Korea)","Korea, Nord(Nordkorea)","KP","PRK"),
    KOREA_SOUTH("Korea, Republic of (South Korea)","Korea, Süd(Südkorea)","KR","KOR"),
    KOSOVO("Kosovo","Kosovo","XK","XXK"),
    KUWAIT("Kuwait","Kuwait","KW","KWT"),
    KYRGYZSTAN("Kyrgyzstan","Kirgisistan","KG","KGZ"),
    LAO("Lao, People’s Democratic Republic of","Laos","LA","LAO"),
    LATVIA("Latvia","Lettland","LV","LVA"),
    LEBANON("Lebanon","Libanon","LB","LBN"),
    LESOTHO("Lesotho","Lesotho","LS","LSO"),
    LIBERIA("Liberia","Liberia","LR","LBR"),
    LIBYA("Libya","Libyen","LY","LBY"),
    LIECHTENSTEIN("Liechtenstein","Liechtenstein","LI","LIE"),
    LITHUANIA("Lithuania","Litauen","LT","LTU"),
    LUXEMBOURG("Luxembourg","Luxemburg","LU","LUX"),
    MADAGASCAR("Madagascar","Madagaskar","MG","MDG"),
    MALAWI("Malawi","Malawi","MW","MWI"),
    MALAYSIA("Malaysia","Malaysia","MY","MYS"),
    MALDIVES("Maldives","Malediven","MV","MDV"),
    MALI("Mali","Mali","ML","MLI"),
    MALTA("Malta","Malta","MT","MLT"),
    MARSHALL_ISLANDS("Marshall Islands","Marshallinseln","MH","MHL"),
    MAURITANIA("Mauritania","Mauretanien","MR","MRT"),
    MAURITIUS("Mauritius","Mauritius","MU","MUS"),
    MEXICO("Mexico","Mexiko","MX","MEX"),
    MICRONESIA("Micronesia, Federal States of","Mikronesien","FM","FSM"),
    MOLDOVA("Moldova","Moldau","MD","MDA"),
    MONACO("Monaco","Monaco","MC","MCO"),
    MONGOLIA("Mongolia","Mongolei","MN","MNG"),
    MONTENEGRO("Montenegro","Montenegro","ME","MNE"),
    MOROCCO("Morocco","Marokko","MA","MAR"),
    MOZAMBIQUE("Mozambique","Mosambik","MZ","MOZ"),
    MYANMAR("Myanmar","Myanmar","MM","MMR"),
    NAMIBIA("Namibia","Namibia","NA","NAM"),
    NAURU("Nauru","Nauru","NR","NRU"),
    NEPAL("Nepal","Nepal","NP","NPL"),
    NETHERLANDS("Netherlands","Niederlande","NL","NLD"),
    NEW_ZEALAND("New Zealand","Neuseeland","NZ","NZL"),
    NICARAGUA("Nicaragua","Nicaragua","NI","NIC"),
    NIGER("Niger","Niger","NE","NER"),
    NIGERIA("Nigeria","Nigeria","NG","NGA"),
    NIUE("Niue","Niue","NU","NIU"),
    NORTH_MACEDONIA("North Macedonia","Nordmazedonien","MK","MKD"),
    NORWAY("Norway","Norwegen","NO","NOR"),
    OMAN("Oman","Oman","OM","OMN"),
    PAKISTAN("Pakistan","Pakistan","PK","PAK"),
    PALAU("Palau","Palau","PW","PLW"),
    PALESTINE("Palestine","Palästina","PS","PSE"),
    PANAMA("Panama","Panama","PA","PAN"),
    PAPUA_NEW_GUINEA("Papua New Guinea","Papua-Neuguinea","PG","PNG"),
    PARAGUAY("Paraguay","Paraguay","PY","PRY"),
    PERU("Peru","Peru","PE","PER"),
    PHILIPPINES("Philippines","Philippinen","PH","PHL"),
    POLAND("Poland","Polen","PL","POL"),
    PORTUGAL("Portugal","Portugal","PT","PRT"),
    QATA("Qatar","Katar","QA","QAT"),
    ROMANIA("Romania","Rumänien","RO","ROU"),
    RUSSIA("Russia","Russland","RU","RUS"),
    RWANDA("Rwanda","Ruanda","RW","RWA"),
    SAINT_KITTS_AND_NEVIS("Saint Kitts and Nevis","St. Kitts und Nevis","KN","KNA"),
    SAINT_LUCIA("Saint Lucia","St. Lucia","LC","LCA"),
    SAINT_VINCENT_AND_THE_GRENADINES("Saint Vincent and the Grenadines","St. Vincent und die Grenadinen","VC","VCT"),
    SAMOA("Samoa","Samoa","WS","WSM"),
    SAN_MARINO("San Marino","San Marino","SM","SMR"),
    SAO_TOME_AND_PRINCIPE("São Tomé and Príncipe","São Tomé und Príncipe","ST","STP"),
    SAUDI_ARABIA("Saudi Arabia","Saudi-Arabien","SA","SAU"),
    SENEGAL("Senegal","Senegal","SN","SEN"),
    SERBIA("Serbia","Serbien","RS","SRB"),
    SEYCHELLES("Seychelles","Seychellen","SC","SYC"),
    SIERRA_LEONE("Sierra Leone","Sierra Leone","SL","SLE"),
    SINGAPORE("Singapore","Singapur","SG","SGP"),
    SLOVAKIA("Slovakia","Slowakei","SK","SVK"),
    SLOVENIA("Slovenia","Slowenien","SI","SVN"),
    SOLOMON_ISLANDS("Solomon Islands","Salomonen","SB","SLB"),
    SOMALIA("Somalia","Somalia","SO","SOM"),
    SOUTH_AFRICE("South Africa","Südafrika","ZA","ZAF"),
    SOUTH_SUDAN("South Sudan","Südsudan","SS","SSD"),
    SPAIN("Spain","Spanien","ES","ESP"),
    SRI_LANKA("Sri Lanka","Sri Lanka","LK","LKA"),
    SUDAN("Sudan","Sudan","SD","SDN"),
    SURINAME("Suriname","Suriname","SR","SUR"),
    SWEDEN("Sweden","Schweden","SE","SWE"),
    SWITZERLAND("Switzerland","Schweiz","CH","CHE"),
    SYRIA("Syria","Syrien","SY","SYR"),
    TAIWAN("Taiwan","China, Republik","TW","TWN"),
    TAJIKISTAN("Tajikistan","Tadschikistan","TJ","TJK"),
    TANZANIA("Tanzania","Tansania","TZ","TZA"),
    THAILAND("Thailand","Thailand","TH","THA"),
    TOGO("Togo","Togo","TG","TGO"),
    TONGA("Tonga","Tonga","TO","TON"),
    TRINIDAD_AND_TOBAGO("Trinidad and Tobago","Trinidad und Tobago","TT","TTO"),
    TUNISIA("Tunisia","Tunesien","TN","TUN"),
    TÜRKIYE("Türkiye","Türkei","TR","TUR"),
    TURKMENISTAN("Turkmenistan","Turkmenistan","TM","TKM"),
    TUVALU("Tuvalu","Tuvalu","TV","TUV"),
    UGANDA("Uganda","Uganda","UG","UGA"),
    UKRAINE("Ukraine","Ukraine","UA","UKR"),
    UNITED_ARAB_EMIRATES("United Arab Emirates","Vereinigte Arabische Emirate","AE","ARE"),
    UNITED_KINGDOM("United Kingdom","Vereinigtes Königreich","GB","GBR"),
    UNITED_STATES("United States","Vereinigte Staaten","US","USA"),
    URUGUAY("Uruguay","Uruguay","UY","URY"),
    UZBEKISTAN("Uzbekistan","Usbekistan","UZ","UZB"),
    VANUATA("Vanuatu","Vanuatu","VU","VUT"),
    VATICAN_CITY("Vatican City","Vatikanstadt","VA","VAT"),
    VENEZUELA("Venezuela","Venezuela","VE","VEN"),
    VIETNAME("Vietnam","Vietnam","VN","VNM"),
    WESTERN_SAHARA("Western Sahara","Westsahara","EH","ESH"),
    YEMEN("Yemen","Jemen","YE","YEM"),
    ZAMBIA("Zambia","Sambia","ZM","ZMB"),
    ZIMBABWE("Zimbabwe","Simbabwe","ZW","ZWE");

    private final String name;
    private final String german;
    private final String iso2;
    private final String iso3;

    Country(String name, String german, String iso2, String iso3) {
        this.name = name;
        this.german = german;
        this.iso2 = iso2;
        this.iso3 = iso3;
    }

    public static Country getCountryByName(String name) {
        return Arrays.stream(Country.values())
                .filter(country -> country.getName().equals(name)).findFirst().orElse(null);
    }
}
