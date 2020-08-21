package ru.GilvanovDR.repository.dataJpa;

import org.springframework.stereotype.Repository;
import ru.GilvanovDR.model.HistoryElement;
import ru.GilvanovDR.model.Security;
import ru.GilvanovDR.repository.HistoryRepository;

import java.util.List;

@Repository
public class HistoryRepositoryImpl implements HistoryRepository {
    private final CrudSecuritiesRepository securitiesRepository;
    private final CrudHistoryRepository historyRepository;

    public HistoryRepositoryImpl(CrudSecuritiesRepository securitiesRepository, CrudHistoryRepository historyRepository) {
        this.securitiesRepository = securitiesRepository;
        this.historyRepository = historyRepository;
    }

    @Override
    public List<HistoryElement> getAllBySecId(String secId) {
        return historyRepository.getAllBySecurityOrderByTradeDateDesc(secId);
    }

    @Override
    public List<HistoryElement> getAll() {
        return historyRepository.findAll();
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
        if (!historyElement.isNew() && get(historyElement.getId()) == null) {
            return null;
        }
        Security security = securitiesRepository.getBySecID(secId);
        //Add scheduler to pars from http://iss.moex.com/iss/securities.xml?q=SEARCH_STRING
        if (security == null) {
            return null;
        }
        historyElement.setSecurity(security);
        return historyRepository.save(historyElement);
    }
}
