package ru.GilvanovDR.repository;

import ru.GilvanovDR.model.History;

import java.util.List;
import java.util.Map;


public interface HistoryRepository {

    List<History> getAll();

    History get(int id);

    boolean delete(int id);

    History save(History history, String secId);

    int saveAll(Map<History, String> history);
}
