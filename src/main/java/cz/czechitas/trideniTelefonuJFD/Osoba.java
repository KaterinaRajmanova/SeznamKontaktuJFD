package cz.czechitas.trideniTelefonuJFD;

import java.time.*;
import java.time.temporal.*;

public class Osoba implements Comparable <Osoba>{

    private String krestniJmeno;
    private String prijmeni;
    private LocalDate datumNarozeni;

    public Osoba(String krestniJmeno, String prijmeni, LocalDate datumNarozeni) {
        this.krestniJmeno = krestniJmeno;
        this.prijmeni = prijmeni;
        this.datumNarozeni = datumNarozeni;
    }

    public String getKrestniJmeno() {
        return krestniJmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public String getceleJmeno() {
        return krestniJmeno+" "+prijmeni;
    }

    public LocalDate getDatumNarozeni() {
        return datumNarozeni;
    }

    public int getVek(){
           LocalDate dnesek = LocalDate.now();
           return (int) ChronoUnit.YEARS.between(datumNarozeni,dnesek);
    }

    public String toString(){
        return getceleJmeno();
    }

    public int compareTo (Osoba druhaOsoba){
        int vysledekPorovnani = this.getPrijmeni().compareTo(druhaOsoba.getPrijmeni());
        if ( vysledekPorovnani<0){
            return -1;
        }else if(vysledekPorovnani==0){
            return 0;
        }else{
            return 1;
        }

    }


}
