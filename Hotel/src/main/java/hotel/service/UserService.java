package hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.data.UserRepository;
import hotel.entity.User;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;

	public List<User> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }
}
