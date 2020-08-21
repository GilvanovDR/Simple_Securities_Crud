package ru.GilvanovDR.util;

import ru.GilvanovDR.model.Security;
import ru.GilvanovDR.model.jaxb.XmlSecurity;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ObjectUtils {
    public static Security createSecurity(XmlSecurity xmlSecurity) {
        return new Security(xmlSecurity);
    }

    public static List<Security> getSecurities(List<XmlSecurity> xmlSecurities) {
        return xmlSecurities.stream()
                .map(ObjectUtils::createSecurity)
                .collect(Collectors.toList());
    }

}
