package com.batyan.zefgame.utilities;

import android.text.Html;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class RSSHelper {
    static int parseId(String s) {
        return Integer.parseInt(s.substring(s.indexOf("=") + 1));
    }

    static String parseDate(String s) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z",
                Locale.ENGLISH);
        Date date = formatter.parse(s);
        DateFormat outputFormat = DateFormat
                .getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT);
        assert date != null;
        return outputFormat.format(date);
    }

    static String parseText(String s) {
        return Html.fromHtml(s).toString();
    }
}
