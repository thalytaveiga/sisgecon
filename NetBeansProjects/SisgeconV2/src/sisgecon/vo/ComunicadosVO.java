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
public class ComunicadosVO {
    
    private Integer id;
    private Integer situacao;
    private String titulo;
    private String comunicado;
    private Integer idUsuarioCadastro;
    private Date dataCadastro;

    private ComunicadosVO(Integer id, Integer situacao, String titulo, String comunicado, Integer idUsuarioCadastro, Date dataCadastro){
        this.id = id;
        this.situacao = situacao;
        this.titulo = titulo;
        this.comunicado = comunicado;
        this.idUsuarioCadastro = idUsuarioCadastro;
        this.dataCadastro = dataCadastro;
    }
    
    public ComunicadosVO(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getComunicado() {
        return comunicado;
    }

    public void setComunicado(String comunicado) {
        this.comunicado = comunicado;
    }

    public Integer getIdUsuarioCadastro() {
        return idUsuarioCadastro;
    }

    public void setIdUsuarioCadastro(Integer idUsuarioCadastro) {
        this.idUsuarioCadastro = idUsuarioCadastro;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    
    
    
}
