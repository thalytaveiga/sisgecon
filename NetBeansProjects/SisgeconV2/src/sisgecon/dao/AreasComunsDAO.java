/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisgecon.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sisgecon.connection.Connection;
import sisgecon.vo.AreasComunsVO;

/**
 *
 * @author thalytaveiga
 */
public class AreasComunsDAO {
    
    private Connection con;
      
      public AreasComunsDAO() throws SQLException{
            this.con = new Connection();
      } 
    
      /*public List<AreasComunsVO> getAreasComuns() throws SQLException{
        
        List<AreasComunsVO> lista = new ArrayList<AreasComunsVO>();
        PreparedStatement stm = this.con.prepareStatement("SELECT * FROM reserva");
        ResultSet rs = stm.executeQuery();
        
        while(rs.next()){
            AreasComunsVO areascomunsVO = populateAreasComunsVO(rs);
            lista.add(areascomunsVO);
        }
        
        rs.close();
        stm.close();
        
        return lista;
   }*/
    
      
      
      public void cadastrarAreasComuns(AreasComunsVO areascomunsVO) throws SQLException{

         String sql = "INSERT INTO reserva (idArea, data, idusuarioreserva)"
                + " VALUES (?,?,?);";

        PreparedStatement stm = this.con.prepareStatement(sql);
        
        try {
            
            System.out.println(sql);
              
            stm.setInt(1, areascomunsVO.getIdArea());
            stm.setDate(2, new java.sql.Date(areascomunsVO.getData().getTime()));
            stm.setInt(3, areascomunsVO.getIdUsuarioReserva());
            // execute insert SQL stetement
            stm.executeUpdate();
            System.out.println("Reserva concluída com sucesso!");            
        } 
        
        catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new SQLException();
        } 
        
        finally {
            if (stm != null) {
                    stm.close();
            }
        }
   }
      
      public AreasComunsVO populateAreasComunsVO(ResultSet rs, String situacao) throws SQLException{
        AreasComunsVO areascomunsVO = null;
        
        if(rs.isFirst()){
            areascomunsVO = new AreasComunsVO ();

            areascomunsVO.setId(rs.getInt("id"));
            areascomunsVO.setIdArea(rs.getInt("idArea"));
            areascomunsVO.setSituacao(situacao);
            areascomunsVO.setData(rs.getDate("data"));
        }
        
        return areascomunsVO;
    }
      
      public AreasComunsVO consultarArea(Integer area, Date data) throws SQLException, ParseException{
          
          AreasComunsVO areascomunsVO = new AreasComunsVO();
          areascomunsVO.setSituacao("Disponível");
          areascomunsVO.setData(data);
          areascomunsVO.setIdArea(area);
          PreparedStatement stm = this.con.prepareStatement("SELECT * FROM reserva "
                + "WHERE idArea = ? "
                  + "and to_char(data, 'yyyy-MM-dd') = ? ");
        stm.setInt(1, area);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(2, sdf.format(data));
        ResultSet rs = stm.executeQuery();
        
        if(rs.next()) {
            areascomunsVO = populateAreasComunsVO(rs, "Indisponível");
            return areascomunsVO;    
        }
        
        rs.close();
        stm.close();
          
            return areascomunsVO;
      }
      
      public void deletarReserva(AreasComunsVO areascomunsVO) throws SQLException{

        String sql = "DELETE from reserva"
                + " WHERE id = " + areascomunsVO.getId();

        PreparedStatement stm = this.con.prepareStatement(sql);
        
        try {
            
            System.out.println(sql);
                      
            // execute insert SQL stetement
            stm.executeUpdate();
            System.out.println("Cancelamento concluído com sucesso!");
            
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
