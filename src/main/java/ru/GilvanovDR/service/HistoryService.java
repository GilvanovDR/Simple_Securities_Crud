package ru.GilvanovDR.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.GilvanovDR.model.HistoryElement;
import ru.GilvanovDR.repository.HistoryRepository;

import java.util.List;

import static ru.GilvanovDR.util.ValidationUtil.checkNotFoundWithId;

@Service
public class HistoryService {

    private final HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public HistoryElement create(HistoryElement historyElement, String secId) {
        Assert.notNull(historyElement, "history must not be null");
        return historyRepository.save(historyElement, secId);
    }

    public void delete(int id) {
        checkNotFoundWithId(historyRepository.delete(id), id);
    }

    public HistoryElement get(int id) {
        return checkNotFoundWithId(historyRepository.get(id), id);
    }

    public List<HistoryElement> getAll() {
        return historyRepository.getAll();
    }

    public void update(HistoryElement historyElement, String secId) {
        Assert.notNull(historyElement, "history must not be null");
        checkNotFoundWithId(historyRepository.save(historyElement, secId), historyElement.id());
    }
}
