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
public class BoletoVO {
    
    
    private Integer id;
    private String codigoBoleto;
    private Integer idUsuarioApto;
    private Date dataVencimento;
    
    
    public BoletoVO(Integer id, String codigoBoleto, Integer idUsuarioApto, Date dataVecimento) {
        this.id = id;
        this.codigoBoleto = codigoBoleto;
        this.idUsuarioApto = idUsuarioApto;
        this.dataVencimento = dataVencimento;
        
    }

    public BoletoVO(){
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoBoleto() {
        return codigoBoleto;
    }

    public void setCodigoBoleto(String codigoBoleto) {
        this.codigoBoleto = codigoBoleto;
    }

    public Integer getIdUsuarioApto() {
        return idUsuarioApto;
    }

    public void setIdUsuarioApto(Integer idUsuarioApto) {
        this.idUsuarioApto = idUsuarioApto;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    
    
    
}
