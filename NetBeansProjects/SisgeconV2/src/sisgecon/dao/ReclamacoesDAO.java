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
import sisgecon.vo.ReclamacoesVO;
/**
 *
 * @author thalytaveiga
 */
public class ReclamacoesDAO {
    
    private Connection con;
      
      public ReclamacoesDAO() throws SQLException{
            this.con = new Connection();
      } 
    
      public DefaultTableModel getReclamacoes() throws SQLException{
        
        PreparedStatement stm = this.con.prepareStatement("SELECT * FROM reclamacao");
        ResultSet rs = stm.executeQuery();
        
        DefaultTableModel model = new DefaultTableModel(new String[]{"Data de Cadastro", "Reclamação"}, 0);
        
        while(rs.next()){
            
            String data = rs.getString("datareclamacao");
            String reclamacao = rs.getString("reclamacao");
            
            model.addRow(new Object[]{data, reclamacao});
        }
        
        rs.close();
        stm.close();
        
        return model;
   }
    
public void inserir(ReclamacoesVO reclamacoesVO) throws SQLException{

        String sql = "INSERT INTO reclamacao (reclamacao, datareclamacao, idusuarioreclamacao)"
                + " VALUES (?,?,?);";

        PreparedStatement stm = this.con.prepareStatement(sql);
        
        try {
            
            System.out.println(sql);
            
            stm.setString(1, reclamacoesVO.getReclamacao());
            stm.setDate(2, new java.sql.Date(reclamacoesVO.getDataReclamacao().getTime()));
            stm.setInt(3, reclamacoesVO.getIdUsuarioReclamacao());
            
            // execute insert SQL stetement
            stm.executeUpdate();
            System.out.println("Reclamacao cadastrada com sucesso!");
            
        } catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new SQLException();
        } finally {
            if (stm != null) {
                    stm.close();
            }
        }
   }
      
      
      public void atualizarReclamacoes(ReclamacoesVO reclamacoesVO) throws SQLException{

        String sql = "UPDATE reclamacao"
                + " SET  reclamacao = '" + reclamacoesVO.getReclamacao()
                + "', dataReclamacao = " + reclamacoesVO.getDataReclamacao()
                + ", idUsuarioReclamacao = '" + reclamacoesVO.getIdUsuarioReclamacao()
                + "' WHERE id = " + reclamacoesVO.getId();

        PreparedStatement stm = this.con.prepareStatement(sql);
        
        try {
            
            System.out.println(sql);
                      
            // execute insert SQL stetement
            stm.executeUpdate();
            System.out.println("Reclamação enviada com sucesso!");
            
        } catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new SQLException();
        } finally {
            if (stm != null) {
                    stm.close();
            }
        }
   }
      
      public ReclamacoesVO populateReclamacoesVO(ResultSet rs) throws SQLException{
        ReclamacoesVO reclamacoesVO = null;
        
        if(rs.next()){

            reclamacoesVO = new ReclamacoesVO ();

            reclamacoesVO.setId(rs.getInt("id"));
            reclamacoesVO.setReclamacao(rs.getString("reclamacao"));
            reclamacoesVO.setDataReclamacao(rs.getDate("dataReclamacao"));
            reclamacoesVO.setIdUsuarioReclamacao(rs.getInt("idUsuarioReclamacao"));
        }
        
        return reclamacoesVO;
    }
    
}
