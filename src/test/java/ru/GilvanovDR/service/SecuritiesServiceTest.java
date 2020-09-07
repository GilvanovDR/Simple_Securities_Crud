package ru.GilvanovDR.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import ru.GilvanovDR.AbstractTest;
import ru.GilvanovDR.model.Security;
import ru.GilvanovDR.util.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.GilvanovDR.SecurityTestData.*;


@Sql(scripts = "classpath:db/clearDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class SecuritiesServiceTest extends AbstractTest {
    @Autowired
    protected DbUploader dbUploader;
    @Autowired
    protected SecuritiesService securitiesService;

    @BeforeEach
    void initDb() {
        dbUploader.secToDb(SECURITIES_PATH);
    }

    @Test
    void create() {
        Security created = securitiesService.create(getNew());
        int newId = created.id();
        Security newSecurity = getNew();
        newSecurity.setId(newId);
        SECURITY_MATCHER.assertMatch(created, newSecurity);
        SECURITY_MATCHER.assertMatch(securitiesService.get(newId), newSecurity);
    }
    @Test
    void createNotValidName() {
        Security newSecurity = getNew();
        newSecurity.setName("not valid Name");
        assertThrows(NotFoundException.class, () -> securitiesService.create(newSecurity));
    }

    @Test
    void duplicateSecurityIdCreate() {
        assertThrows(NotFoundException.class, () ->
                securitiesService.create(new Security(SECURITY1.getSecID(), "Duplicate", "Duplicate", "Duplicate")));

    }

    @Test
    void delete() {
        securitiesService.delete(SECURITY1_ID);
        assertThrows(NotFoundException.class, () -> securitiesService.get(SECURITY1_ID));
    }

    @Test
    void deletedNotFound() {
        assertThrows(NotFoundException.class, () -> securitiesService.delete(NOT_FOUND));
    }

    @Test
    void get() {
        Security security = securitiesService.get(SECURITY1_ID);
        SECURITY_MATCHER.assertMatch(security, SECURITY1);
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () -> securitiesService.get(NOT_FOUND));
    }

    @Test
    void getAll() {
        SECURITY_MATCHER.assertMatch(securitiesService.getAll(), SECURITIES);
    }

    @Test
    void getBySecId() {
        SECURITY_MATCHER.assertMatch(securitiesService.getBySecId(SECURITY1.getSecID()), SECURITY1);
    }

    @Test
    void getByNotExistSecId() {
        assertThrows(NotFoundException.class, () -> securitiesService.getBySecId(NOT_EXIST_SECURITY_ID));
    }


    @Test
    void update() {
        Security updated = getUpdated();
        securitiesService.update(updated);
        SECURITY_MATCHER.assertMatch(securitiesService.get(SECURITY1_ID), getUpdated());
    }
}