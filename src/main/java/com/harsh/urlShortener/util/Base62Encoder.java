package com.harsh.urlShortener.util;

public class Base62Encoder {

    private static final String BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public String encode(long id) {
        if(id == 0){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        long temp = id;
        while(temp > 0){
            long rem = temp%62;
            sb.append(BASE62.charAt((int)rem));
            temp = temp/62;
        }

        return sb.reverse().toString();
    }

}
