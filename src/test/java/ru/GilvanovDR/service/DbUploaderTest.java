package ru.GilvanovDR.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.GilvanovDR.AbstractTest;
import ru.GilvanovDR.repository.SecuritiesRepository;
import ru.GilvanovDR.util.XMLMapper;

class DbUploaderTest extends AbstractTest {
    @Autowired
    protected XMLMapper xmlMapper;
    @Autowired
    protected SecuritiesRepository securitiesRepository;
    @Test
    void uploadSecurities() {

    }
}