package ru.GilvanovDR.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import ru.GilvanovDR.AbstractTest;
import ru.GilvanovDR.model.History;
import ru.GilvanovDR.model.Security;
import ru.GilvanovDR.util.exception.NotFoundException;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.GilvanovDR.HistoryTestData.*;
import static ru.GilvanovDR.TestData.HISTORY_PATH;
import static ru.GilvanovDR.TestData.SECURITIES_PATH;

@Sql(scripts = "classpath:db/clearDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class HistoryServiceTest extends AbstractTest {
    @Autowired
    protected DbUploader dbUploader;
    @Autowired
    protected HistoryService historyService;

    @BeforeEach
    void initDb() {
        dbUploader.secToDb(SECURITIES_PATH);
        dbUploader.hisToDb(HISTORY_PATH);
    }

    @Test
    void getAll() {
        HISTORY_MATCHER.assertMatch(historyService.getAll(), HISTORY);
    }

    @Test
    void create() {
        History created = historyService.create(getNew(), HISTORY1_SEC_ID);
        int newId = created.id();
        History newHistory = getNew();
        newHistory.setId(newId);
        HISTORY_MATCHER.assertMatch(created, newHistory);
        HISTORY_MATCHER.assertMatch(historyService.get(newId), newHistory);
    }

    @Test
    void NotExistSecIdCreate() {
        assertThrows(NotFoundException.class, () -> historyService.create(getNew(), NOT_EXIST_SECURITY_ID));
    }

    @Test
    void duplicateHistoryCreate() {
        assertThrows(NotFoundException.class, () -> historyService.create(getDuplicate(), HISTORY1_SEC_ID));
    }

    @Test
    void delete() {
        historyService.delete(HISTORY1_ID);
        assertThrows(NotFoundException.class, () -> historyService.get(HISTORY1_ID));
    }
    @Test
    void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> historyService.delete(NOT_FOUND));
    }

    @Test
    void get() {
        History history = historyService.get(HISTORY1_ID);
        HISTORY_MATCHER.assertMatch(history, HISTORY1);
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () -> historyService.get(NOT_FOUND));
    }
    @Test
    void update() {
        History history = getUpdated();
        historyService.update(history,HISTORY1_SEC_ID);
        HISTORY_MATCHER.assertMatch(historyService.get(HISTORY1_ID), history);
    }
}