
<div class="navbar navbar-default navbar-static-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<g:link class="navbar-brand" action="index"> Seguidor de Carrera </g:link>
		</div>

		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><g:link class="" action="index"> Home</g:link></li>
				<li><g:link class="" action="create"> Crear Materia </g:link></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" name="nombre" id="nombre" class="form-control"  placeholder="Contiene..." value="${materiaBusqueda?.nombre}">
						
					</div>
					<button type="submit" formaction="http://localhost:8080/uiweb-pruebaconcepto/materia/" class="btn btn-default"><span class="glyphicon glyphicon-search"></span> Buscar Materia</button>
				</form>
			</ul>

		</div>
		<!--/.nav-collapse -->
	</div>
</div>