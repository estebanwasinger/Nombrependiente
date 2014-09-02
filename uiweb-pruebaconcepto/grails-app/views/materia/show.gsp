<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<title>Ver materia</title>
</head>
<body>
<g:render template="menuSuperior"/>
	<div class="body" style="width: 90%; padding: 15pt;">
		
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
					${materiaInstance?.profesor}
				</div>
				<div class="col-md-6">
					<label class="control-label" for="titulo">Nombre&nbsp;&nbsp; </label>
					${materiaInstance?.nombre}
				</div>
				<div class="col-md-6">	
					<label class="control-label" for="editorial">Ubicacion&nbsp;&nbsp; </label> 
					${materiaInstance?.ubicacion}
				</div>
				<div class="col-md-6">
					<label class="control-label" for="editorial">Anio de Cursada&nbsp;&nbsp; </label>
					${materiaInstance?.anioCursada}
				</div>
				<div class="col-md-6">	
					<label class="control-label" for="editorial">Final Aprobado&nbsp;&nbsp; </label> 
					${(materiaInstance.finalAprobado == true) ? 'Si':'No'}
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
				<g:actionSubmit class="btn btn-danger" action="delete" value="Eliminar"/>
				<g:link class="btn btn-warning" action="list" value="Cancelar">
					Cancelar
				</g:link>
			</div>
		</g:form>
	</div>
</body>
</html>
