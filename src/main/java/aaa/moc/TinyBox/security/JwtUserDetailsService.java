package aaa.moc.TinyBox.security;

import aaa.moc.TinyBox.exception.ActorNotFoundException;
import aaa.moc.TinyBox.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private ActorService actorService;

    @Override
    public UserDetails loadUserByUsername(String username) throws ActorNotFoundException {
        return actorService.findOneByNombre(username);
    }
}