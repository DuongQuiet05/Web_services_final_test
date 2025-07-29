package com.duong.finaltest.sercurity.principal;


import com.duong.finaltest.model.entity.Customer;
import com.duong.finaltest.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerDetailService implements UserDetailsService {
    private final CustomerRepo customerRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer c = customerRepo.findCustomerByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username không tồn tại"));
        return new CustomerPrincipal(c);
    }
}

