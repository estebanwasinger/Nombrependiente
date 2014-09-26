package futbol5.auxUtils

import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Observable

@Observable
class ModeloBusquedaHyP extends Entity {
	@Property int handicapDesde
	@Property int handicapHasta
	@Property int promedioDesde
	@Property int promedioHasta
	
	
new(){
	handicapDesde = 0
	handicapHasta = 10
	promedioDesde = 0
	promedioHasta = 10
}
	
}