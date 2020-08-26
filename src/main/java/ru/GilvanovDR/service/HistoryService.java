package ru.GilvanovDR.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.GilvanovDR.model.History;
import ru.GilvanovDR.repository.HistoryRepository;

import java.util.List;

import static ru.GilvanovDR.util.ValidationUtil.checkNotFoundWithId;

@Service
public class HistoryService {

    private final HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public History create(History history, String secId) {
        Assert.notNull(history, "history must not be null");
        return historyRepository.save(history, secId);
    }

    public void delete(int id) {
        checkNotFoundWithId(historyRepository.delete(id), id);
    }

    public History get(int id) {
        return checkNotFoundWithId(historyRepository.get(id), id);
    }

    public List<History> getAll() {
        return historyRepository.getAll();
    }

    public void update(History history, String secId) {
        Assert.notNull(history, "history must not be null");
        checkNotFoundWithId(historyRepository.save(history, secId), history.id());
    }
}
