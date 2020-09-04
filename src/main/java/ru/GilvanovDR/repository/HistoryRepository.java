package ru.GilvanovDR.repository;

import org.springframework.data.domain.Sort;
import ru.GilvanovDR.model.History;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public interface HistoryRepository {

    List<History> getAll();

    History get(int id);

    boolean delete(int id);

    History save(History history, String secId);

    int saveAll(Map<History, String> history);

    List<History> getSortedAllBy(Sort.Direction direction, String field);

    List<History> getFilteredBy(String emitentTitle, LocalDate tradeDate);
}
