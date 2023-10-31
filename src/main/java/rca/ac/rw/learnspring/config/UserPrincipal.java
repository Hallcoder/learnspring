package rca.ac.rw.learnspring.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import rca.ac.rw.learnspring.user.Role;
import rca.ac.rw.learnspring.user.User;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class UserPrincipal implements UserDetails {
    private UUID id;

    private String firstName;
    private String lastName;
    private String name;
    private String telephone;
    private String email;

    public static UserDetails create(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role -> {
            return new SimpleGrantedAuthority(role.name());
        }).collect(Collectors.toList());

        return new UserPrincipal(user.getId(),user.getFirstName(), user.getLastName(), user.getName(), user.getTelephone(), user.getEmail());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
