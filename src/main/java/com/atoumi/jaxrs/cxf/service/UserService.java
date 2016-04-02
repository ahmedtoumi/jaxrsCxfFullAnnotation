package com.atoumi.jaxrs.cxf.service;

import javax.ws.rs.core.Response;

import com.atoumi.jaxrs.cxf.entity.User;

import java.util.Collection;

public interface UserService {

    Collection<User> getUsers();

    User getUser(Integer id);

    Response add(User user);

}