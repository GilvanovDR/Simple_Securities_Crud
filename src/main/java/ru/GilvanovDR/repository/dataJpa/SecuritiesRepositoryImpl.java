package ru.GilvanovDR.repository.dataJpa;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.GilvanovDR.model.Security;
import ru.GilvanovDR.repository.SecuritiesRepository;

import java.util.Iterator;
import java.util.List;

@Repository
public class SecuritiesRepositoryImpl implements SecuritiesRepository {
    private static final Sort SORT_SEC_ID = Sort.by(Sort.Direction.ASC, "secID");
    private final CrudSecuritiesRepository securitiesRepository;

    public SecuritiesRepositoryImpl(CrudSecuritiesRepository securitiesRepository) {
        this.securitiesRepository = securitiesRepository;
    }

    @Override
    public Security getBySecID(String secId) {
        return securitiesRepository.getBySecID(secId);
    }

    @Override
    public List<Security> getAll() {
        return securitiesRepository.findAll(SORT_SEC_ID);
    }

    @Override
    public Security get(int securityId) {
        return securitiesRepository.findById(securityId).orElse(null);
    }

    @Override
    public boolean delete(int securityId) {
        return securitiesRepository.delete(securityId)!=0;
    }

    @Transactional
    @Override
    public Security save(Security security) {
        if (securitiesRepository.getBySecID(security.getSecID()) != null) {
            return null;
        }
        return securitiesRepository.save(security);
    }

    @Transactional
    @Override
    public int saveAll(List<Security> securities) {
        int counter = securities.size();
        securities.removeIf(security -> securitiesRepository.getBySecID(security.getSecID()) != null);
        return counter - securitiesRepository.saveAll(securities).size();
    }
}
