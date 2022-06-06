package com.example.producingwebservice.Rest;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


import io.spring.guides.gs_producing_web_service.Comicsoap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("rest")
public class ClienteHttpRestt {
    public String uriGateWay = "http://localhost:5000/graphql"; //conexion local, cambiar segun corresponda

    @GetMapping()
    @RequestMapping("{id}")
    public Comicsoap getComicById(@PathVariable int id)
            throws ClientProtocolException, IOException, JSONException
    {

        System.out.println("alsdkfjalsdkjlsdkjf");
        Comicsoap comicSoap = new Comicsoap();
        comicSoap = getComics(id);
        return comicSoap;
    }

    public Comicsoap getComics (int id)
            throws ClientProtocolException, IOException, JSONException {


        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(uriGateWay);

        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("query", "query{comicById(id:"+ id +"){nombre autor}}"));

        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            try (InputStream instream = entity.getContent()) {
                //System.out.println(EntityUtils.toString(response.getEntity()));
                String entrada = EntityUtils.toString(response.getEntity());
                JSONObject json = new JSONObject(entrada);

                JSONObject jsonData = json.getJSONObject("data");

                JSONObject jsonComic = jsonData.getJSONObject("comicById");

                Comicsoap com = new Comicsoap();
                com.setNombre(jsonComic.getString("nombre"));
                com.setAutor(jsonComic.getString("autor"));


                return com;

            }
        }

        return null;
    }
}

