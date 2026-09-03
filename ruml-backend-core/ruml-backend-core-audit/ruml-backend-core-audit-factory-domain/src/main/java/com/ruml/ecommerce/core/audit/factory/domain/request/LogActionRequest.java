package com.ruml.ecommerce.core.audit.factory.domain.request;
public record LogActionRequest(String adminName, String role, String actionEn, String actionAr, String targetEn, String targetAr, String type) {}
