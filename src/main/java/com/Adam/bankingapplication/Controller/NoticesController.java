package com.Adam.bankingapplication.Controller;

import com.Adam.bankingapplication.DAO.NoticeDAO;
import com.Adam.bankingapplication.Entities.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class NoticesController {

	@Autowired
	NoticeDAO noticeDAO;

	@GetMapping("/notices")
	public ResponseEntity<List<Notice>> getNotices() {
		List<Notice> notices = noticeDAO.getNotices();

		if(notices.size() > 0) {
			return ResponseEntity.ok()
					.cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
					.body(notices);
		}
		return null;
	}
}
