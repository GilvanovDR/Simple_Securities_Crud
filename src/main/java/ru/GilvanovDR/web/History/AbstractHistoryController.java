package ru.GilvanovDR.web.History;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.GilvanovDR.model.History;
import ru.GilvanovDR.service.HistoryService;

import java.util.List;

import static ru.GilvanovDR.util.ValidationUtil.checkNew;

public abstract class AbstractHistoryController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private HistoryService historyService;

    public List<History> getAll() {
        log.info("getAll");
        return historyService.getAll();
    }

    public History get(int id) {
        log.info("get {}", id);
        return historyService.get(id);
    }

    public History create(History history, String secId) {
        log.info("create {}", history);
        checkNew(history);
        return historyService.create(history, secId);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        historyService.delete(id);
    }

    public void update(History history, String secId) {
        log.info("update {}", history);
        historyService.update(history, secId);
    }
}
