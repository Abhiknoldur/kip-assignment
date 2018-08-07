package com.knoldus.problem3;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class CurrentTimeZone {
    public static void main(String[] args) {

        System.out.println("Time as per given timeZone (TimeZone Values-UTC, UTC" + getTimeFromTimeZone("Asia/Kamchatka") + ")");

    }

    private static String getTimeFromTimeZone(String zoneId) {
         LocalDateTime dt = LocalDateTime.now();
         ZoneId zone = ZoneId.of(zoneId);
        ZonedDateTime zdt = dt.atZone(zone);
        ZoneOffset zos = zdt.getOffset();

        //replace Z to +00:00


        return zos.getId().replaceAll("Z", "+00:00");

    }
}
