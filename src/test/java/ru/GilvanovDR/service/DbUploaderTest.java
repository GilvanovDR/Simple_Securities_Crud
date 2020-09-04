package ru.GilvanovDR.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import ru.GilvanovDR.AbstractTest;
import ru.GilvanovDR.repository.HistoryRepository;
import ru.GilvanovDR.repository.SecuritiesRepository;
import ru.GilvanovDR.util.exception.NotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Sql(scripts = "classpath:db/clearDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class DbUploaderTest extends AbstractTest {
    @Autowired
    protected DbUploader dbUploader;
    @Autowired
    protected SecuritiesRepository securitiesRepository;
    @Autowired
    protected HistoryRepository historyRepository;

    @Test
    void uploadNewSecurities() {
        assertThat(dbUploader.secToDb(SECURITIES_PATH)).isEqualTo(10);
        assertThat(securitiesRepository.getAll().size()).isEqualTo(10);

    }

    @Test
    void uploadDoubleSecurities() {
        assertThat(dbUploader.secToDb(SECURITIES_PATH)).isEqualTo(10);
        assertThat(dbUploader.secToDb(SECURITIES_PATH)).isEqualTo(0);
    }

    @Test
    void uploadHistoryToEmptyDb() {
        assertThat(dbUploader.hisToDb(HISTORY_PATH)).isEqualTo(0);
    }

    @Test
    void uploadHistory() {
        uploadNewSecurities();
        assertThat(dbUploader.hisToDb(HISTORY_PATH)).isEqualTo(10);
    }

    @Test
    void uploadDoubleHistory() {
        uploadNewSecurities();
        assertThat(dbUploader.hisToDb(HISTORY_PATH)).isEqualTo(10);
        assertThat(dbUploader.hisToDb(HISTORY_PATH)).isEqualTo(0);
    }

    @Test
    void uploadEmptyFile() {
        assertThrows(NotFoundException.class, () -> dbUploader.secToDb(EMPTY_FILE_PATH));
        assertThrows(NotFoundException.class, () -> dbUploader.hisToDb(EMPTY_FILE_PATH));
    }

    @Test
    void uploadWrongPathFile() {
        assertThrows(NotFoundException.class, () -> dbUploader.secToDb(WRONG_FILE_PATH));
        assertThrows(NotFoundException.class, () -> dbUploader.hisToDb(WRONG_FILE_PATH));
    }

    //@Test //TODO after Fix saveAll
    void uploadWrongData() {
        assertThrows(NotFoundException.class, () -> dbUploader.secToDb(SECURITIES_WRONG_DATA_PATH));
        assertThrows(NotFoundException.class, () -> dbUploader.hisToDb(HISTORY_WRONG_DATA_PATH));
    }
}