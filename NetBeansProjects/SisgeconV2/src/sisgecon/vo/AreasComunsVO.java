/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisgecon.vo;

import java.util.Date;

/**
 *
 * @author thalytaveiga
 */
public class AreasComunsVO {
    
    private Integer id;
    private Integer idArea;
    private String situacao;
    private Date data;
    private Integer idUsuarioReserva;
    
    
    public AreasComunsVO(Integer id, Integer idArea, String situacao, Date data, Integer idUsuarioReserva) {
        this.id = id;
        this.idArea = idArea;
        this.situacao = situacao;
        this.data = data;
        this.idUsuarioReserva = idUsuarioReserva;
    }

    
    public AreasComunsVO() {
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getIdUsuarioReserva() {
        return idUsuarioReserva;
    }

    public void setIdUsuarioReserva(Integer idUsuarioReserva) {
        this.idUsuarioReserva = idUsuarioReserva;
    }
    
    
    
}
