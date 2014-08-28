<!DOCTYPE html>
<html>
<head>
	<title>Seguidor de Carrera</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<asset:stylesheet href="application.css"/>
	<g:layoutHead/>
</head>
<body>
	<asset:javascript src="application.js"/>
	<div id="spinner" class="spinner" style="display: none;">
		<img src="${resource(dir:'images',file:'spinner.gif')}"
			alt="${message(code:'spinner.alt',default:'Loading...')}" />
	</div>
	<g:layoutBody />
</body>
</html>