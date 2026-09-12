package com.ruml.ecommerce.core.shared.usecase.context;

public class RequesterContextHolder {

    private static final ThreadLocal<RequesterContext> CONTEXT = new ThreadLocal<>();

    public static void setContext(RequesterContext context) {
        CONTEXT.set(context);
    }

    public static RequesterContext getContext() {
        return CONTEXT.get();
    }

    public static void clearContext() {
        CONTEXT.remove();
    }
}
