package com.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlContentReader {
    /**
     * Do GET request to target host
     *
     * @param target
     *            - like "https://www.delfi.lt"
     * @return page content
     */
    public static StringBuilder readContent(String target) {

        StringBuilder builder = new StringBuilder();
        try {
            // TODO does not work with response codes above 400


            BufferedReader in = new BufferedReader(new InputStreamReader((new URL(target)).openStream()));
            in.lines().forEachOrdered(ln -> builder.append(ln + "\n"));
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return builder;
    }

    public static Document readContentInJsoupDocument(String target){
        StringBuilder stingBuilderHtml = readContent(target);
        return Jsoup.parse(stingBuilderHtml.toString());
    }
}
