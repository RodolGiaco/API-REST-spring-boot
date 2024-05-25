package com.kube.rodo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientRenderController {
    @GetMapping(value = "/clients-html", produces = MediaType.TEXT_HTML_VALUE)
    public String getClientAsHtml(){
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<body>");
        sb.append(" <div><h1>Client</h1>");
        sb.append("  <ul>");
        sb.append("   <li>Nombre: Rodolfo Giacomodonatto</li>");
        sb.append("   <li>UserName: RBL</li>");
        sb.append("  </ul>");
        sb.append(" </div>");
        sb.append("</html>");
        return sb.toString();

    }

    @GetMapping(value = "/clients-xml", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public String getClientAsXml(){
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append(" <client>");
        sb.append("   <name>Nombre: Rodolfo Giacomodonatto</name>");
        sb.append("   <username>UserName: RBL</username>");
        sb.append(" </client>");
        sb.append("</xml>");
        return sb.toString();

    }
}
