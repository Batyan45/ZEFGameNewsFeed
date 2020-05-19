package com.batyan.zefgame.utilities;

class RSSHelper {
    static int parseId(String s) {
        return Integer.parseInt(s.substring(s.indexOf("=") +1));
    }
}
