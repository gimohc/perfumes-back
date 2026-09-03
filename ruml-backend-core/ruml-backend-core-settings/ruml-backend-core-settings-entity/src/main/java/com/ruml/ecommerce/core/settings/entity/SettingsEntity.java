package com.ruml.ecommerce.core.settings.entity;
import com.ruml.ecommerce.core.shared.entity.Entity;
import com.ruml.ecommerce.core.settings.identity.SettingsIdentity;
public class SettingsEntity extends Entity implements SettingsIdentity {
    private String addressEn, addressAr, mobile, supportEmail, cliqAlias;
    @Override public String addressEn() { return addressEn; }
    @Override public String addressAr() { return addressAr; }
    @Override public String mobile() { return mobile; }
    @Override public String supportEmail() { return supportEmail; }
    @Override public String cliqAlias() { return cliqAlias; }
}
