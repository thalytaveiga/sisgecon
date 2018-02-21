/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisgecon.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sisgecon.connection.Connection;
import sisgecon.vo.UsuarioVO;

/**
 *
 * @author thalytaveiga
 */
public class UsuarioDAO {
    
      private Connection con;
      
      public UsuarioDAO() throws SQLException{
            this.con = new Connection();
      } 
      
    public List<UsuarioVO> getUsuarios() throws SQLException{
        
        List<UsuarioVO> lista = new ArrayList<UsuarioVO>();
        PreparedStatement stm = this.con.prepareStatement("SELECT * FROM usuario");
        ResultSet rs = stm.executeQuery();
        
        while(!rs.isLast()){
            UsuarioVO usuario = populateUsuarioVO(rs);
            lista.add(usuario);
        }
        
        rs.close();
        stm.close();
        
        return lista;
   }
    
    public void atualizarUsuario(UsuarioVO usuarioVO) throws SQLException{

        String sql = "UPDATE usuario"
                + " SET  nome = '" + usuarioVO.getNome()
                + "', endereco = '" + usuarioVO.getEndereco()
                + "', numero = " + usuarioVO.getNumero()
                + ", complemento = '" + usuarioVO.getComplemento()
                + "', cidade = '" + usuarioVO.getCidade()
                + "', uf = '" + usuarioVO.getUf()
                + "', cep = '" + usuarioVO.getCep()
                + "', email = '" + usuarioVO.getEmail()
                + "', telefone = '" + usuarioVO.getTelefone()
                + "', celular = '" + usuarioVO.getCelular()
                + "', senha = '" + usuarioVO.getSenha()
                + "', apto = '" + usuarioVO.getApto()
                + "' WHERE id = " + usuarioVO.getId();

        PreparedStatement stm = this.con.prepareStatement(sql);
        
        try {
            
            System.out.println(sql);
                      
            // execute insert SQL stetement
            stm.executeUpdate();
            System.out.println("Registro atualizado na tabela");
            
        } catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new SQLException();
        } finally {
            if (stm != null) {
                    stm.close();
            }
        }
   }
    
    public void inserirCpf (UsuarioVO usuarioVO) throws SQLException{

        String sql = "INSERT INTO usuario (cpf, senha, idTipoUsuario)"
                + " VALUES (?,?,?);";

        PreparedStatement stm = this.con.prepareStatement(sql);
        
        try {
            
            System.out.println(sql);
            
            stm.setString(1, usuarioVO.getCpf().replace(".", "").replace("-", ""));
            stm.setString(2, usuarioVO.getSenha());
            stm.setInt(3, usuarioVO.getIdTipoUsuario());

            
            // execute insert SQL stetement
            stm.executeUpdate();
            System.out.println("CPF cadastrado com sucesso!");
            
        } catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new SQLException();
        } finally {
            if (stm != null) {
                    stm.close();
            }
        }
   }
    
    
    public UsuarioVO getUsuarioCPF(String cpf) throws SQLException{
        
        PreparedStatement stm = this.con.prepareStatement("SELECT * FROM usuario "
                + "WHERE cpf = ?");
        stm.setString(1, cpf);
        ResultSet rs = stm.executeQuery();
        
        UsuarioVO usuario = populateUsuarioVO(rs);
        
        rs.close();
        stm.close();
        
        return usuario;
   }

    public UsuarioVO populateUsuarioVO(ResultSet rs) throws SQLException{
        UsuarioVO usuarioVO = null;
        
        if(rs.next()){

            usuarioVO = new UsuarioVO ();

            usuarioVO.setIdTipoUsuario(rs.getInt("idtipousuario"));
            usuarioVO.setApto(rs.getString("apto"));
            usuarioVO.setCelular(rs.getString("celular"));
            usuarioVO.setCep(rs.getString("cep"));
            usuarioVO.setCidade(rs.getString("cidade"));
            usuarioVO.setComplemento(rs.getString("complemento"));
            usuarioVO.setEmail(rs.getString("email"));
            usuarioVO.setEndereco(rs.getString("endereco"));
            usuarioVO.setUf(rs.getString("uf"));
            usuarioVO.setNome(rs.getString("nome"));
            usuarioVO.setNumero(rs.getInt("numero"));
            usuarioVO.setTelefone(rs.getString("telefone"));
            usuarioVO.setNumero(rs.getInt("idtipousuario"));
            usuarioVO.setNumero(rs.getInt("primeiroacesso"));
            usuarioVO.setNumero(rs.getInt("situacao"));
            usuarioVO.setId(rs.getInt("id"));
            usuarioVO.setSenha(rs.getString("senha"));
            usuarioVO.setCpf(rs.getString("cpf"));
        }
        
        return usuarioVO;
    }
}
