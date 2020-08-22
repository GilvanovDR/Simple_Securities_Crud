package ru.GilvanovDR.repository;

import ru.GilvanovDR.model.HistoryElement;
import ru.GilvanovDR.model.Security;

import java.util.List;
import java.util.Map;


public interface HistoryRepository {

    List<HistoryElement> getAll();

    HistoryElement get(int id);

    boolean delete(int id);

    HistoryElement save(HistoryElement historyElement,String secId);

    int saveAll(Map<HistoryElement, String> history);
}
