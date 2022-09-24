package com.cash.history.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

@Service
public class MonthNameService {
    String getMonthName(LocalDateTime localDateTime, String localeLanguage) {
        /*
         * getMonthName
         * returns the name of the localDateTime in Locale specified by localeLanguage
         */
        return localDateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.forLanguageTag(localeLanguage));
    }
}
