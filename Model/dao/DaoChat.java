package Model.dao;

import Model.entidade.Chat;
import Model.sgbd.Oracle;

public class DaoChat {
	
	public boolean insere(Chat chat) {
		boolean retorno = false;
		Oracle o = new Oracle();
		if (o.carregaDriver() && o.conecta() && o.comando()) {
			
			String sql = " INSERT INTO chat VALUES (" 
					+ chat.getId() +
					",'"  + chat.getNome() + 
					"',"  + chat.getData_hora() +
					")";
			
			if (o.insere(sql)) {
				retorno = true;
				o.disconecta();
			}
		}
		return retorno;
	}

}
