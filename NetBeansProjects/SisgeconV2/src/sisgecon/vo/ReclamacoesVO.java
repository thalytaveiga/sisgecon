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
public class ReclamacoesVO {
    
    private Integer id;
    private String reclamacao;
    private Integer idUsuarioReclamacao;
    private Date dataReclamacao;
    
    
    public ReclamacoesVO(Integer id, String reclamacao, Integer idUsuarioReclamacao, Date dataReclamacao) {
        this.id = id;
        this.reclamacao = reclamacao;
        this.idUsuarioReclamacao = idUsuarioReclamacao;
        this.dataReclamacao = dataReclamacao;
    }
        
        public ReclamacoesVO(){
            
        }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReclamacao() {
        return reclamacao;
    }

    public void setReclamacao(String reclamacao) {
        this.reclamacao = reclamacao;
    }

    public Integer getIdUsuarioReclamacao() {
        return idUsuarioReclamacao;
    }

    public void setIdUsuarioReclamacao(Integer idUsuarioReclamacao) {
        this.idUsuarioReclamacao = idUsuarioReclamacao;
    }

    public Date getDataReclamacao() {
        return dataReclamacao;
    }

    public void setDataReclamacao(Date dataReclamacao) {
        this.dataReclamacao = dataReclamacao;
    }
       
}
