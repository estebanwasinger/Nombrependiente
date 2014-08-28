<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="main" />
</head>
<body>
	<div style="width: 90%; padding: 15pt;">
		<g:render template="nombre" model="['nombre': 'Seguidor de Carrera']"/>
		<g:if test="${flash.message}">
			<div class="alert alert-info">
				${flash.message}
			</div>
		</g:if>		
		<div class="panel-group" id="accordion1">
			<div class="panel panel-default">
				<div class="panel-heading">
					<a data-toggle="collapse"
						data-parent="#accordion1" href="#collapseOne">
						Par&aacute;metros de b&uacute;squeda
					</a>
				</div>
				<div id="collapseOne" class="panel-collapse collapse in">
					<div class="panel-body">
						<form>
							<div class="row">
  								<div class="col-md-6">
									<label>Nombre</label> 
									<input type="text" name="nombre" id="nombre" class="form-control" placeholder="Contiene..." value="${materiaBusqueda?.nombre}"> 
  								</div>
  								<div class="col-md-6">
									<label>Profesor</label> 
									<input type="text" class="form-control" name="profesor" id="profesor" placeholder="Contiene..." value="${materiaBusqueda?.profesor}">
  								</div>
  								<div class="col-md-12">
									<br />
									<button type="submit" class="btn btn-primary">
										<span class="glyphicon glyphicon-search"></span>
										Buscar
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<br>
			<div class="panel-group" id="accordion2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<a class="accordion-toggle" data-toggle="collapse"
							data-parent="#accordion2" href="#collapseTwo">Resultados: ${materiaInstanceTotal } 
						</a>
					</div>
					<div id="collapseTwo" class="panel-collapse collapse in">
						<div class="panel-body">
							<div id="list-libro" class="content scaffold-list">
								<table class="table table-striped table-bordered table-hover table-condensed">
									<thead>
										<g:sortableColumn property="nombre" title="nombre" />
										<g:sortableColumn property="profesor" title="Profesor"/>
										<g:sortableColumn property="ubicacion" title="Ubicaci&oacute;n"/>
										<g:sortableColumn property="anioCursada" title="A&ntilde;o de Cursada" />
									</thead>
									<tbody>
										<g:each in="${materiaInstanceList}" status="i"
											var="materiaInstance">
											<tr class="${(i % 2) == 0 ? 'info' : ''}">
												<td><g:link action="show" id="${materiaInstance.id}">
														${materiaInstance.profesor}
													</g:link></td>
												<td>
													${materiaInstance.nombre}
												</td>
												<td>
													${materiaInstance.ubicacion}
												</td>
												<td>
													${materiaInstance.anioCursada}
												</td>
											</tr>
										</g:each>
									</tbody>
								</table>
							</div>
						</div>
					</div>							
				</div>
			</div>
			<div class="panel-group" id="accordion3">
				<div class="panel panel-default">
					<div class="panel-heading">
						<a class="accordion-toggle" data-toggle="collapse"
							data-parent="#accordion3" href="#collapseThree">Acciones
						</a>
					</div>
					<div id="collapseThree" class="panel-collapse collapse in">
						<div class="panel-body">
							<g:link class="btn btn-primary" action="create">
								<span class="glyphicon glyphicon-file"></span>
								Crear Materia
							</g:link>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
