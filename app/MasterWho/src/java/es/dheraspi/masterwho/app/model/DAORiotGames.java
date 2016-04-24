/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.dheraspi.masterwho.app.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Properties;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author david
 */
public class DAORiotGames implements DAO
{
    private String APIKey;
    private int summId;
    
    @Override
    public void init() throws IOException 
    {
        String propFileName = "connection.properties";
        Properties prop = new Properties();
        
        try (InputStream is = getClass().getResourceAsStream(propFileName))
        {           
            prop.load(is);         
            this.APIKey = prop.getProperty("APIKey");
        }
    }
}
