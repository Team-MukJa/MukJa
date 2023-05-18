package com.trip.mukja.model.mapper;

import com.trip.mukja.model.dto.GugunDTO;
import com.trip.mukja.model.dto.ReviewDTO;
import com.trip.mukja.model.dto.SearchDTO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface ReviewMapper {
	List<GugunDTO> getGugun(int sidoCode) throws SQLException;
	List<SearchDTO> getSearchList(Map<String, Object> params) throws SQLException;
	int getRatingCount(int contentId) throws SQLException;
	int getAvgRating(int contentId) throws SQLException;
	SearchDTO getTour(int contentId) throws SQLException;
	List<ReviewDTO> getReviewList(int contentId) throws SQLException;
	ReviewDTO getMyReview(Map<String, Object> params) throws SQLException;
	void writeReview(ReviewDTO reviewDTO) throws SQLException;
	void modifyReview(ReviewDTO reviewDTO) throws SQLException;
	ReviewDTO getReview(int reviewId) throws SQLException;
	void deleteReview(int reviewId) throws SQLException;
}
