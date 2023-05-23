package com.trip.mukja.service.impl;

import com.trip.mukja.model.dto.SidoGugunCodeDto;
import com.trip.mukja.model.dto.ReviewDTO;
import com.trip.mukja.model.dto.SearchDTO;
import com.trip.mukja.model.mapper.ReviewMapper;
import com.trip.mukja.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service

@Slf4j
public class ReviewServiceImpl implements ReviewService {

    private ReviewMapper reviewMapper;

    public ReviewServiceImpl(ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
    }


    @Override
    public List<SidoGugunCodeDto> getGugun(int sidoCode) throws SQLException {
        return null;
    }

    @Override
    public List<SearchDTO> getSearchList(Map<String, Object> map) throws SQLException {
        return reviewMapper.getSearchList(map);
    }

    @Override
    public int getRatingCount(int contentId) throws SQLException {
        return reviewMapper.getRatingCount(contentId);
    }

    @Override
    public int getAvgRating(int contentId) throws SQLException {
        return reviewMapper.getAvgRating(contentId);
    }

    @Override
    public SearchDTO getTour(int contentId) throws SQLException {
        return reviewMapper.getTour(contentId);
    }

    @Override
    public List<ReviewDTO> getReviewList(int contentId) throws SQLException {
        return reviewMapper.getReviewList(contentId);
    }

    @Override
    public ReviewDTO getMyReview(Map<String, Object> map) throws SQLException {
        return reviewMapper.getMyReview(map);
    }

    @Override
    public void writeReview(ReviewDTO reviewDTO) throws SQLException {
        reviewMapper.writeReview(reviewDTO);
    }

    @Override
    public void modifyReview(ReviewDTO reviewDTO) throws SQLException {
        reviewMapper.modifyReview(reviewDTO);
    }

    @Override
    public ReviewDTO getReview(int reviewId) throws SQLException {
        return reviewMapper.getReview(reviewId);
    }

    @Override
    public void deleteReview(int reviewId) throws SQLException {
        reviewMapper.deleteReview(reviewId);
    }

    @Override
    public List<SidoGugunCodeDto> getSido() throws Exception {
        List<SidoGugunCodeDto> test = reviewMapper.getSido();
        log.info("test : {}",test.toString());
        return test;
    }

    @Override
    public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
        return reviewMapper.getGugunInSido(sido);
    }
}
