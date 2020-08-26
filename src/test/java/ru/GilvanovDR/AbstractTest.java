package ru.GilvanovDR;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@ExtendWith(TimingExtension.class)
public abstract class AbstractTest {
    public static final String SECURITIES_PATH = "XML/Test/securities_1.xml";
    public static final String HISTORY_PATH = "XML/Test/history_1.xml";
    public static final String EMPTY_FILE_PATH = "XML/Test/empty.xml";
    public static final String WRONG_FILE_PATH = "XML/Test/wrong";
    public static final String SECURITIES_WRONG_DATA_PATH = "XML/Test/securities_wrong_data.xml";
    public static final String HISTORY_WRONG_DATA_PATH = "XML/Test/history_wrong_data.xml";
}
