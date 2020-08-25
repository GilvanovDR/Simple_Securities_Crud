package ru.GilvanovDR.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.GilvanovDR.TimingExtension;
import ru.GilvanovDR.model.jaxb.XmlHistory;
import ru.GilvanovDR.model.jaxb.XmlSecurity;
import ru.GilvanovDR.util.exception.NotFoundException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@ExtendWith(TimingExtension.class)
class XMLMapperTest {
    @Autowired
    protected XMLMapper mapper;

    @Test
    void uploadSecurity() {
        List<XmlSecurity> securities = mapper.XmlToSecurity("XML/Test/securities_1.xml");
        assertThat(securities.size()).isEqualTo(10);
        assertThat(securities.get(0)).isEqualTo(new XmlSecurity("AAPL", "", "Apple Inc.", "Apple Inc"));
    }

    @Test
    void uploadHistory() {
        List<XmlHistory> history = mapper.XmlToHistory("XML/Test/history_1.xml");
        assertThat(10).isEqualTo(history.size());
        assertThat(history.get(0)).isEqualTo(new XmlHistory("ABRD", "2020-04-15", "171", "135.5", "134.5"));
    }

    @Test
    void uploadEmptyFile() {
        assertThrows(NotFoundException.class, () -> mapper.XmlToSecurity("XML/Test/empty.xml"));
        assertThrows(NotFoundException.class, () -> mapper.XmlToHistory("XML/Test/empty.xml"));
    }

    @Test
    void uploadWrongPathFile() {
        assertThrows(NotFoundException.class, () -> mapper.XmlToSecurity(""));
        assertThrows(NotFoundException.class, () -> mapper.XmlToHistory(""));
    }
}