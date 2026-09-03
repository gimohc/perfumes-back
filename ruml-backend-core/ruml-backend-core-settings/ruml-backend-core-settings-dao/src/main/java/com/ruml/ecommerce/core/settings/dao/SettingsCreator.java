package com.ruml.ecommerce.core.settings.dao;
import com.ruml.ecommerce.core.shared.dao.Creator;
import com.ruml.ecommerce.core.settings.identity.SettingsIdentity;
public interface SettingsCreator extends Creator<SettingsIdentity> {
    SettingsCreator addressEn(String v); SettingsCreator addressAr(String v);
    SettingsCreator mobile(String v); SettingsCreator supportEmail(String v);
    SettingsCreator cliqAlias(String v);
}
