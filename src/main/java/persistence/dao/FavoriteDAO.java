package persistence.dao;

import java.util.List;

import service.dto.Favorite;
import service.dto.Product;
import service.dto.User;

public interface FavoriteDAO {

	void insertFavorite(Favorite favorite);

	void deleteFavorite(Favorite favorite);

	List<Favorite> findUserIdListByFavorite(Favorite favorite);
	
	List<User> findSimilarListByUser(User user);
}
