/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.dheraspi.masterwho.app.servlets;

import com.robrua.orianna.type.core.championmastery.ChampionMastery;
import com.robrua.orianna.type.core.staticdata.Champion;

/**
 *
 * @author david
 */
public class MWChampion {
    private ChampionMastery championMastery;
    private Champion champion; 

    public MWChampion(ChampionMastery championMastery, Champion champion) {
        this.championMastery = championMastery;
        this.champion = champion;
    }

    public ChampionMastery getChampionMastery() {
        return championMastery;
    }

    public void setChampionMastery(ChampionMastery championMastery) {
        this.championMastery = championMastery;
    }

    public Champion getChampion() {
        return champion;
    }

    public void setChampion(Champion champion) {
        this.champion = champion;
    }

    @Override
    public String toString() {
        return "MasterWhoChampion{" + "championMastery=" + championMastery + ", champion=" + champion + '}';
    }
}
