package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}
}

//FIXME: Add route to enable check sum return of static data example:  String data = "Hello World Check Sum!";
@RestController
class ServerController{ 
    @RequestMapping("/hash")
    public String myHash() throws NoSuchAlgorithmException{
    	String data = "Hello World Check Sum!"; 
    	String cypher = "SHA-256";
    	MessageDigest md = MessageDigest.getInstance(cypher);
    	md.digest(data.getBytes());
    	byte[] cert = md.digest();
    	String format = "Data:%s\nName of Cypher Algorithm Used:%s\nValue:%H";
    	String myString = String.format(format, data,cypher,cert);
        return myString ;
    }
}

