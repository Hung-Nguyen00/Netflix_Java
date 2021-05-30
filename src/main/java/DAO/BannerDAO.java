package DAO;
import connect.DBConnect1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import model.Banner;
import model.Movie;

public class BannerDAO {
	
	public ArrayList<Banner> getListBanner() throws SQLException {
		Connection connection = DBConnect1.getConnecttion();
		String sql = "SELECT *, DATE_FORMAT(last_update, '%d-%m-%Y') new_last_update FROM banner";//SELECT * FROM netflix.category WHERE menu_id = '"+ menu_id +"';
		PreparedStatement ps = connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Banner> list = new ArrayList<>();
		while (rs.next()) {
			Banner Banner = new Banner();
			Banner.setBanner_id(rs.getByte("banner_id"));
			Banner.setMenu_id(rs.getByte("menu_id"));
			Banner.setMovie_id(rs.getInt("movie_id"));
			Banner.setLast_update(rs.getString("new_last_update"));
			list.add(Banner);
		}
		return list;
	}
	
	public Movie getMovieBannerOfMenu(byte menu_id) throws SQLException {
		Connection connection = DBConnect1.getConnecttion();
		String sql = "select m.* from netflix.banner as b "
				+ "join netflix.movie as m on m.movie_id = b.movie_id where b.menu_id = '"+ menu_id +"' ";
		PreparedStatement ps = connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery();
		Movie actor = new Movie();
		while (rs.next()) {
			actor.setMovieId(rs.getInt("m.movie_id"));
			actor.setNameMovie(rs.getString("m.name_movie"));
			actor.setDescriptionMovie(rs.getString("m.description_movie"));
			actor.setImage(rs.getString("m.image"));
			actor.setTrailer(rs.getString("m.trailer"));
			actor.setVideo(rs.getString("m.video"));
			actor.setLo(rs.getString("m.lo"));
			actor.setMaturityRating(rs.getString("m.maturity_rating"));
			actor.setLastUpdate(rs.getDate("m.last_update"));
			actor.setDuration(rs.getString("m.duration"));
			actor.setTopHot(rs.getByte("m.top_hot"));
		}
		return actor;
	}

	
	public boolean checkBannerHasMovie(int movie_id) throws SQLException{
		Connection connection = DBConnect1.getConnecttion();
		String sql = "Select * from movie as sm where sm.movie_id in"
				+ "(Select movie_id from banner as sm1 where sm.movie_id = sm1.movie_id)"
				+ "and sm.movie_id = '"+ movie_id +"'";
		PreparedStatement ps;
		try {
			 ps = connection.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				connection.close();
				return true;
			}	
		} catch (Exception e) {
		}
		return false;
	}
//	public Banner getBanner(int Banner_id) throws SQLException {
//		Connection connection = DBConnect1.getConnecttion();
//		String sql = "SELECT * FROM Banner WHERE Banner_id = '" + Banner_id + "'";
//		PreparedStatement ps = connection.prepareCall(sql);
//		ResultSet rs = ps.executeQuery();
//		Banner Banner = new Banner();
//		while (rs.next()) {
//			Banner.setFirstName(rs.getString("first_name"));
//			Banner.setLastName(rs.getString("last_name"));
//			Banner.setDirector(rs.getByte("director"));
//			Banner.setBannerId(rs.getInt("Banner_id"));
//		}
//		return Banner;
//	}

	public boolean update(Banner c) throws SQLException {
		try {
		Connection connection = DBConnect1.getConnecttion();
		String sql = "UPDATE banner SET movie_id = ?, last_update = ?  WHERE banner_id = ? and menu_id = ?";
		PreparedStatement ps = connection.prepareCall(sql);
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		ps.setInt(1, c.getMovie_id());
		ps.setDate(2, sqlDate);
		ps.setInt(3, c.getBanner_id());
		ps.setInt(4, c.getMenu_id());
		int temp = ps.executeUpdate();
		return temp == 1;
		} catch (Exception e) {
		return false;
		}
	}		
	
	public static void main(String[] args) throws SQLException {
			BannerDAO dao = new BannerDAO();
			
			System.out.println(dao.getMovieBannerOfMenu((byte)0).getMovieId());
			
	}
		
			
}