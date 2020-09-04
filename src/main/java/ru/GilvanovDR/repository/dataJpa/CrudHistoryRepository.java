package ru.GilvanovDR.repository.dataJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.GilvanovDR.model.History;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudHistoryRepository extends JpaRepository<History, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM History e WHERE e.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT e FROM History e WHERE e.security.id=:secId and e.tradeDate=:tradeDate and e.numTrades=:numTrades")
    List<History> getExist(@Param("secId") int secId, @Param("tradeDate") LocalDate tradeDate, @Param("numTrades") Integer numTrades);

    @Query("SELECT e FROM History e WHERE e.security.emitentTitle=:emitentTitle or e.tradeDate =:tradeDate")
    List<History> getFilteredBy(@Param("emitentTitle") String emitentTitle, @Param("tradeDate") LocalDate tradeDate);
}
