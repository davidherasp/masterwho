/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.dheraspi.masterwho.app.model;

import es.dheraspi.masterwho.app.servlets.MasterWhoChampion;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author david
 */
public interface DAO{
    public void init() throws IOException;
    public void setRegion(String region);
    public void setSummoner(String region);
    public List<MasterWhoChampion> getMasteries();
}
