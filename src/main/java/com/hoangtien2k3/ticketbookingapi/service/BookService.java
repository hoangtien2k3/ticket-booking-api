package com.hoangtien2k3.ticketbookingapi.service;

import com.hoangtien2k3.ticketbookingapi.entity.Book;
import com.hoangtien2k3.ticketbookingapi.dao.ResponseData;
import com.hoangtien2k3.ticketbookingapi.repository.BookRepository;
import com.hoangtien2k3.ticketbookingapi.repository.UserRepository;
import com.hoangtien2k3.ticketbookingapi.request.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseData<Book> bookTicket(Authentication authentication, BookRequest bookRequest){
        Integer userId = userRepository.findIdByUsername(authentication.getName());
        if(bookRequest == null){
            return new ResponseData(HttpStatus.FOUND, "booking ticket failed", null);
        }else{
            Integer rs = bookRepository.bookTicket(userId, bookRequest.getScheduleId(), bookRequest.getSeatId(), bookRequest.getPrice(), bookRequest.getSeatStatus());
            return new ResponseData(HttpStatus.OK, "successfully", rs);
        }
    }

    public ResponseData<Integer> updateStatus(Authentication authentication, Integer book_id){

        Integer userId = userRepository.findIdByUsername(authentication.getName());
        Double point = userRepository.getPoint(userId);
        userRepository.addPoint(point + 10, userId);

        return new ResponseData(HttpStatus.OK, "book running", bookRepository.updateStatus(userId, book_id));
    }

}
