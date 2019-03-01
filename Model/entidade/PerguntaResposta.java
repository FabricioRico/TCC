package Model.entidade;

import java.util.List;

public class PerguntaResposta {
	
	private int codigo;
	private int id_chat;
	private String pergunta;
	private String resposta;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getId_chat() {
		return id_chat;
	}
	public void setId_chat(int id_chat) {
		this.id_chat = id_chat;
	}
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public void add(List<PerguntaResposta> perguntaResposta) {
		// TODO Auto-generated method stub
		
	}
	
	


}


