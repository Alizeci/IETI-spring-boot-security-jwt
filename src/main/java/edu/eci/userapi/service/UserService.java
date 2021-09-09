package edu.eci.userapi.service;

import edu.eci.userapi.controller.user.UserDto;
import edu.eci.userapi.exception.UserNotFoundException;
import edu.eci.userapi.repository.document.User;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface UserService
{
    User create( UserDto userDto );

    User findById( String id )
        throws UserNotFoundException;

    User findByEmail( String email )
        throws UserNotFoundException;

    List<User> all();

    boolean deleteById( String id );

    User update( UserDto userDto, String id );

    List<User> findUsersWithNameOrLastNameLike(String queryText);

    List<User> findUsersCreatedAfter(Date startDate);
}
