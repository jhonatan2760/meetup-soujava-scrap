package com.jhonatansouza.web;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WebPageDocument {


    private final String url;
    private final String userAgent = "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.5; en-US; rv:1.9.1b3) Gecko/20090305 Firefox/3.1b3 GTB5";;

    public WebPageDocument(String url) {
        this.url = url;
    }

    public Document doSearch(String data) throws IOException {
        return this.createConnection()
                .data("conteudo", data)
                .get();
    }

    public Document capture() throws IOException {
        return this.createConnection().get();
    }

    private Connection createConnection(){
        return Jsoup.connect(this.url)
                .userAgent(this.userAgent)
                .followRedirects(true);
    }
}
