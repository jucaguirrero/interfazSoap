package com.UntoonSoap.conexionRest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.UntoonSoap.conexionRest.Models.ComicSoap;


@RestController
@RequestMapping("rest")
public class ClienteHttpRestt 
{

	public String uriGateWay = "http://localhost:5000/graphql"; //conexion local, cambiar segun corresponda 
	
	@GetMapping()
	@RequestMapping("")
	public List<ComicSoap> listar() 
			throws ClientProtocolException, IOException 
			
	{	List<ComicSoap> listaux = new ArrayList<ComicSoap>();
		listaux = getComics();
		return null;
	}
	
	public List<ComicSoap> getComics () 
			throws ClientProtocolException, IOException 
	{
		
			
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(uriGateWay);  
		
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("query", "query{allComics{nombre autor}}"));
		
		httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
	   
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entity = response.getEntity();
		
		if (entity != null) {
		    try (InputStream instream = entity.getContent()) {
		    	 System.out.println(EntityUtils.toString(response.getEntity()));
		    }
		}
		
		return null;
	}
}
