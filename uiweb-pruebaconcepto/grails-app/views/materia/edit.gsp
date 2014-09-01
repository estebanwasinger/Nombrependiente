<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<title>Busqueda de materias</title>
</head>
<body>
	<div class="body" style="width: 90%; padding: 15pt;">
		<g:render template="menuSuperior"></g:render>
		
		<g:if test="${alta}">
			<g:set var="nombre" value="Crear materia"/>
		</g:if>
		<g:else>
			<g:set var="nombre" value="Actualizar materia"/>
		</g:else>
		<g:render template="nombre" model="['nombre': nombre]"/>
		<g:if test="${flash.message}">
			<div class="message">
				${flash.message}
			</div>
		</g:if>
		<g:if test="${exception}">
			<div class="alert alert-danger">
				${exception.message}
			</div>
		</g:if>
		<form class="form-horizontal" action="save" method="post">
			<g:hiddenField name="id" value="${materiaInstance?.id}" />
			<div class="row">
	  			<div class="col-md-6">
					<div class="control-group ${exception?.campoOrigen?.equalsIgnoreCase('profesor') ? 'danger' : ''}">
						<label class="control-label" for="profesor">Profesor</label>
						<div class="controls">
							<input class="form-control" type="text" name="profesor" id="profesor" placeholder="Profesor" value="${materiaInstance?.profesor}" />
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="control-group ${exception?.campoOrigen?.equalsIgnoreCase('nombre') ? 'danger' : ''}">
						<label class="control-label" for="nombre">Nombre</label>
						<div class="controls">
							<input class="form-control" type="text" name="nombre" id="nombre" placeholder="Nombre" value="${materiaInstance?.nombre}" />
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="control-group ${exception?.campoOrigen?.equalsIgnoreCase('ubicacion') ? 'danger' : ''}">
						<label class="control-label" for="ubicacion">Ubicacion</label>
						<div class="controls">
							<input class="form-control" type="text" name="ubicacion" id="ubicacion" placeholder="Ubicacion" value="${materiaInstance?.ubicacion}" />
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="control-group ${exception?.campoOrigen?.equalsIgnoreCase('anioCursada') ? 'danger' : ''}">
						<label class="control-label" for="anioCursada">Anio de Cursada</label>
						<div class="controls">
							<input class="form-control" type="text" name="anioCursada" id="anioCursada" placeholder="Anio de Cursada" value="${materiaInstance?.anioCursada}" />
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="control-group ${exception?.campoOrigen?.equalsIgnoreCase('finalAprobado') ? 'danger' : ''}">
						<label class="control-label" for="finalAprobado">Final Aprobado</label>
						<div class="controls">
							<input class="form-control" type="checkbox" name="finalAprobado" id="finalAprobado" placeholder="Final Aprobado" value="${materiaInstance?.finalAprobado}" />
						</div>
					</div>
				<div class="col-md-12">
					<div class="buttons">
						<br>
						<input type="submit" class="btn btn-primary" value="Aceptar" />
						<g:link class="btn btn-primary" action="list">
							Cancelar
						</g:link>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
