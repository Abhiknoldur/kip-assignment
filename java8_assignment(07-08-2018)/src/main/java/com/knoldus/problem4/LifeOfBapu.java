package com.knoldus.problem4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
//import org.joda.time.;

public class LifeOfBapu {
    public static void main(String[] args) {
        LocalDate birthDate = LocalDate.of(1869, 10, 2);
        LocalDate assasinationDate = LocalDate.of(1946, 1, 30);
        long lifeOfBapuInDays = ChronoUnit.DAYS.between(birthDate, assasinationDate);
        long lifeOfBapuInseconds = lifeOfBapuInDays * 24 * 60 * 60;
        System.out.println(lifeOfBapuInseconds);

    }
}
        //long lifeOfBapu1= Duration.between(birthDate,assasinationDate).toDays();
        //  long lifeOfBapuInDays = ChronoUnit.SECONDS.between(birthDate, assasinationDate);

        /*LocalDateTime tempDateTime = LocalDateTime.from( birthDate );

        long seconds = tempDateTime.until( assasinationDate, ChronoUnit.SECONDS);

        System.out.println(seconds);
*/

/*
        Seconds d= Seconds.between(birthDate,assasinationDate);



         long lifeOfBapu=d.getSeconds();
        System.out.println(lifeOfBapu);

        long l = d.getSeconds();*//*

        long lifeOfBapu1 = ChronoUnit.SECONDS.between(birthDate, assasinationDate);
        Seconds lifeOfBapu 2= Seconds.secondsBetween(birthDate, assasinationDate);
        System.out.println(lifeOfBapu1);
    }
}
}*/
