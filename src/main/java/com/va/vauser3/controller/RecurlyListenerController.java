package com.va.vauser3.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;

import org.apache.commons.io.IOUtils;
import org.jdom2.JDOMException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.va.vauser3.controller.recurlylistener.unmarshall.UnmarshallUtil;



@Controller
public class RecurlyListenerController {

    @RequestMapping(value = "/listener", method = RequestMethod.POST)
    public void listenerPost(ModelMap model, HttpServletRequest request) throws IOException, JDOMException, JAXBException {
//    	String host = request.getHeader("Host");
//    	String contentType = request.getHeader("Content-Type");
    	InputStream xml = request.getInputStream();
    	
    	StringWriter writer = new StringWriter();
    	IOUtils.copy(xml, writer, "UTF-8");
    	String xmlData = writer.toString();
        
    	UnmarshallUtil.eventAction(xmlData);
    	
        
    }
    
	@RequestMapping(value = "/listener", method = RequestMethod.GET)
    public String hello(ModelMap model) {
        model.addAttribute("msg", "Testing Recurly webhook listener!");
        return "listener";
    }
}
