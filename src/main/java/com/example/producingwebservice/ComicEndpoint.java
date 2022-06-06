package com.example.producingwebservice;


import io.spring.guides.gs_producing_web_service.Comicsoap;
import io.spring.guides.gs_producing_web_service.GetComicRequest;
import io.spring.guides.gs_producing_web_service.GetComicResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.io.IOException;


@Endpoint
public class ComicEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @Autowired
    private ComicSoapRepository comicRepository;



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getComicRequest")
    @ResponsePayload
    public GetComicResponse getComicSoap (@RequestPayload GetComicRequest request)
            throws IOException {
        System.out.println("aksjdhaksjdhakjsdhaikjshd");
        GetComicResponse response = new GetComicResponse();
        Comicsoap com = comicRepository.comicbyid(request.getId());

        response.setComic(com);

        return response;
    }




}