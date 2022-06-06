package com.example.producingwebservice;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import com.example.producingwebservice.Rest.ClienteHttpRestt;
import io.spring.guides.gs_producing_web_service.Comicsoap;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class ComicSoapRepository {
    private static final Map<Integer, Comicsoap> comics = new HashMap<>();





    public Comicsoap comicbyid (int id) throws JSONException, IOException {

        Assert.notNull(id, "The id must not be null");
        ClienteHttpRestt rest = new ClienteHttpRestt();
        Comicsoap com = rest.getComics(id);
        return comics.get(com);
    }

}