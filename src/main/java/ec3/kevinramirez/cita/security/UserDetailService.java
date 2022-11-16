package ec3.kevinramirez.cita.security;

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

import ec3.kevinramirez.cita.model.UsuarioCliente;
import ec3.kevinramirez.cita.repository.UsuarioClienteRepository;



@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	private UsuarioClienteRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UsuarioCliente usu = repository.findByUsuario(username);
		
		if(usu != null) {
			
			List<GrantedAuthority> listGranted = new ArrayList<>();
			GrantedAuthority granted = new SimpleGrantedAuthority(usu.getRol());
			listGranted.add(granted);
			
			return new User(
					usu.getUsuario(),
					usu.getPassword(),
					listGranted);
		}else {
			throw new UsernameNotFoundException("Usuario no existe " + username);
		}
		
		
	}
}
