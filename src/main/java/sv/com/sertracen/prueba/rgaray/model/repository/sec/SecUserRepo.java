package sv.com.sertracen.prueba.rgaray.model.repository.sec;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.com.sertracen.prueba.rgaray.model.entity.sec.SecUser;

public interface SecUserRepo extends JpaRepository<SecUser, Long> {

	public SecUser findBySecUserUsernameAndSecUserPassword(String username, String password);

}
