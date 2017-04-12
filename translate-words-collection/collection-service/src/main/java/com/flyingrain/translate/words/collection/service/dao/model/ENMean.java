package com.flyingrain.translate.words.collection.service.dao.model;

import java.util.Date;

/**
 * Created by wally on 4/12/17.
 */
public class ENMean {
    private int id;
    private int word_id;
    private String n;
    private String adj;
    private String adv;
    private String v;
    private String vi;
    private String vt;
    private Date data_added;
    private Date last_modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWord_id() {
        return word_id;
    }

    public void setWord_id(int word_id) {
        this.word_id = word_id;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getAdj() {
        return adj;
    }

    public void setAdj(String adj) {
        this.adj = adj;
    }

    public String getAdv() {
        return adv;
    }

    public void setAdv(String adv) {
        this.adv = adv;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getVi() {
        return vi;
    }

    public void setVi(String vi) {
        this.vi = vi;
    }

    public String getVt() {
        return vt;
    }

    public void setVt(String vt) {
        this.vt = vt;
    }

    public Date getData_added() {
        return data_added;
    }

    public void setData_added(Date data_added) {
        this.data_added = data_added;
    }

    public Date getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(Date last_modified) {
        this.last_modified = last_modified;
    }

    @Override
    public String toString() {
        return "ENMean{" +
                "id=" + id +
                ", word_id=" + word_id +
                ", n='" + n + '\'' +
                ", adj='" + adj + '\'' +
                ", adv='" + adv + '\'' +
                ", v='" + v + '\'' +
                ", vi='" + vi + '\'' +
                ", vt='" + vt + '\'' +
                ", data_added=" + data_added +
                ", last_modified=" + last_modified +
                '}';
    }
}
