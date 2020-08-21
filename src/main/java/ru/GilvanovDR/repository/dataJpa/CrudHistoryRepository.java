package ru.GilvanovDR.repository.dataJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.GilvanovDR.model.HistoryElement;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudHistoryRepository extends JpaRepository<HistoryElement,Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM HistoryElement e WHERE e.id=:id")
    int delete(@Param("id") int id);

    List<HistoryElement> getAllBySecurityOrderByTradeDateDesc(String secId);
}