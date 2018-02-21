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
import sisgecon.vo.BoletoVO;
/**
 *
 * @author thalytaveiga
 */
public class BoletoDAO {
    
    private Connection con;
      
      public BoletoDAO() throws SQLException{
            this.con = new Connection();
      } 
    
      public List<BoletoVO> getBoleto() throws SQLException{
        
        List<BoletoVO> lista = new ArrayList<BoletoVO>();
        PreparedStatement stm = this.con.prepareStatement("SELECT * FROM boleto");
        ResultSet rs = stm.executeQuery();
        
        while(rs.next()){
            BoletoVO boletoVO = populateBoletoVO(rs);
            lista.add(boletoVO);
        }
        
        rs.close();
        stm.close();
        
        return lista;
   }
    
      
      
      public void atualizarBoleto(BoletoVO boletoVO) throws SQLException{

        String sql = "UPDATE boleto"
                + " SET  codigoBoleto = '" + boletoVO.getCodigoBoleto()
                + "', dataVencimento = " + boletoVO.getDataVencimento()
                + ", idUsuarioApto = '" + boletoVO.getIdUsuarioApto()
                + "' WHERE id = " + boletoVO.getId();

        PreparedStatement stm = this.con.prepareStatement(sql);
        
        try {
            
            System.out.println(sql);
                      
            // execute insert SQL stetement
            stm.executeUpdate();
            System.out.println("Boleto gerado com sucesso!");
            
        } catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new SQLException();
        } finally {
            if (stm != null) {
                    stm.close();
            }
        }
   }
      
      public BoletoVO populateBoletoVO(ResultSet rs) throws SQLException{
        BoletoVO boletoVO = null;
        
        if(rs.next()){

            boletoVO = new BoletoVO ();

            boletoVO.setId(rs.getInt("id"));
            boletoVO.setCodigoBoleto(rs.getString("codigoBoleto"));
            boletoVO.setDataVencimento(rs.getDate("dataVencimento"));
            boletoVO.setIdUsuarioApto(rs.getInt("idUsuarioApto"));
        }
        
        return boletoVO;
    }

    
}
