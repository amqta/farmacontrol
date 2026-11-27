package com.farmalink.farmacontrol.entities.enums;

import java.util.EnumSet;
import java.util.Set;

public enum Profile {
    ATTENDANT(EnumSet.of(Permission.SELL, Permission.ISSUE_INVOICE)),

    PHARMACIST(EnumSet.of(Permission.SELL, Permission.ISSUE_INVOICE, Permission.SELL_CONTROLLED)),

    MANAGER(EnumSet.of(Permission.MANAGE_PRODUCTS, Permission.MANAGE_PURCHASES, Permission.MANAGE_SUPPLIERS, Permission.MANAGE_STOCK));

    private final Set<Permission> permissions;

    Profile(EnumSet<Permission> permissions) {
        this.permissions = permissions;
    }

    public boolean has(Permission permission) {
        return permissions.contains(permission);
    }
}
