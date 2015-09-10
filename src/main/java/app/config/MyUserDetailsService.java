package app.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.models.Role;
import app.models.UserRepository;

@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		app.models.User user = userRepository.findByUsername(username);
		
		List<GrantedAuthority> authorities = this.buildUserAuthority(user.getRoles());
		
		return this.buildUserForAuthentication(user, authorities);
	}
	
	// convert an app.models.User to an org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(app.models.User user, List<GrantedAuthority> authorities){
		
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
		
	}
	
	// get all user's permissions and convert to a GrantedAuthority array
	private List<GrantedAuthority> buildUserAuthority(List<Role> userRoles){
		
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
		
		for(Role role : userRoles){
			result.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return result;
		
	}
	

}
