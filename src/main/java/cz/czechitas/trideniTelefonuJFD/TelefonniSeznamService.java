package cz.czechitas.trideniTelefonuJFD;

import java.time.*;
import java.util.*;

public class TelefonniSeznamService {

    public Map<Osoba, Set<TelefonniCislo>> vycistiTelefonniCisla (String celyVstup){

        Map<Osoba, Set<TelefonniCislo>> kontakty = new TreeMap<>();
       

        List<String> radky = Arrays.asList(celyVstup.split("\n"));
        for (String jedenRadek : radky) {
            String[] slovaRadku = jedenRadek.split(";");
            List<String> udaje = Arrays.asList(slovaRadku);
            TelefonniCislo telefonniCislo = new TelefonniCislo(udaje.get(0));

            Osoba osoba = new Osoba(udaje.get(1),udaje.get(2), LocalDate.of(1954,Month.OCTOBER,1));

            Set<TelefonniCislo> seznamTelefonu = kontakty.get(osoba);
            if (seznamTelefonu == null) {
                seznamTelefonu = new TreeSet<>();
                kontakty.put(osoba, seznamTelefonu);
            }
            seznamTelefonu.add(telefonniCislo);

        }

       return kontakty;
    }

}
