package ru.GilvanovDR.repository.dataJpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.GilvanovDR.model.HistoryElement;
import ru.GilvanovDR.model.Security;
import ru.GilvanovDR.repository.HistoryRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    public List<HistoryElement> getAll() {
        return historyRepository.getAll();
    }

    @Override
    public HistoryElement get(int id) {
        return historyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(int id) {
        return historyRepository.delete(id) != 0;
    }

    @Override
    public HistoryElement save(HistoryElement historyElement, String secId) {

        Security security = securitiesRepository.getBySecID(secId);
        //Add scheduler to pars from http://iss.moex.com/iss/securities.xml?q=SEARCH_STRING
        if (security == null) {
            return null;
        }
        historyElement.setSecurity(security);
        if (historyElement.isNew() && isExist(historyElement)) {
            return null;
        }
        historyElement.setSecurity(security);
        return historyRepository.save(historyElement);
    }

    private boolean isExist(HistoryElement historyElement) {
        int secId = /*Objects.requireNonNull(*/historyElement.getSecurity().getId();
        LocalDate tradeDate = historyElement.getTradeDate();
        Double numTrades = historyElement.getNumTrades();
        return historyRepository.getExist(secId, tradeDate, numTrades).size() > 0;
    }

    @Override
    public int saveAll(Map<HistoryElement, String> history) {
        int count = 0;
        for (Map.Entry<HistoryElement, String> entry : history.entrySet()) {
            count += save(entry.getKey(), entry.getValue()) == null ? 1 : 0;
        }
        return count;
    }
}
