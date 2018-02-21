/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisgecon.vo;

/**
 *
 * @author thalytaveiga
 * 
 * Classe responsável por representar a tabela Usuário do Banco de dados.
 */
public class UsuarioVO {
    private Integer id;
    private String apto;
    private String cpf;
    private String nome;
    private String endereco;
    private Integer numero;
    private String complemento;
    private String cidade;
    private String uf;
    private String cep;
    private String email;
    private String telefone;
    private String celular;
    private String senha;
    private Integer idTipoUsuario;
    private Integer primeiroAcesso;
    private Integer situacao;

    public UsuarioVO(String apto, String cpf, String nome, String endereco, Integer numero, String complemento, String cidade, String uf, String cep, String email, String telefone, String celular, String senha, Integer idTipoUsuario, Integer primeiroAcesso, Integer situacao) {
        this.apto = apto;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.senha = senha;
        this.idTipoUsuario = idTipoUsuario;
        this.primeiroAcesso = primeiroAcesso;
        this.situacao = situacao;
    }

    public UsuarioVO() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApto() {
        return apto;
    }

    public void setApto(String apto) {
        this.apto = apto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public Integer getPrimeiroAcesso() {
        return primeiroAcesso;
    }

    public void setPrimeiroAcesso(Integer primeiroAcesso) {
        this.primeiroAcesso = primeiroAcesso;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }
    
    
}
