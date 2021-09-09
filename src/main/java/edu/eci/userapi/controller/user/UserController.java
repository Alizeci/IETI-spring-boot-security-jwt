package edu.eci.userapi.controller.user;

import edu.eci.userapi.repository.document.User;
import edu.eci.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping( "/v1/user" )
public class UserController
{

    private final UserService userService;

    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
    }

    @GetMapping
    public List<User> all()
    {
        return userService.all();
    }

    @GetMapping( "/{id}" )
    public User findById( @PathVariable String id )
    {
        return userService.findById( id );
    }

    @GetMapping("/nameOrLastName/{queryText}")
    public ResponseEntity<List<User>> findUsersWithNameOrLastNameLike(@PathVariable String queryText) {
        return ResponseEntity.ok(userService.findUsersWithNameOrLastNameLike(queryText));
    }

    @GetMapping("/createdAfter/{startDate}")
    public ResponseEntity<List<User>> findUsersCreatedAfter(@PathVariable String startDate) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        return ResponseEntity.ok(userService.findUsersCreatedAfter(date));
    }

    @PostMapping
    public ResponseEntity<User> create( @RequestBody UserDto userDto )
    {
        return ResponseEntity.ok( userService.create( userDto ) );
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<User> update( @RequestBody UserDto userDto, @PathVariable String id )
    {
        return ResponseEntity.ok( userService.update( userDto, id ) );
    }

    @DeleteMapping( "/{id}" )
    @RolesAllowed("ADMIN")
    public ResponseEntity<Boolean> delete( @PathVariable String id )
    {
        return ResponseEntity.ok( userService.deleteById( id ) );
    }

}
