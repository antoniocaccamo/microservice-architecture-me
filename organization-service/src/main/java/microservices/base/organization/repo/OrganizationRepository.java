package microservices.base.organization.repo;

/**
 * Created by antonio on 29/06/2019.
 */
import microservices.base.organization.model.Organization;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class OrganizationRepository {

    private List<Organization> organizations = new ArrayList<>();

    public Organization add(Organization organization) {
        organization.setId((long) (organizations.size()+1));
        organizations.add(organization);
        return organization;
    }

    public Organization findById(Long id) {
        Optional<Organization> organization = organizations.stream().filter(a -> a.getId().equals(id)).findFirst();
        if (organization.isPresent())
            return organization.get();
        else
            return null;
    }

    public List<Organization> findAll() {
        return organizations;
    }

}
