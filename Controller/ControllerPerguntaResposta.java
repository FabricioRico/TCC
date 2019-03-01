package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.dao.DaoPerguntaResposta;
import Model.entidade.PerguntaResposta;


@WebServlet("/ControllerPerguntaResposta")
public class ControllerPerguntaResposta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ControllerPerguntaResposta() {
        super();
     
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String botao = request.getParameter("botao");
		
		if (botao.equals("consulta")) {
			String codigo       = request.getParameter("codigo");
			String id_chat       = request.getParameter("id_chat");
			String pergunta    = request.getParameter("pergunta");
			String resposta  = request.getParameter("resposta");

			
			PerguntaResposta p = new PerguntaResposta();
			p.setCodigo(Integer.parseInt(codigo));
			p.setId_chat(Integer.parseInt(id_chat));
			p.setPergunta(pergunta);
			p.setResposta(resposta);
			
			
			DaoPerguntaResposta dao = new DaoPerguntaResposta();
			if (dao.consulta(p)) {
				response.sendRedirect("Artigos.html");
			} else {
				response.sendRedirect("erro.html");
			}
		}
	}

}
