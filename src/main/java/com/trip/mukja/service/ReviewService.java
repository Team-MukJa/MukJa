package com.trip.mukja.service;

import com.trip.mukja.model.dto.GugunDTO;
import com.trip.mukja.model.dto.ReviewDTO;
import com.trip.mukja.model.dto.SearchDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ReviewService {

	List<GugunDTO> getGugun(int sidoCode) throws SQLException;
	List<SearchDTO> getSearchList(Map<String, Object> map) throws SQLException;
	int getRatingCount(int contentId) throws SQLException;
	int getAvgRating(int contentId) throws SQLException;
	SearchDTO getTour(int contentId) throws SQLException;
	List<ReviewDTO> getReviewList(int contentId) throws SQLException;
	ReviewDTO getMyReview(Map<String, Object> map) throws SQLException;
	void writeReview(ReviewDTO reviewDTO) throws SQLException;
	void modifyReview(ReviewDTO reviewDTO) throws SQLException;
	ReviewDTO getReview(int reviewId) throws SQLException;
	void deleteReview(int reviewId) throws SQLException;
}
