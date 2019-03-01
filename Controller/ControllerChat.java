package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.dao.DaoChat;
import Model.entidade.Chat;


@WebServlet("/ControllerChat")
public class ControllerChat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ControllerChat() {
        super();
    
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String botao = request.getParameter("botao");
		
		if (botao.equals("chat")) {
			
			String nome       = request.getParameter("nome");
			String id    = request.getParameter("id");
			String data_hora  = request.getParameter("data_hora");

			
			Chat c = new Chat();
			c.setNome(nome);
			c.setId(Long.parseLong(id));
			c.setData_hora(data_hora);

			
			DaoChat dao = new DaoChat();
			if (dao.insere(c)) {
				response.sendRedirect("sucesso.jsp");
			} else {
				response.sendRedirect("erro.jsp");
			}
		}
	}

}
