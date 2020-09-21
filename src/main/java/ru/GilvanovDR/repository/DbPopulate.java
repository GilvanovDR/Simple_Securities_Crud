package ru.GilvanovDR.repository;

import org.springframework.beans.factory.annotation.Autowired;
import ru.GilvanovDR.util.ObjectUtils;
import ru.GilvanovDR.util.XMLMapper;
import ru.GilvanovDR.util.exception.NotFoundException;

import javax.annotation.PostConstruct;

public class DbPopulate {
    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private SecuritiesRepository securitiesRepository;
    @Autowired
    private XMLMapper xmlMapper;

    public int securityURLToDb(String url) {
        return securitiesRepository
                .saveAll(ObjectUtils.getSecurities(xmlMapper.urlToSecurity(url)));
    }

    public int historyURLToDb(String url) {
        return historyRepository.saveAll(ObjectUtils.getHistory(xmlMapper.urlToHistory(url)));
    }

    @PostConstruct
    public void dataInit() {
        new Thread(() -> {
            try {
                Thread.sleep(100);
                /*securityURLToDb("http://localhost:8080/Simple_Securities_Crud/resources/xml/securities_1.xml");
                securityURLToDb("http://localhost:8080/Simple_Securities_Crud/resources/xml/securities_2.xml");
                historyURLToDb("http://localhost:8080/Simple_Securities_Crud/resources/xml/history_1.xml");
                historyURLToDb("http://localhost:8080/Simple_Securities_Crud/resources/xml/history_2.xml");
                historyURLToDb("http://localhost:8080/Simple_Securities_Crud/resources/xml/history_3.xml");
                historyURLToDb("http://localhost:8080/Simple_Securities_Crud/resources/xml/history_4.xml");*/
                securityURLToDb("https://simplesecuritiescrud.herokuapp.com/resources/xml/securities_1.xml");
                securityURLToDb("https://simplesecuritiescrud.herokuapp.com/resources/xml/securities_2.xml");
                historyURLToDb("https://simplesecuritiescrud.herokuapp.com/resources/xml/history_1.xml");
                historyURLToDb("https://simplesecuritiescrud.herokuapp.com/resources/xml/history_2.xml");
                historyURLToDb("https://simplesecuritiescrud.herokuapp.com/resources/xml/history_3.xml");
                historyURLToDb("https://simplesecuritiescrud.herokuapp.com/resources/xml/history_4.xml");
            } catch (InterruptedException v) {
                throw new NotFoundException("Error uploadData:" + v);
            }
        }).start();
    }
}
