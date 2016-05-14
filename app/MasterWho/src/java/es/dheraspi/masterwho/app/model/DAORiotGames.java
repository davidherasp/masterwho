/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.dheraspi.masterwho.app.model;

import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.championmastery.ChampionMastery;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.staticdata.Champion;
import com.robrua.orianna.type.core.summoner.Summoner;
import es.dheraspi.masterwho.app.servlets.MWChampion;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author david
 */
public class DAORiotGames implements DAO
{
    private String APIKey;
    private Summoner summoner;
    
    @Override
    public void init() throws IOException 
    {
        String propFileName = "connection.properties";
        Properties prop = new Properties();
        
        try (InputStream is = getClass().getResourceAsStream(propFileName))
        {           
            prop.load(is);
            RiotAPI.setAPIKey(prop.getProperty("APIKey"));
        }
    }

    @Override
    public void setRegion(String region) 
    {
        RiotAPI.setRegion(Region.valueOf(region));
    }

    @Override
    public void setSummoner(String name)
    {
        summoner = RiotAPI.getSummonerByName(name);
        System.out.println(summoner);
    }
    
    @Override
    public List<MWChampion> getMasteries(Summoner summoner)
    {
        List<ChampionMastery> champs = RiotAPI.getChampionMastery(summoner);
        System.out.println(champs);
        List<MWChampion> realChamps = new LinkedList<>();
        
        for (ChampionMastery champMastery: champs)
        {
            Champion champ = RiotAPI.getChampionByID(champMastery.getChampionID());
            MWChampion mwChamp = new MWChampion(champMastery,champ);
            realChamps.add(mwChamp);
        }
        return realChamps;
    }
}
