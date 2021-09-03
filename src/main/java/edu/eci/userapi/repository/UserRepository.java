package edu.eci.userapi.repository;

import edu.eci.userapi.repository.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserRepository
    extends MongoRepository<User, String>
{
    Optional<User> findByEmail( String email );

    @Query("{ $or: [ {'name': { $regex: ?0 } }, { 'lastName': { $regex: ?0 } } ] }")
    List<User> findUsersWithNameOrLastNameLike(String queryText);

    List<User> findUserDocumentByCreatedAtAfter(Date startDate);
}
