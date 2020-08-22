package ru.GilvanovDR.util;

import ru.GilvanovDR.model.HistoryElement;
import ru.GilvanovDR.model.Security;
import ru.GilvanovDR.model.jaxb.XmlHistory;
import ru.GilvanovDR.model.jaxb.XmlSecurity;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ObjectUtils {
    public static Security createSecurity(XmlSecurity xmlSecurity) {
        return new Security(xmlSecurity);
    }

    public static HistoryElement createHistory(XmlHistory xmlHistory) {
        return new HistoryElement(xmlHistory);
    }

    public static List<Security> getSecurities(List<XmlSecurity> xmlSecurities) {
        return xmlSecurities.stream()
                .map(ObjectUtils::createSecurity)
                .collect(Collectors.toList());
    }
    public static Map<HistoryElement,String> getHistory(List<XmlHistory> xmlHistories) {
        return xmlHistories.stream().collect(Collectors.toMap(ObjectUtils::createHistory
                , XmlHistory::getSecId));
    }
}
