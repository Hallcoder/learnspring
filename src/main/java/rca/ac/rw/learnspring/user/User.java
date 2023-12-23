package rca.ac.rw.learnspring.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;

@Data //provide equivalent of getter and setters
@Builder //will help build the object in an easy way
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user") //to avoid ambiguity or same name as postgres default user table
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String name;
    private String telephone;
    private String password; //we have a field, so we don't need to override the getPassword method
    private Set<Role> roles  = new HashSet<>();

}
