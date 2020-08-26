package ru.GilvanovDR;

import ru.GilvanovDR.model.History;

import java.time.LocalDate;
import java.util.List;

import static ru.GilvanovDR.SecurityTestData.SECURITY1;
import static ru.GilvanovDR.model.AbstractBaseEntity.START_SEQ;

public class HistoryTestData {
    public static final int NOT_FOUND = 10;
    public static final int HISTORY1_ID = START_SEQ + 10;
    public static final String NOT_EXIST_SECURITY_ID = "notExist";
    public static final String HISTORY1_SEC_ID = "AAPL";
    public static final History HISTORY1 = new History(null, LocalDate.parse("2020-04-15"), 171, 135.5, 134.5, HISTORY1_ID);
    public static final History HISTORY2 = new History(null, LocalDate.parse("2020-04-15"), 148, 4.04, 4.02, HISTORY1_ID + 1);
    public static final History HISTORY3 = new History(null, LocalDate.parse("2020-04-15"), 3, 14.441, 13.776, HISTORY1_ID + 2);
    public static final History HISTORY4 = new History(null, LocalDate.parse("2020-04-15"), 26972, 13.782, 13.17, HISTORY1_ID + 3);
    public static final History HISTORY5 = new History(null, LocalDate.parse("2020-04-15"), 9, 77.36, 71.02, HISTORY1_ID + 4);
    public static final History HISTORY6 = new History(null, LocalDate.parse("2020-04-15"), 0, null, null, HISTORY1_ID + 5);
    public static final History HISTORY7 = new History(null, LocalDate.parse("2020-04-15"), 58827, 75.04, 72.1, HISTORY1_ID + 6);
    public static final History HISTORY8 = new History(null, LocalDate.parse("2020-04-15"), 5852, 625.6, 613.2, HISTORY1_ID + 7);
    public static final History HISTORY9 = new History(null, LocalDate.parse("2020-04-15"), 71, 9.02, 8.73, HISTORY1_ID + 8);
    public static final History HISTORY10 = new History(null, LocalDate.parse("2020-04-15"), 403, 12.58, 12.5, HISTORY1_ID + 9);
    public static final List<History> HISTORY = List.of(HISTORY1
            , HISTORY2, HISTORY3, HISTORY4, HISTORY5, HISTORY6
            , HISTORY7, HISTORY8, HISTORY9, HISTORY10);
    public static TestMatcher<History> HISTORY_MATCHER = TestMatcher.usingFieldsWithIgnoringComparator(History.class, "security");

    public static History getNew() {
        return new History(SECURITY1, LocalDate.now(), 100, 100.0, 100.0);
    }

    public static History getDuplicate() {
        return new History(SECURITY1, HISTORY1.getTradeDate(), HISTORY1.getNumTrades(), null, null);
    }

    public static History getUpdated() {
        return new History(SECURITY1, LocalDate.now(), 0, 0.0, 0.0, HISTORY1_ID);
    }
}
