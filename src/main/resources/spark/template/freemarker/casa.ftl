<!DOCTYPE html>
<head>
	<head> 
	<meta charset="TUF-8">
	<title>${title}</title>
	</head>
	<body>
	
	 <#if user??>
	<h1>Contenido ${user.getNombre()} ${user.getApellido()}</h1>
	 
	 Hola Usuario
	 <#else>
	 <h3>El usuario no existe</h3>
	 </#if>


	</body>

</html>