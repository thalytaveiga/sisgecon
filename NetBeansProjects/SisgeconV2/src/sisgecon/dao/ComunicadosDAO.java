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
import javax.swing.table.DefaultTableModel;
import sisgecon.connection.Connection;
import sisgecon.vo.ComunicadosVO;

/**
 *
 * @author thalytaveiga
 */
public class ComunicadosDAO {
    
    private Connection con;
      
      public ComunicadosDAO() throws SQLException{
            this.con = new Connection();
      } 
    
      public DefaultTableModel getComunicados() throws SQLException{
        
        PreparedStatement stm = this.con.prepareStatement("SELECT * FROM comunicado");
        ResultSet rs = stm.executeQuery();
        
        DefaultTableModel model = new DefaultTableModel(new String[]{"Código", "Título", "Data Cadastro", "Comunicado"}, 0);
        
        while(rs.next()){
            String id = rs.getString("id");
            String titulo = rs.getString("titulo");
            String datacadastro = rs.getString("datacadastro");
            String comunicado = rs.getString("comunicado");
            model.addRow(new Object[]{id, titulo, datacadastro, comunicado});
        }
        
        rs.close();
        stm.close();
        
        return model;
   }
      
      public void atualizarComunicados(ComunicadosVO comunicadosVO) throws SQLException{

        String sql = "UPDATE comunicado"
                + " SET  situacao = '" + comunicadosVO.getSituacao()
                + "', titulo = '" + comunicadosVO.getTitulo()
                + "', comunicado = " + comunicadosVO.getComunicado()
                + ", idUsuarioCadastro = '" + comunicadosVO.getIdUsuarioCadastro()
                + ", datacadastro = '" + comunicadosVO.getDataCadastro()
                + "' WHERE id = " + comunicadosVO.getId();

        PreparedStatement stm = this.con.prepareStatement(sql);
        
        try {
            
            System.out.println(sql);
                      
            // execute insert SQL stetement
            stm.executeUpdate();
            System.out.println("Comunicado inserido com sucesso!");
            
        } catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new SQLException();
        } finally {
            if (stm != null) {
                    stm.close();
            }
        }
   }
      
      public void inserirComunicado (ComunicadosVO comunicadosVO) throws SQLException{

        String sql = "INSERT INTO comunicado (titulo, comunicado, datacadastro, idusuariocadastro)"
                + " VALUES (?,?,?,?);";

        PreparedStatement stm = this.con.prepareStatement(sql);
        
        try {
            
            System.out.println(sql);
            
            stm.setString(1, comunicadosVO.getTitulo());
            stm.setString(2, comunicadosVO.getComunicado());
            stm.setDate(3, new java.sql.Date(comunicadosVO.getDataCadastro().getTime()));
            stm.setInt(4, comunicadosVO.getIdUsuarioCadastro());
            
            // execute insert SQL stetement
            stm.executeUpdate();
            System.out.println("Comunicado cadastrado com sucesso!");
            
        } catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new SQLException();
        } finally {
            if (stm != null) {
                    stm.close();
            }
        }
   }
      
      public ComunicadosVO populateComunicadosVO(ResultSet rs) throws SQLException{
        ComunicadosVO comunicadosVO = null;
        
        if(rs.next()){

            comunicadosVO = new ComunicadosVO ();

            comunicadosVO.setId(rs.getInt("id"));
            comunicadosVO.setSituacao(rs.getInt("situacao"));
            comunicadosVO.setTitulo(rs.getString("titulo"));
            comunicadosVO.setComunicado(rs.getString("comunicado"));
            comunicadosVO.setIdUsuarioCadastro(rs.getInt("idUsuarioCadastro"));
            comunicadosVO.setDataCadastro(rs.getDate("dataCadastro"));
        }
        
        return comunicadosVO;
    }
      
    public void deletar(String id) throws SQLException{

        String sql = "DELETE from comunicado"
                + " WHERE id = " + id;

        PreparedStatement stm = this.con.prepareStatement(sql);
        
        try {
            
            System.out.println(sql);
                      
            // execute insert SQL stetement
            stm.executeUpdate();
            System.out.println("Comunicado excluído com sucesso!");
            
        } catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new SQLException();
        } finally {
            if (stm != null) {
                    stm.close();
            }
        }
    }
    
}
