package Model.dao;
 


import Model.entidade.PerguntaResposta;
import Model.entidade.Chat;
import Model.sgbd.Oracle;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
*/

public class DaoPerguntaResposta {
	
	
	private static final String ConexaoUtil = null;
	public boolean consulta(PerguntaResposta pergunta_resposta) {
		boolean retorno = false;
		Oracle o = new Oracle();
		if (o.carregaDriver() && o.conecta() && o.comando()) {
			
			String sql = " SELECT INTO PERGUNTA_RESPOSTA VALUES (" 
					+ pergunta_resposta.getCodigo() +
					","  + pergunta_resposta.getId_chat() + 
					",'"  + pergunta_resposta.getPergunta() +
					"','"  + pergunta_resposta.getResposta() +
					")";
			
			if (o.consulta(sql)) {
				retorno = true;
				o.disconecta();
			}
		}
		return retorno;
	}
	/*
	public List<PerguntaResposta> read() {

		List<PerguntaResposta> perguntaResposta = new ArrayList<PerguntaResposta>();
       
        try {
             Connection connection = ConexaoUtil.getInstance().getConnection();

            while (rs.next()) {

            	PerguntaResposta p = new PerguntaResposta();

                p.setCodigo(rs.getInt("codigo"));
                p.setId_chat(rs.getInt("id_chat"));
                p.setPergunta(rs.getString("pergunta"));
                p.setResposta(rs.getString("resposta"));
                p.add(perguntaResposta);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoPerguntaResposta.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return perguntaResposta;

    }
    public List<PerguntaResposta> readForDesc(String desc) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<PerguntaResposta> perguntaResposta = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Pergunta_Resposta WHERE descricao LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

            	PerguntaResposta p = new PerguntaResposta();

            	p.setCodigo(rs.getInt("codigo"));
                p.setId_chat(rs.getInt("id_chat"));
                p.setPergunta(rs.getString("pergunta"));
                p.setResposta(rs.getString("resposta"));
                p.add(perguntaResposta);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoPerguntaResposta.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return perguntaResposta;

    }
	

}

*/

	private Connection con = null;
	
	public DaoPerguntaResposta(){
		
		con = ConnectionFactory.getConnection();
		
				
	}
	
	public boolean save(PerguntaResposta perguntaResposta) {
		
		String sql = "INSERT INTO PERGUNTA_RESPOSTA VALUES";
		
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, perguntaResposta.getPergunta());
			stmt.setString(1, perguntaResposta.getResposta());
			stmt.executeUpdate();
			return true;
			
		}catch(SQLException ex) {
			
			System.err.println("Erro:"+ex);
			
			return false;
			
		}finally {
			
			ConnectionFactory.closeConnection(con, stmt);
			
		}
		
	}
	
	public List<PerguntaResposta> findAll() {
		  
		String sql = "SELECT * FROM PERGUNTA_RESPOSTA ";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<PerguntaResposta> perguntaResposta = new ArrayList<>();
		
		
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				PerguntaResposta p  = new PerguntaResposta();
				
				p.setCodigo(rs.getInt("codigo"));
				p.setId_chat(rs.getInt("id_chat"));
				p.setPergunta(rs.getString("pergunta"));
				p.setResposta(rs.getString("resposta"));
				p.add(perguntaResposta);
			}
			
		}catch (SQLException ex) {
			
			System.err.println("Erro:"+ex);
		}finally {
			
			ConnectionFactory.closeConnection(con, stmt, rs);
			
		}
		
		return perguntaResposta;
		
		
	}
	

}





























