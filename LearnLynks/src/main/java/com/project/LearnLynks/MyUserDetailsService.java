//import org.springframework.stereotype.Service;
//
//import com.project.LearnLynks.models.Users;
//import com.project.LearnLynks.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//import static org.apache.catalina.realm.UserDatabaseRealm.getRoles;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Users> usersOptional = userRepository.findByUsername(username);
//        if (usersOptional.isPresent()) {
//            var ourUser = usersOptional.get();
//            return User.builder()
//                    .username(ourUser.getUsername())
//                    .password(ourUser.getPassword())
//                    .roles(getRoles(ourUser))
//                    .build();
//        } else {
//            throw new UsernameNotFoundException(username);
//        }
//    }
//}
