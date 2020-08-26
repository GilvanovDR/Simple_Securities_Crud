package ru.GilvanovDR.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.GilvanovDR.model.Security;
import ru.GilvanovDR.repository.SecuritiesRepository;

import java.util.List;

import static ru.GilvanovDR.util.ValidationUtil.checkNotFound;
import static ru.GilvanovDR.util.ValidationUtil.checkNotFoundWithId;

@Service
public class SecuritiesService {
    private final SecuritiesRepository securitiesRepository;

    public SecuritiesService(SecuritiesRepository securitiesRepository) {
        this.securitiesRepository = securitiesRepository;
    }

    public Security create(Security security) {
        Assert.notNull(security, "security must not be null");
        return checkNotFound(securitiesRepository.save(security), "Duplicate SecID");
    }

    public void delete(int id) {
        checkNotFoundWithId(securitiesRepository.delete(id), id);
    }

    public Security get(int id) {
        return checkNotFoundWithId(securitiesRepository.get(id), id);
    }

    public Security getBySecId(String secId) {
        return checkNotFound(securitiesRepository.getBySecID(secId), "SecId is not Exist");
    }

    public List<Security> getAll() {
        return securitiesRepository.getAll();
    }

    public void update(Security security) {
        Assert.notNull(security, "security must not be null");
        checkNotFoundWithId(securitiesRepository.save(security), security.id());
    }
}
