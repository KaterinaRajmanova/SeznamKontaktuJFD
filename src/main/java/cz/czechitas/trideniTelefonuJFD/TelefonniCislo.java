package cz.czechitas.trideniTelefonuJFD;

public class TelefonniCislo implements Comparable <TelefonniCislo> {

    private String telefonniCislo;

    public TelefonniCislo(String telefonniCislo) {
        if (telefonniCislo.startsWith("00")) {
            this.telefonniCislo = "+" + telefonniCislo.substring(2);
        } else if (!telefonniCislo.startsWith("+")) {
            telefonniCislo = "+420" + telefonniCislo;
            this.telefonniCislo = telefonniCislo;
        }else if (telefonniCislo.startsWith("+")) {
            this.telefonniCislo = telefonniCislo;
        }
    }

    public String getTelefonniCislo() {
        return telefonniCislo;
    }

    public int compareTo (TelefonniCislo druheTelefonniCislo){
        int vysledekPorovnani = telefonniCislo.compareTo(druheTelefonniCislo.getTelefonniCislo());
        if ( vysledekPorovnani<0){
            return -1;
        }else if(vysledekPorovnani==0){
            return 0;
        }else{
            return 1;
        }

    }

}
