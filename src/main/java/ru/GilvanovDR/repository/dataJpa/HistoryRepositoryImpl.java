package ru.GilvanovDR.repository.dataJpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.GilvanovDR.model.History;
import ru.GilvanovDR.model.Security;
import ru.GilvanovDR.repository.HistoryRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public class HistoryRepositoryImpl implements HistoryRepository {
    private final CrudSecuritiesRepository securitiesRepository;
    private final CrudHistoryRepository historyRepository;


    public HistoryRepositoryImpl(CrudSecuritiesRepository securitiesRepository, CrudHistoryRepository historyRepository) {
        this.securitiesRepository = securitiesRepository;
        this.historyRepository = historyRepository;
    }

    @Transactional
    @Override
    public List<History> getAll() {
       return getSortedAllBy(Sort.Direction.DESC,"tradeDate");
       //return historyRepository.getAll();
    }

    @Override
    public History get(int id) {
        return historyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(int id) {
        return historyRepository.delete(id) != 0;
    }

    @Override
    public History save(History history, String secId) {

        Security security = securitiesRepository.getBySecID(secId);
        //Add scheduler to pars from http://iss.moex.com/iss/securities.xml?q=SEARCH_STRING
        if (security == null) {
            return null;
        }
        history.setSecurity(security);
        if (history.isNew() && isExist(history)) {
            return null;
        }
        history.setSecurity(security);
        return historyRepository.save(history);
    }

    private boolean isExist(History history) {
        Assert.notNull(history, "history must not be null");
        int secId = history.getSecurity().getId();
        LocalDate tradeDate = history.getTradeDate();
        Integer numTrades = history.getNumTrades();

        return historyRepository.getExist(secId, tradeDate, numTrades).size() > 0;
    }

    @Override
    public int saveAll(Map<History, String> history) {
        int count = 0;
        for (Map.Entry<History, String> entry : history.entrySet()) {
            count += save(entry.getKey(), entry.getValue()) != null ? 1 : 0;
        }
        return count;
    }
    public List<History> getSortedAllBy(Sort.Direction direction,String field) {
        return historyRepository.findAll(Sort.by(direction, field));
    }

    @Override
    public List<History> getFilteredBy(String emitentTitle, LocalDate tradeDate) {
        return historyRepository.getFilteredBy(emitentTitle,tradeDate);
    }
}
