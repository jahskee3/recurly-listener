package com.j3source.recurly.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/recurly")
public class ListenerController {

    @RequestMapping(value = "/listener", method = RequestMethod.POST)
    public String listenerPost(ModelMap model, HttpServletRequest request) throws IOException {
    	String host = request.getHeader("Host");
    	String contentType = request.getHeader("Content-Type");
    	InputStream xml = request.getInputStream();
    	
    	StringWriter writer = new StringWriter();
    	IOUtils.copy(xml, writer, "UTF-8");
    	String theString = writer.toString();
        model.addAttribute("msg", "Host:"+host);
        return "hello";
    }
    
	@RequestMapping(value = "/test", method = RequestMethod.GET)
    public String hello(ModelMap model) {
        model.addAttribute("msg", "Testing Recurly webhook listener!");
        return "test";
    }
}
