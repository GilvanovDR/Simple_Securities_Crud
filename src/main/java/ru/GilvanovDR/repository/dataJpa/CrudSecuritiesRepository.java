package ru.GilvanovDR.repository.dataJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.GilvanovDR.model.Security;

@Transactional(readOnly = true)
public interface CrudSecuritiesRepository extends JpaRepository<Security, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Security s WHERE s.id=:id")
    int delete(@Param("id") int id);

    Security getBySecID(String secId);
}
