package com.ruml.ecommerce.core.settings.identity;
import com.ruml.ecommerce.core.shared.identity.Identity;
public interface SettingsIdentity extends Identity {
    String addressEn(); String addressAr();
    String mobile(); String supportEmail();
    String cliqAlias();
}
