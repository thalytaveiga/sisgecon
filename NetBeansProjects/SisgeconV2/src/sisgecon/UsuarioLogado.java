/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisgecon;

import sisgecon.vo.UsuarioVO;

/**
 *
 * @author thalytaveiga
 */
public class UsuarioLogado {
    
    private UsuarioVO usuarioVO;
    
    private UsuarioLogado() {}

    private static class UsuarioLogadoHolder { 
        private final static UsuarioLogado instance = new UsuarioLogado();
    }
    
    public static UsuarioLogado getInstance() {
        return UsuarioLogadoHolder.instance;
    }

    public UsuarioVO getUsuarioVO() {
        return usuarioVO;
    }

    public void setUsuarioVO(UsuarioVO usuarioVO) {
        this.usuarioVO = usuarioVO;
    }
        
    
}
