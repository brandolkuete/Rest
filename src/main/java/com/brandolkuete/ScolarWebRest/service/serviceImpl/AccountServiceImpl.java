package com.brandolkuete.ScolarWebRest.service.serviceImpl;

import com.brandolkuete.ScolarWebRest.dto.RoleDto;
import com.brandolkuete.ScolarWebRest.dto.UseDto;
import com.brandolkuete.ScolarWebRest.dto.mapper.RoleMapper;
import com.brandolkuete.ScolarWebRest.dto.mapper.UserMapper;
import com.brandolkuete.ScolarWebRest.entities.Role;
import com.brandolkuete.ScolarWebRest.entities.User;
import com.brandolkuete.ScolarWebRest.repository.RoleRepository;
import com.brandolkuete.ScolarWebRest.repository.UserRepository;
import com.brandolkuete.ScolarWebRest.service.AccountService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional // car les méthodes sont transactionnelles
public class AccountServiceImpl implements AccountService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;

    public AccountServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper, RoleMapper roleMapper) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public UseDto enregistrerUser(UseDto user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userMapper.toDto(userRepository.save(userMapper.toEntity(user)));
    }

    @Override
    public RoleDto enregistrerRole(RoleDto role) {
        return roleMapper.toDto(roleRepository.save(roleMapper.toEntity(role)));
    }

    @Override
    public void addRoleToUser(String username, String role) {
        User user = userRepository.findByUsername(username);
        Role role1 = roleRepository.findByRole(role);
        user.getRoles().add(role1);
    }

    @Override
    public UseDto findUserByUsername(String username) {
        return userMapper.toDto(userRepository.findByUsername(username));
    }
}
