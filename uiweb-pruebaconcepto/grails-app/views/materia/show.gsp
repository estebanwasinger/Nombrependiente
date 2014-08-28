<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<title>Ver materia</title>
</head>
<body>
	<div class="body" style="width: 90%; padding: 15pt;">
		<g:render template="menuSuperior"/>
		<g:render template="nombre" model="['nombre': 'Ver materia']"/>
		<g:if test="${flash.message}">
			<div class="message">
				${flash.message}
			</div>
		</g:if>
		<g:form class="form-horizontal" method="post">
			<div class="row">
				<div class="col-md-6">
					<label class="control-label" for="profesor">Profesor&nbsp;&nbsp; </label> 
					<input class="readOnly form-control" type="text" value="${materiaInstance?.profesor}"/>
				</div>
				<div class="col-md-6">
					<label class="control-label" for="titulo">Nombre&nbsp;&nbsp; </label>
					<input class="readOnly form-control" type="text" value="${materiaInstance?.nombre}"/>
				</div>
				<div class="col-md-6">	
					<label class="control-label" for="editorial">Ubicacion&nbsp;&nbsp; </label> 
					<input class="readOnly form-control" type="text" value="${materiaInstance?.ubicacion}"/>
				</div>
				<div class="col-md-6">
					<label class="control-label" for="editorial">Anio de Cursada&nbsp;&nbsp; </label>
					<input class="readOnly form-control" type="text" value="${materiaInstance?.anioCursada}"/> 
				</div>
			</div>
			<div class="buttons">
				<br>
				<g:hiddenField name="id" value="${materiaInstance?.id}" />
				<g:actionSubmit class="btn btn-primary" action="edit" value="Editar"/>
				<!--  se pueden poner botones con íconos como éste
				<button class="btn btn-primary" name="_action_edit" value="Editar">
					<i class="icon-file icon-white"></i>Editar
				</button>
				 -->
				<g:actionSubmit class="btn btn-primary" action="delete" value="Eliminar"/>
				<g:link class="btn btn-primary" action="list">
					Cancelar
				</g:link>
			</div>
		</g:form>
	</div>
</body>
</html>
