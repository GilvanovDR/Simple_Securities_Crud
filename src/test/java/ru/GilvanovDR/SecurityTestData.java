package ru.GilvanovDR;

import ru.GilvanovDR.model.Security;

import java.util.List;

import static ru.GilvanovDR.model.AbstractBaseEntity.START_SEQ;

public class SecurityTestData {
    public static final int NOT_FOUND = 10;
    public static final int SECURITY1_ID = START_SEQ;
    public static final String NOT_EXIST_SECURITY_ID = "notExist";
    public static final Security SECURITY1 = new Security("AAPL", "", "Apple Inc.", "Apple Inc", SECURITY1_ID);
    public static final Security SECURITY2 = new Security("ABRD", "1-02-12500-A", "Абрау-Дюрсо ПАО ао", "Публичное акционерное общество \"Абрау – Дюрсо\"", SECURITY1_ID + 1);
    public static final Security SECURITY3 = new Security("ACKO", "1-01-52065-Z", "АСКО-СТРАХОВАНИЕ ПАО ао", "Публичное акционерное общество \"АСКО-СТРАХОВАНИЕ\"", SECURITY1_ID + 2);
    public static final Security SECURITY4 = new Security("AFKS", "1-05-01669-A", "АФК \"Система\" ПАО ао", "ПУБЛИЧНОЕ АКЦИОНЕРНОЕ ОБЩЕСТВО \"АКЦИОНЕРНАЯ ФИНАНСОВАЯ КОРПОРАЦИЯ \"СИСТЕМА\"", SECURITY1_ID + 4);
    public static final Security SECURITY5 = new Security("AFLT", "1-01-00010-A", "Аэрофлот-росс.авиалин(ПАО)ао", "Публичное акционерное общество \"Аэрофлот – российские авиалинии\"", SECURITY1_ID + 5);
    public static final Security SECURITY6 = new Security("AFM0", "", "Фьючерсный контракт AFLT-6.20", "Публичное акционерное общество \"Аэрофлот – российские авиалинии\"", SECURITY1_ID + 6);
    public static final Security SECURITY7 = new Security("AFU0", "", "Фьючерсный контракт AFLT-9.20", "Публичное акционерное общество \"Аэрофлот – российские авиалинии\"", SECURITY1_ID + 8);
    public static final Security SECURITY8 = new Security("AGRO", "", "ГДР ROS AGRO PLC ORD SHS", "Bank of New York Mellon Corporation (Глобальные депозитарные расписки на акции ROS AGRO PLC)", SECURITY1_ID + 9);
    public static final Security SECURITY9 = new Security("acru", "1-03-01692-A", "Открытое акционерное общество \"Авиационная корпорация \"Рубин\"", "публичное акционерное общество \"Авиационная корпорация \"Рубин\"", SECURITY1_ID + 3);
    public static final Security SECURITY10 = new Security("afmc", "1-01-40534-A", "Акционерное общество \"Агрофирма Мценская\"", "Акционерное общество \"Агрофирма Мценская\"", SECURITY1_ID + 7);
    public static final List<Security> SECURITIES = List.of(SECURITY1
            , SECURITY2, SECURITY3, SECURITY4, SECURITY5, SECURITY6
            , SECURITY7, SECURITY8, SECURITY9, SECURITY10);
    public static TestMatcher<Security> SECURITY_MATCHER = TestMatcher.usingFieldsWithIgnoringComparator(Security.class);

    public static Security getNew() {
        return new Security("AAA", "", "NEW NAME", "NEW EMITENT TITLE");
    }

    public static Security getUpdated() {
        return new Security("UPDATED", "UPDATED", "UPDATED", "UPDATED", SECURITY1_ID);
    }
}
