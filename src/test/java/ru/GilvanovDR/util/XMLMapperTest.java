package ru.GilvanovDR.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.GilvanovDR.AbstractTest;
import ru.GilvanovDR.model.jaxb.XmlHistory;
import ru.GilvanovDR.model.jaxb.XmlSecurity;
import ru.GilvanovDR.util.exception.NotFoundException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class XMLMapperTest extends AbstractTest {
    @Autowired
    protected XMLMapper mapper;


    @Test
    void uploadSecurity() {
        List<XmlSecurity> securities = mapper.fileToSecurity(SECURITIES_PATH);
        assertThat(securities.size()).isEqualTo(10);
        assertThat(securities.get(0)).isEqualTo(new XmlSecurity("AAPL", "", "Apple Inc.", "Apple Inc"));
    }

    @Test
    void uploadHistory() {
        List<XmlHistory> history = mapper.fileToHistory(HISTORY_PATH);
        assertThat(10).isEqualTo(history.size());
        assertThat(history.get(0)).isEqualTo(new XmlHistory("AAPL", "2020-04-15", "171", "135.5", "134.5"));
    }

    @Test
    void uploadEmptyFile() {
        assertThrows(NotFoundException.class, () -> mapper.fileToSecurity(EMPTY_FILE_PATH));
        assertThrows(NotFoundException.class, () -> mapper.fileToHistory(EMPTY_FILE_PATH));
    }

    @Test
    void uploadWrongPathFile() {
        assertThrows(NotFoundException.class, () -> mapper.fileToSecurity(WRONG_FILE_PATH));
        assertThrows(NotFoundException.class, () -> mapper.fileToHistory(WRONG_FILE_PATH));
    }
}