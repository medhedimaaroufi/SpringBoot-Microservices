package tn.ensit.engagementservice.Clients;

import org.springframework.stereotype.Component;

@Component
public class UserClient {
    public Long findById(Long authorId) {

        return authorId;
    }
}
