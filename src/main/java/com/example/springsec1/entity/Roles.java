package com.example.springsec1.entity;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public enum Roles {
    ADMIN(Arrays.asList(Permission.ADD,Permission.UPDATE,Permission.CREATE,Permission.DELETE,Permission.VIEW)),
    USER(Arrays.asList(Permission.VIEW));

    private final List<Permission> permissions;

    Roles(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }
}
