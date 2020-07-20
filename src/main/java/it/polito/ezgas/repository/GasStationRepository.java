package it.polito.ezgas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.polito.ezgas.entity.GasStation;

@Repository
public interface GasStationRepository extends JpaRepository<GasStation, Integer> {
    
    List<GasStation> findByCarSharing(String carSharing);

	List<GasStation> findByHasDieselOrderByDieselPriceAsc(boolean hasDiesel);

	List<GasStation> findByHasMethaneOrderByMethanePriceAsc(boolean hasMethane);

	List<GasStation> findByHasGasOrderByGasPriceAsc(boolean hasGas);

	List<GasStation> findByHasSuperOrderBySuperPriceAsc(boolean hasSuper);

	List<GasStation> findByHasSuperPlusOrderBySuperPlusPriceAsc(boolean hasSuperPlus);
	
	List<GasStation> findByHasPremiumDieselOrderByPremiumDieselPriceAsc(boolean hasPremiumDiesel);
}
