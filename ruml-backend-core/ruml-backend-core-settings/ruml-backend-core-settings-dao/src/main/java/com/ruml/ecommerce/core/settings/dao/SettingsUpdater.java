package com.ruml.ecommerce.core.settings.dao;
import com.ruml.ecommerce.core.shared.dao.Updater;
import com.ruml.ecommerce.core.settings.identity.SettingsIdentity;
public interface SettingsUpdater extends Updater<SettingsIdentity> {
    SettingsUpdater addressEn(String v); SettingsUpdater addressAr(String v);
    SettingsUpdater mobile(String v); SettingsUpdater supportEmail(String v);
    SettingsUpdater cliqAlias(String v);
}
