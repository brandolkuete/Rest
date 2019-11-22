package com.brandolkuete.ScolarWebRest.service;

import com.brandolkuete.ScolarWebRest.dto.RoleDto;
import com.brandolkuete.ScolarWebRest.dto.UseDto;
import com.brandolkuete.ScolarWebRest.entities.Role;
import com.brandolkuete.ScolarWebRest.entities.User;

public interface AccountService {
    public UseDto enregistrerUser(UseDto user);
    public RoleDto enregistrerRole(RoleDto role);
    public void addRoleToUser(String username, String role);
    public UseDto findUserByUsername(String username);
}
