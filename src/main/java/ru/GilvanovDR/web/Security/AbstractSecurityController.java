package ru.GilvanovDR.web.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.GilvanovDR.model.Security;
import ru.GilvanovDR.service.SecuritiesService;
import java.util.List;
import static ru.GilvanovDR.util.ValidationUtil.checkNew;

public abstract class AbstractSecurityController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private SecuritiesService securitiesService;

    public List<Security> getAll() {
        log.info("getAll");
        return securitiesService.getAll();
    }

    public Security get(int id) {
        log.info("get {}", id);
        return securitiesService.get(id);
    }

    public Security create(Security security) {
        log.info("create {}", security);
        checkNew(security);
        return securitiesService.create(security);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        securitiesService.delete(id);
    }

    public void update(Security security) {
        log.info("update {}", security);
        securitiesService.update(security);
    }

    public Security getBySecId(String secId) {
        log.info("getBySecId {}", secId);
        return securitiesService.getBySecId(secId);
    }
}
