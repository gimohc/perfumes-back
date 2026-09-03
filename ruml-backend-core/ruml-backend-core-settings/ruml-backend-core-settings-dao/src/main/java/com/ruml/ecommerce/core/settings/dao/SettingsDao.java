package com.ruml.ecommerce.core.settings.dao;
import com.ruml.ecommerce.core.shared.dao.Dao;
import com.ruml.ecommerce.core.settings.identity.SettingsIdentity;
import java.util.Optional;
public interface SettingsDao extends Dao<SettingsIdentity, SettingsCreator, SettingsUpdater> {
    Optional<SettingsIdentity> getSettings();
}
