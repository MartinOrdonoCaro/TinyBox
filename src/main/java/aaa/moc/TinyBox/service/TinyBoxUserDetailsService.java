package aaa.moc.TinyBox.service;

import aaa.moc.TinyBox.exception.ActorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class TinyBoxUserDetailsService implements UserDetailsService {

    @Autowired
    private ActorService actorService;

    @Override
    public UserDetails loadUserByUsername(String username) throws ActorNotFoundException {
        return actorService.findOneByNombre(username);
    }
}
