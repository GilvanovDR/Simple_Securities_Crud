package ru.GilvanovDR.repository;

import ru.GilvanovDR.model.HistoryElement;

import java.util.List;


public interface HistoryRepository {
    List<HistoryElement> getAllBySecId(String secId);

    List<HistoryElement> getAll();

    HistoryElement get(int id);

    boolean delete(int id);

    HistoryElement save(HistoryElement historyElement,String secId);

}
