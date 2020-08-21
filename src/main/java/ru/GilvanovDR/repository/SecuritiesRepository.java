package ru.GilvanovDR.repository;

import ru.GilvanovDR.model.Security;

import java.util.List;

public interface SecuritiesRepository {
    List<Security> getAll();

    Security get(int secId);

    Security getBySecID(String secId);

    boolean delete(int secId);

    boolean saveAll(List<Security> securities);

    Security save(Security security);
}
