/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.dheraspi.masterwho.app.servlets;

/**
 *
 * @author david
 */
class MWTeam {
    private MWChampion top;
    private MWChampion jng;
    private MWChampion mid;
    private MWChampion adc;
    private MWChampion sup;

    public MWChampion getTop() {
        return top;
    }

    public void setTop(MWChampion top) {
        this.top = top;
    }

    public MWChampion getJng() {
        return jng;
    }

    public void setJng(MWChampion jng) {
        this.jng = jng;
    }

    public MWChampion getMid() {
        return mid;
    }

    public void setMid(MWChampion mid) {
        this.mid = mid;
    }

    public MWChampion getAdc() {
        return adc;
    }

    public void setAdc(MWChampion adc) {
        this.adc = adc;
    }

    public MWChampion getSup() {
        return sup;
    }

    public void setSup(MWChampion sup) {
        this.sup = sup;
    }
}
