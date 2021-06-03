package dubby.serve.xfood.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dubby.serve.xfood.domain.account.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

    private final Long id;
    private final String username;
    private final String firstName;
    private final String lastName;
    @JsonIgnore
    private final String password;
    private SecureAccount secureAccount;
    private final ContactDetails contactDetails;
    private final Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id, String username, String firstName, String lastName, String password,
                         SecureAccount secureAccount, ContactDetails contactDetails,
                         Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.secureAccount = secureAccount;
        this.contactDetails = contactDetails;
        this.authorities = authorities;
    }

    public static UserPrincipal create(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role
                -> new SimpleGrantedAuthority(role.getRoleType().name())
        ).collect(Collectors.toList());

        return new UserPrincipal (
                user.getId(), user.getKnownAs(), user.getFirstName(), user.getLastName(), user.getPassword(),
                user.getSecureAccount(),
                user.getContactDetails(), authorities
        );
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return secureAccount.getAccountNonExpired().getAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return secureAccount.getAccountNonLocked().getAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return secureAccount.getCredentialsNonExpired().getCredentialsExpired();
    }

    @Override
    public boolean isEnabled() {
        return secureAccount.getAccountEnabled().getEnabled();
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public SecureAccount getSecureAccount() {
        return secureAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
