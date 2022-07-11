package com.mashibing.result;

public class Permission {
    private String permissionId;

    public Permission(String permissionId) {
        this.permissionId = permissionId;
    }

    public Permission() {
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "permission{" +
                "permissionId='" + permissionId + '\'' +
                '}';
    }
}
