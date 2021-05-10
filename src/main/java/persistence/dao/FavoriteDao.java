package persistence.dao;

import java.util.List;

import service.dto.Favorite;
import service.dto.Product;
import service.dto.User;

public interface FavoriteDao {

	void createFavorite(Favorite favorite);

	void deleteFavorite(Favorite favorite);

	List<Favorite> findUserIdListByFavorite(Favorite favorite);

	List<String> findUserIdListByProduct(Favorite favorite);

	List<Product> findProductListByUserId(Favorite favorite);

	List<Product> findProductListByOrderId(Favorite favorite);

	List<User> findSimilarListByUserId(User user);
}
