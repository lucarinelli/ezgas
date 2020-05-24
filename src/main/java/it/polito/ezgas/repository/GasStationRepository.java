package it.polito.ezgas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.polito.ezgas.entity.GasStation;

@Repository
public interface GasStationRepository extends JpaRepository<GasStation, Integer> {
    
    List<GasStation> findByCarSharing(String carSharing);

	List<GasStation> findByHasDieselOrderByDieselPriceAsc();

	List<GasStation> findByHasMethaneOrderByMethanePriceAsc();

	List<GasStation> findByHasGasOrderByGasPriceAsc();

	List<GasStation> findByHasSuperPriceOrderBySuperPriceAsc();

	List<GasStation> findByHasSuperPlusPriceOrderBySuplerPlusPriceAsc();
}
