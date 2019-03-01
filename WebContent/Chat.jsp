<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="Geral.css">
</head>
<body>

<a href="Inicio.html"><img id="imgLogo" src="Imagem/logo.png"  width="312" height="197"></a>


<ul class="nav nav-pills nav-fill">
  <li class="nav-item">
    <a class="nav-link active" href="Inicio.html">Inicio</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="Sobre.html">Sobre nos</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" class="ion-icon-save"  href="Artigos.html">Artigos</a>
  </li>
 
</ul>

<h2 class="titulochat">Assunto Abordado: Depressão</h2>



<form action="ControllerPerguntaResposta" method="post">
<div id="chat"> 



	<div id="PR"  >
	
		<p> <%= p.getPergunta() %> </p>	
		<p name="resposta" id="resposta"></p>
	</div>
	
		<div id="PR">
	
		<p name="pergunta" id="pergunta" ></p>	
	
		<p name="resposta" id="resposta">getResposta</p>
	</div>
	
		<div id="PR">
	
		<p name="pergunta" id="pergunta"></p>	
		<p name="resposta" id="resposta"></p>
	</div>



		</div>

	<div id="divEnviar">
    <input type="text" id="txtEnviar" placeholder="Digite..."/>
    <input type="submit" name="botao" id="btnEnviar" value="inserir"/>
    </div>
		
		
		
	
	</form>





</body>
</html>