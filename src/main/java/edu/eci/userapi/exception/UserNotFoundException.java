package edu.eci.userapi.exception;

import edu.eci.userapi.error.ErrorCodeEnum;
import edu.eci.userapi.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException
    extends InternalServerErrorException
{
    public UserNotFoundException()
    {
        super( new ServerErrorResponseDto( "User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND ),
               HttpStatus.NOT_FOUND );
    }
}
