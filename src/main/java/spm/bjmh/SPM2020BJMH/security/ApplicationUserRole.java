package spm.bjmh.SPM2020BJMH.security;

import com.google.common.collect.Sets;

import java.util.Set;


import static spm.bjmh.SPM2020BJMH.security.ApplicationUserPermission.*;


public enum ApplicationUserRole {
    //set the permission that each role have
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(COURSE_READ, STUDENT_READ));

    private final Set<spm.bjmh.SPM2020BJMH.security.ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<spm.bjmh.SPM2020BJMH.security.ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<spm.bjmh.SPM2020BJMH.security.ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
