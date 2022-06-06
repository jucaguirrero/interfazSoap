//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.06.06 a las 03:00:21 PM EST 
//


package io.spring.guides.gs_producing_web_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="comic" type="{http://spring.io/guides/gs-producing-web-service}comicsoap"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "comic"
})
@XmlRootElement(name = "getComicResponse")
public class GetComicResponse {

    @XmlElement(required = true)
    protected Comicsoap comic;

    /**
     * Obtiene el valor de la propiedad comic.
     * 
     * @return
     *     possible object is
     *     {@link Comicsoap }
     *     
     */
    public Comicsoap getComic() {
        return comic;
    }

    /**
     * Define el valor de la propiedad comic.
     * 
     * @param value
     *     allowed object is
     *     {@link Comicsoap }
     *     
     */
    public void setComic(Comicsoap value) {
        this.comic = value;
    }

}
