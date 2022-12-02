package stewart.jonathan.security1.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import stewart.jonathan.security1.auth.ApplicationUserDao;

@Service
public class UserService implements UserDetailsService {

    private final ApplicationUserDao applicationUserDao;

    @Autowired
    public UserService(@Qualifier("fake") ApplicationUserDao applicationUserDao) {
        this.applicationUserDao = applicationUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserDao.selectApplicationUserByUsername(username)
                .orElseThrow (() ->
                        new UsernameNotFoundException(String.format("Username %s not found", username)));
    }
}
